package com.distarise.distabank.deposit.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.deposit.model.DistabankContext;
import com.distarise.distabank.deposit.model.RecurringDepositConfigDto;
import com.distarise.distabank.deposit.service.RecurringDepositConfigService;
import com.distarise.distabank.util.DistabankUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class SaveRdConfigAction extends AbstractBaseAction {

    private static final Logger logger = LoggerFactory.getLogger(SaveRdConfigAction.class);

    @Autowired
    private RecurringDepositConfigService rdConfigService;

    public void executeAction() {
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        DistabankContext context = DistabankContext.getDistabankContext(request, getClientId());
        String roi = request.getParameter("roi");
        String effectiveDateString = request.getParameter("effectivedate");
        String endDateString = request.getParameter("enddate");
        String calcMethod = request.getParameter("calcmethod");
        String calcFrequency = request.getParameter("calcfrequency");
        String minDuration = request.getParameter("minduration");
        String deviation = request.getParameter("deviation");
        BigDecimal maturityValueDeviation = null;
        if (null == deviation){
            maturityValueDeviation = new BigDecimal(1);
        } else {
            maturityValueDeviation = new BigDecimal(deviation);
        }

        Date effectiveDate = DistabankUtils.stringYYYYMMDDToDate(effectiveDateString);
        Date endDate = DistabankUtils.stringYYYYMMDDToDate(endDateString);
        BigDecimal roiDecimal = new BigDecimal(roi);
        RecurringDepositConfigDto rdConfig = new RecurringDepositConfigDto(context.getClientId(), effectiveDate, endDate, roiDecimal, calcMethod,
                Integer.parseInt(minDuration), maturityValueDeviation, calcFrequency);
        if (rdConfigService.validateRdConfig(rdConfig, targetPageDetailsDto)) {
            rdConfigService.saveRdConfig(rdConfig);
        }
    }

}
