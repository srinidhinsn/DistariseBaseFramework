package com.distarise.distabank.deposit.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.deposit.model.DistabankContext;
import com.distarise.distabank.deposit.model.FixedDepositDto;
import com.distarise.distabank.deposit.service.FixedDepositService;
import com.distarise.distabank.util.CalculationService;
import com.distarise.distabank.util.DepositAccountStatus;
import com.distarise.distabank.util.DistabankUtils;
import com.distarise.distabank.util.InterestCalcFrequency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class SaveFdAction extends AbstractBaseAction {

    private static final Logger logger = LoggerFactory.getLogger(SaveFdAction.class);

    @Autowired
    private FixedDepositService fdService;

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
        FixedDepositDto fd = null;
        if (null != selectedFd) {
          fd = fdService.findById(selectedFd);
        }
        if (null == context.getCustomerId() || context.getCustomerId().equals(0)){
            targetPageDetailsDto.getErrorMessages().add("Select customer before adding FD");
        } else if (null != fd && null != withdrawaldate && !withdrawaldate.isEmpty()){
            BigDecimal finalAmount = calcService.calcFinalAmount(fd.getAmount().toString(), fd.getRoi().toString(),
                    fd.getCalcMethod(), fd.getCalcFrequency(), fd.getEffectiveDate().toString(), withdrawaldate);
            Date withdrawalDate = DistabankUtils.stringYYYYMMDDToDate(withdrawaldate);
            fd.setMaturityValue(finalAmount);
            fd.setWithdrawalDate(withdrawalDate);
            if (fd.getMaturityDate().compareTo(withdrawalDate) == 0 || fd.getMaturityDate().compareTo(withdrawalDate) > 1){
                fd.setStatus(DepositAccountStatus.Ended.name());
            } else {
                fd.setStatus(DepositAccountStatus.PreMatured.name());
            }
            fdService.saveFd(fd);
        } else {
            BigDecimal finalAmount = calcService.calcFinalAmount(amount, roi, calcMethod,
                    calcFrequency, startDate, maturityDate);
            FixedDepositDto fdDto = new FixedDepositDto(context.getClientId(), accountNo, Long.parseLong(customerId), customerName,
                    DistabankUtils.stringYYYYMMDDToDate(startDate), DistabankUtils.stringYYYYMMDDToDate(maturityDate),
                    finalAmount, new BigDecimal(roi), new BigDecimal(amount), amountText, referenceCode,
                    calcMethod, calcFrequency);
            if (null != fd){
                fdDto.setId(fd.getId());
            }
            fdService.saveFd(fdDto);
        }
    }

}
