package com.distarise.distabank.deposit.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.deposit.model.DistabankContext;
import com.distarise.distabank.deposit.model.FixedDepositDto;
import com.distarise.distabank.deposit.service.FixedDepositService;
import com.distarise.distabank.util.CalculationService;
import com.distarise.distabank.util.DistabankUtils;
import com.distarise.distabank.util.InterestCalcFrequency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SaveFdAction extends AbstractBaseAction implements BaseAction {

    private static final Logger logger = LoggerFactory.getLogger(SaveFdAction.class);

    @Autowired
    private FixedDepositService fdService;

    @Autowired
    private CalculationService calcService;

    public void executeAction() {
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        DistabankContext context = DistabankContext.getDistabankContext(request, getClientId());
        String customerName = request.getParameter("customername");
        String customerId = request.getParameter("customerid");
        String accountNo = request.getParameter("accountno");
        String startDate = request.getParameter("startdate");
        String maturityDate = request.getParameter("maturitydate");
        String roi = request.getParameter("roi");
        String calcMethod = request.getParameter("calcmethod");
        String calcFrequency = request.getParameter("calcfrequency");
        String amount = request.getParameter("amount");
        String amountText = request.getParameter("amounttext");
        String referenceCode = request.getParameter("referencecode");
        String maturityValue = request.getParameter("maturityvalue");
        if (null == context.getCustomerId() || context.getCustomerId().equals(0)){
            targetPageDetailsDto.getErrorMessages().add("Select customer before adding FD");
        } else {
            BigDecimal finalAmount = calcService.calcFinalAmount(amount, roi, calcMethod,
                    calcFrequency, startDate, maturityDate);
            FixedDepositDto fdDto = new FixedDepositDto(context.getClientId(), accountNo, Long.parseLong(customerId), customerName,
                    DistabankUtils.stringYYYYMMDDToDate(startDate), DistabankUtils.stringYYYYMMDDToDate(maturityDate),
                    finalAmount, new BigDecimal(roi), new BigDecimal(amount), amountText, referenceCode,
                    calcMethod, calcFrequency);
            fdService.saveFd(fdDto);
        }
    }

}
