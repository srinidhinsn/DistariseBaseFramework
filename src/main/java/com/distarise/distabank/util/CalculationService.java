package com.distarise.distabank.util;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.joda.time.Years;
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
        LocalDate sdLocalDate = new LocalDate(startDate.getTime());
        LocalDate edLocalDate = new LocalDate(endDate.getTime());
        int duration=0;
        Double durationInDecimal =0d;
        Double finalAmount = null;
        switch (frequency){
            case Daily:
                duration = Days.daysBetween(sdLocalDate, edLocalDate).getDays();
                break;
            case Monthly:
                duration = Months.monthsBetween(sdLocalDate, edLocalDate).getMonths();
                break;
            case Annually:
                duration = Years.yearsBetween(sdLocalDate, edLocalDate).getYears();
                if (0 == duration){
                    durationInDecimal = Double.valueOf(Months.monthsBetween(sdLocalDate, edLocalDate).getMonths()) / 12;
                    durationInDecimal = Double.valueOf(Math.round(durationInDecimal * 100))/100;
                }
                break;
        }

        if (0d == durationInDecimal ) {
            durationInDecimal = Double.valueOf(duration);
        }
        switch (calcMethod){
            case Compound_Interest:
                finalAmount = amount * (Math.pow((1d+roi)/100, durationInDecimal));
                break;
            case Simple_Interest:
                finalAmount = (amount * durationInDecimal * roi) / 100 + amount;
                break;
            default:
        }
        return new BigDecimal(finalAmount);
    }
}
