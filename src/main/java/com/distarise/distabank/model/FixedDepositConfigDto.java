package com.distarise.distabank.model;

import java.math.BigDecimal;
import java.sql.Date;

public class FixedDepositConfigDto {
    private Date effectiveDate;
    private Date endDate;
    private BigDecimal roi;
    private String calcMethod;
    private Integer minDuration;
    private String accountNoSeq;

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getRoi() {
        return roi;
    }

    public void setRoi(BigDecimal roi) {
        this.roi = roi;
    }

    public String getCalcMethod() {
        return calcMethod;
    }

    public void setCalcMethod(String calcMethod) {
        this.calcMethod = calcMethod;
    }

    public Integer getMinDuration() {
        return minDuration;
    }

    public String getAccountNoSeq() {
        return accountNoSeq;
    }

    public void setAccountNoSeq(String accountNoSeq) {
        this.accountNoSeq = accountNoSeq;
    }

    public void setMinDuration(Integer minDuration) {
        this.minDuration = minDuration;
    }

    public FixedDepositConfigDto(Date effectiveDate, Date endDate, BigDecimal roi, String calcMethod,
                                 Integer minDuration, String accountNoSeq) {
        this.effectiveDate = effectiveDate;
        this.endDate = endDate;
        this.roi = roi;
        this.calcMethod = calcMethod;
        this.minDuration = minDuration;
        this.accountNoSeq = accountNoSeq;
    }

    public FixedDepositConfigDto() {
    }
}
