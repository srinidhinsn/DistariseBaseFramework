package com.distarise.distabank.deposit.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.deposit.model.DistabankContext;
import com.distarise.distabank.deposit.model.FixedDepositConfigDto;
import com.distarise.distabank.deposit.service.FixedDepositConfigService;
import com.distarise.distabank.util.DistabankUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class SaveFdConfigAction extends AbstractBaseAction {

    private static final Logger logger = LoggerFactory.getLogger(SaveFdConfigAction.class);

    @Autowired
    private FixedDepositConfigService fdConfigService;

    public void executeAction() {
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        DistabankContext context = DistabankContext.getDistabankContext(request, getClientId());
        String fdConfigId = request.getParameter("validfrom");
        String roi = request.getParameter("roi");
        String effectiveDateString = request.getParameter("effectivedate");
        String endDateString = request.getParameter("enddate");
        String calcMethod = request.getParameter("calcmethod");
        String calcFrequency = request.getParameter("calcfrequency");
        String minDuration = request.getParameter("minduration");
        String deviation = request.getParameter("deviation");
        BigDecimal maturityValueDeviation = null;
        if (null == deviation || deviation.isEmpty()){
            maturityValueDeviation = new BigDecimal(1);
        } else {
            maturityValueDeviation = new BigDecimal(deviation);
        }

        Date effectiveDate = DistabankUtils.stringYYYYMMDDToDate(effectiveDateString);
        Date endDate = DistabankUtils.stringYYYYMMDDToDate(endDateString);
        BigDecimal roiDecimal = new BigDecimal(roi);
        FixedDepositConfigDto fdConfig = new FixedDepositConfigDto(context.getClientId(), effectiveDate, endDate, roiDecimal, calcMethod,
                Integer.parseInt(minDuration), maturityValueDeviation, calcFrequency);
        if (null != fdConfigId && !fdConfigId.isEmpty()){
            fdConfig.setId(Long.valueOf(fdConfigId));
            fdConfigService.saveFdConfig(fdConfig);
        }
        else if (fdConfigService.validateFdConfig(fdConfig, targetPageDetailsDto)) {
            fdConfigService.saveFdConfig(fdConfig);
        }
    }

}
