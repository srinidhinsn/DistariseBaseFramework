package com.distarise.distabank.util;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class CalculationService {
    public BigDecimal calcFinalAmount(String amount, String roi, String calcMethod,
                                             String frequency, String startDate, String endDate) {
        if (null != amount && null != roi && null != calcMethod && null != frequency && null != startDate && null != endDate &&
                !amount.isEmpty() && !roi.isEmpty() && !calcMethod.isEmpty() && !frequency.isEmpty() && !startDate.isEmpty() && !endDate.isEmpty()) {
            return calcFinalAmount(Double.valueOf(amount), Double.valueOf(roi), InterestCalcMethod.valueOf(calcMethod),
                    InterestCalcFrequency.valueOf(frequency), DistabankUtils.stringYYYYMMDDToDate(startDate),
                    DistabankUtils.stringYYYYMMDDToDate(endDate));
        } else {
            return new BigDecimal(0);
        }
    }

    public BigDecimal calcFinalAmount(Double amount, Double roi, InterestCalcMethod calcMethod,
                                             InterestCalcFrequency frequency, Date startDate, Date endDate) {
        Long timeDiff = endDate.getTime() - startDate.getTime();
        Long duration = 0L;
        Double finalAmount = null;
        switch (frequency){
            case Daily:
                duration = (timeDiff / (1000*60*60*24)) % 365;
                break;
            case Monthly:
                duration = (timeDiff / (1000*60*60*24*31));
                break;
            case Annually:
                duration = timeDiff / (1000*60*60*24*31*12);
                break;
        }

        switch (calcMethod){
            case Compound_Interest:
                finalAmount = amount * (Math.pow((1d+roi)/100, duration));
                break;
            case Simple_Interest:
                finalAmount = (amount * duration * roi) / 100;
                break;
            default:
        }
        return new BigDecimal(finalAmount);
    }
}
