package com.distarise.credaegis.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.adapters.FrameworkInterceptor;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.credaegis.constants.CibilConstants;
import com.distarise.credaegis.dao.LeadDao;
import com.distarise.credaegis.model.CredaegisContextDto;
import com.distarise.credaegis.model.LeadDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SaveAccountAction extends AbstractBaseAction implements BaseAction {
    @Autowired
    private LeadDao leadDao;

    @Autowired
    private LoadAnalysisReportAction loadAnalysisReportAction;

    private static final Logger logger = LoggerFactory.getLogger(SaveAccountAction.class);

    @Override
    public void executeAction(){

        String pid = request.getParameter("pid");
        String leadid = request.getParameter("leadid");
        String accountName = request.getParameter("accountName");
        String accountNo = request.getParameter("accountNo");
        String accountType = request.getParameter("accountType");
        String ownership = request.getParameter("ownership");
        String sanctionedAmount = request.getParameter("sanctionedAmount");
        String currentBalance = request.getParameter("currentBalance");
        String amountOverdue = request.getParameter("amountOverdue");
        String dateReportedStr = request.getParameter("dateReported");
        String creditStatus = request.getParameter("creditStatus");
        String writtenOffAmountTotal = request.getParameter("writtenOffAmountTotal");
        String writtenOffAmountPrincipal = request.getParameter("writtenOffAmountPrincipal");
        String suitFiled = request.getParameter("suitFiled");
        String settlementAmount = request.getParameter("settlementAmount");
        String highCredit = request.getParameter("highCredit");
        String lastPaymentDone = request.getParameter("lastPaymentDone");
        String recentDpd = request.getParameter("recentDpd");
        Date dateReported = new Date();
        if (null != dateReportedStr && !dateReportedStr.isEmpty()){
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                dateReported = format.parse(dateReportedStr);
            } catch (Exception e){
                logger.debug("Date reported format error - "+dateReportedStr);
            }
        }
        CredaegisContextDto context = (CredaegisContextDto) request.getSession().getAttribute(CibilConstants.CREDAEGIS_CONTEXT);
        LeadDto leadDto = new LeadDto();
        if (null == pid || pid.isEmpty()){
            leadDto.setPid(context.getPid());
        }
        else {
            leadDto.setPid(Long.parseLong(pid));
        }
        leadDto.setSuitFiled(suitFiled);
        leadDto.setSettlementAmount(Long.parseLong(settlementAmount));
        leadDto.setWrittenOffAmountPrincipal(Long.parseLong(writtenOffAmountPrincipal));
        leadDto.setWrittenOffAmountTotal(Long.parseLong(writtenOffAmountTotal));
        leadDto.setDateReported(dateReported);
        leadDto.setAccountNo(accountNo);
        leadDto.setStatus(creditStatus);
        leadDto.setAccountName(accountName);
        leadDto.setLid(leadid.isEmpty() ? null : Long.parseLong(leadid));
        leadDto.setAccountType(accountType);
        leadDto.setProblemStatement(recentDpd);
        leadDto.setLatestPaymentDone(lastPaymentDone);
        leadDto.setAmountOverdue(Long.parseLong(amountOverdue));
        leadDto.setCurrentBalance(Long.parseLong(currentBalance));
        leadDto.setSanctionedAmount(Long.parseLong(sanctionedAmount));
        leadDto.setOwnership(ownership);
        leadDto.setCreditStatus(creditStatus);
        leadDto.setHighCredit(Long.parseLong(highCredit));

        leadDao.save(leadDto);

        loadAnalysisReportAction.executeAction(request);
        loadAnalysisReportAction.executeAction();

    }

}
