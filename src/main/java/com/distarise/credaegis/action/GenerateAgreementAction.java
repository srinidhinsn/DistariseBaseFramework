package com.distarise.credaegis.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.credaegis.constants.CibilConstants;
import com.distarise.credaegis.dao.PersonDao;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.PersonDto;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GenerateAgreementAction extends AbstractBaseAction implements BaseAction {

    private static final Logger logger = LoggerFactory.getLogger(GenerateAgreementAction.class);
    @Autowired
    private PersonDao personDao;

    @Autowired
    private LoadAnalysisReportAction loadAnalysisReportAction;

    @Override
    public void executeAction(){
        PersonDto personDto = personDao.findByPid(loadAnalysisReportAction.getPidFromRequest(request));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        PdfOptions pdfOptions = PdfOptions.create();
        try {
            XWPFDocument agreementDoc = new XWPFDocument(Files.newInputStream(Paths.get(CibilConstants.AGREEMENT_TEMPLATE)));
            XWPFDocument creditSummaryDoc = new XWPFDocument(Files.newInputStream(Paths.get(CibilConstants.CREDITSUMMARY_TEMPLATE)));
            List<XWPFParagraph> xwpfParagraphList = agreementDoc.getParagraphs();
            for (XWPFParagraph xwpfParagraph : xwpfParagraphList) {
                for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
                    String docText = xwpfRun.getText(0);
                    //replacement and setting position
                    if (null != docText) {
                        docText = docText.replace("<today>", formatter.format(new Date()));
                        docText = docText.replace("<name>", personDto.getFirstName());
                        docText = docText.replace("<panNo>", personDto.getIdentityList().get(0).getId());
                        docText = docText.replace("<contact>", personDto.getContact());
                        xwpfRun.setText(docText, 0);
                    }
                }
            }
            String name = personDto.getFirstName().replaceAll("/","").replaceAll("\\\\","");
            String agreementPath = CibilConstants.AGREEMENT_STORAGE+formatter.format(new Date())+"/";
            String agreementName = name+"_"+personDto.getIdentityList().get(0).getId()+".pdf";
            String summaryPath = CibilConstants.CREDITSUMMARY_STORAGE+formatter.format(new Date())+"/";
            Files.createDirectories(Paths.get(agreementPath));
            Files.createDirectories(Paths.get(summaryPath));

            generateAccountDetails(creditSummaryDoc, personDto);

            OutputStream agreementOut = new FileOutputStream(agreementPath+agreementName);
            PdfConverter.getInstance().convert(agreementDoc, agreementOut, pdfOptions);

            OutputStream summaryOut = new FileOutputStream(summaryPath+agreementName);
            PdfConverter.getInstance().convert(creditSummaryDoc, summaryOut, pdfOptions);

            personDto.setPath(agreementPath);
            personDto.setFileName(agreementName);
            personDao.save(personDto);
            loadAnalysisReportAction.executeAction(request);
            loadAnalysisReportAction.executeAction();
        } catch (IOException e) {
            logger.error("Agreement template reader error - "+e);
            e.printStackTrace();
        }
    }

    private void generateAccountDetails(XWPFDocument doc, PersonDto personDto){
        List<LeadDto> leadDtoList = personDto.getLeadDtoList();
        List<XWPFTable> tables = doc.getTables();

        for (int leadCount=0; leadCount<leadDtoList.size(); leadCount++){
            XWPFTable table = tables.get(leadCount);
            LeadDto leadDto = leadDtoList.get(leadCount);
            List<XWPFTableRow> rows = table.getRows();
            List<XWPFTableCell> firstRowCells = rows.get(0).getTableCells();
            firstRowCells.get(0).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getAccountName(),0);
            firstRowCells.get(1).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getAccountNo(),0);
            firstRowCells.get(2).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getAccountType(),0);
            firstRowCells.get(3).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getOwnership(),0);

            List<XWPFTableCell> secondRowCells = rows.get(1).getTableCells();
            secondRowCells.get(0).getParagraphs().get(0).getRuns().get(0).setText("Sanctioned Amount",0);
            secondRowCells.get(1).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getSanctionedAmount().toString(),0);
            secondRowCells.get(2).getParagraphs().get(0).getRuns().get(0).setText("High Credit",0);
            secondRowCells.get(3).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getHighCredit().toString(),0);

            List<XWPFTableCell> thirdRowCells = rows.get(2).getTableCells();
            thirdRowCells.get(0).getParagraphs().get(0).getRuns().get(0).setText("Current balance",0);
            thirdRowCells.get(1).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getCurrentBalance().toString(),0);
            thirdRowCells.get(2).getParagraphs().get(0).getRuns().get(0).setText("Amount Overdue",0);
            thirdRowCells.get(3).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getAmountOverdue().toString(),0);

            List<XWPFTableCell> fourthRowCells = rows.get(3).getTableCells();
            fourthRowCells.get(0).getParagraphs().get(0).getRuns().get(0).setText("Date Reported and Certified",0);
            fourthRowCells.get(1).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getDateReported().toString(),0);
            fourthRowCells.get(2).getParagraphs().get(0).getRuns().get(0).setText("Suit filed/Willful default",0);
            if (!leadDto.getSuitFiled().isEmpty()){
                fourthRowCells.get(3).setColor("FF4500");
            }
            fourthRowCells.get(3).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getSuitFiled(),0);


            List<XWPFTableCell> fifthRowCells = rows.get(4).getTableCells();
            fifthRowCells.get(0).getParagraphs().get(0).getRuns().get(0).setText("Credit facility status",0);
            if (!leadDto.getCreditStatus().isEmpty()){
                fifthRowCells.get(1).setColor("FFFF00");
            }
            fifthRowCells.get(1).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getCreditStatus(),0);
            fifthRowCells.get(2).getParagraphs().get(0).getRuns().get(0).setText("Settlement Amount",0);
            fifthRowCells.get(3).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getSettlementAmount().toString(),0);


            List<XWPFTableCell> sixthRowCells = rows.get(5).getTableCells();
            sixthRowCells.get(0).getParagraphs().get(0).getRuns().get(0).setText("Written-off (Total)",0);
            sixthRowCells.get(1).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getWrittenOffAmountTotal().toString(),0);
            sixthRowCells.get(2).getParagraphs().get(0).getRuns().get(0).setText("Written-off (Principal)",0);
            sixthRowCells.get(3).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getWrittenOffAmountPrincipal().toString(),0);


            List<XWPFTableCell> sevenRowCells = rows.get(6).getTableCells();
            sevenRowCells.get(0).getParagraphs().get(0).getRuns().get(0).setText("DPDs",0);
            sevenRowCells.get(1).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getProblemStatement(),0);
            sevenRowCells.get(2).getParagraphs().get(0).getRuns().get(0).setText("Last payment",0);
            sevenRowCells.get(3).getParagraphs().get(0).getRuns().get(0).setText(leadDto.getLatestPaymentDone(),0);
        }

        for (int tableCount= tables.size()-1; tableCount >= leadDtoList.size(); tableCount--){
            XWPFTable table = tables.get(tableCount);
            doc.removeBodyElement(doc.getPosOfTable(table));
        }
    }
}
