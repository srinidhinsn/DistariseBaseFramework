package com.distarise.distabank.deposit.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.deposit.model.DistabankContext;
import com.distarise.distabank.deposit.model.RecurringDepositDto;
import com.distarise.distabank.deposit.service.RecurringDepositService;
import com.distarise.distabank.util.CalculationService;
import com.distarise.distabank.util.DepositAccountStatus;
import com.distarise.distabank.util.DistabankUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class SaveRdAction extends AbstractBaseAction {

    private static final Logger logger = LoggerFactory.getLogger(SaveRdAction.class);

    @Autowired
    private RecurringDepositService rdService;

    @Autowired
    private CalculationService calcService;

    public void executeAction() {
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        DistabankContext context = DistabankContext.getDistabankContext(request, getClientId());
        String selectedFd = request.getParameter("fdlist");
        String customerName = request.getParameter("customername");
        String customerId = request.getParameter("customerid");
        String accountNo = request.getParameter("accountno");
        String startDate = request.getParameter("startdate");
        String maturityDate = request.getParameter("maturitydate");
        String withdrawaldate = request.getParameter("withdrawaldate");
        String roi = request.getParameter("roi");
        String calcMethod = request.getParameter("calcmethod");
        String calcFrequency = request.getParameter("calcfrequency");
        String amount = request.getParameter("amount");
        String amountText = request.getParameter("amounttext");
        String referenceCode = request.getParameter("referencecode");
        String maturityValue = request.getParameter("maturityvalue");
        RecurringDepositDto rd = null;
        if (null != selectedFd) {
          rd = rdService.findById(selectedFd);
        }
        if (null == context.getCustomerId() || context.getCustomerId().equals(0)){
            targetPageDetailsDto.getErrorMessages().add("Select customer before adding FD");
        } else if (null != rd && null != withdrawaldate && !withdrawaldate.isEmpty()){
            BigDecimal finalAmount = calcService.calcFinalAmount(rd.getAmount().toString(), rd.getRoi().toString(),
                    rd.getCalcMethod(), rd.getCalcFrequency(), rd.getEffectiveDate().toString(), maturityDate);
            Date withdrawalDate = DistabankUtils.stringYYYYMMDDToDate(withdrawaldate);
            rd.setMaturityValue(finalAmount);
            rd.setWithdrawalDate(withdrawalDate);
            if (rd.getMaturityDate().compareTo(withdrawalDate) == 0 || rd.getMaturityDate().compareTo(withdrawalDate) > 1){
                rd.setStatus(DepositAccountStatus.Ended.name());
            } else {
                rd.setStatus(DepositAccountStatus.PreMatured.name());
            }
            rdService.saveRd(rd);
        } else {
            BigDecimal finalAmount = calcService.calcFinalAmount(amount, roi, calcMethod,
                    calcFrequency, startDate, maturityDate);
            RecurringDepositDto rdDto = new RecurringDepositDto(context.getClientId(), accountNo, Long.parseLong(customerId), customerName,
                    DistabankUtils.stringYYYYMMDDToDate(startDate), DistabankUtils.stringYYYYMMDDToDate(maturityDate),
                    finalAmount, new BigDecimal(roi), new BigDecimal(amount), amountText, referenceCode,
                    calcMethod, calcFrequency);
            if (null != rd){
                rdDto.setId(rd.getId());
            }
            rdService.saveRd(rdDto);
        }
    }

}
