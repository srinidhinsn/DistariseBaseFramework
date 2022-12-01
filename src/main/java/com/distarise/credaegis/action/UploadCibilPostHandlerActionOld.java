package com.distarise.credaegis.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.FileUploadDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.FileStorageService;
import com.distarise.credaegis.service.CreditAnalysisCommonService;
import com.distarise.credaegis.service.CreditAnalysisHelperService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class UploadCibilPostHandlerActionOld extends AbstractBaseAction implements BaseAction {

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    CreditAnalysisCommonService creditAnalysisCommonService;

    @Override
    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        WidgetDto widgetDto = super.executeAction(new WidgetDto());
        CreditAnalysisHelperService creditAnalysisHelperService;
        Optional<ComponentDto> docPassword = ComponentDto.filterComponentDtoById(widgetDto.getComponentDtos(), "docpassword");
        Optional<ComponentDto> reportType = ComponentDto.filterComponentDtoById(widgetDto.getComponentDtos(), "reporttype");
        if (!targetPageDetailsDto.getFileUploads().isEmpty()){
            FileUploadDto file = targetPageDetailsDto.getFileUploads().get(0);
            Resource resource = fileStorageService.loadFileAsResource(file.getFileName());
            String docPass = "";

            if (docPassword.isPresent() && null != docPassword.get().getValue() &&
                    !docPassword.get().getValue().isEmpty()){
                docPass = docPassword.get().getValue();
            }
            try (PDDocument document = PDDocument.load(resource.getFile(),docPass)) {
                document.setAllSecurityToBeRemoved(true);
                document.getClass();

                /*

                Read PDF line by line. Still few account numbers which jumps to next line is missed out.

                GetLinesFromPDF getLines = new GetLinesFromPDF();
                List<String> lines = getLines.getAllLines(document);

                for(String line:lines){
                    System.out.println(line);
                }


                 */


                /*

                Read whole PDF as a Text. Alignment misses a lot

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                //creditAnalysisCommonService.processCreditReport(reportType.get().getValue(), pdfFileInText);
                    // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    System.out.println(line);
                }
                */
            } catch (InvalidPasswordException e) {
                System.out.println("Invalid password");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
