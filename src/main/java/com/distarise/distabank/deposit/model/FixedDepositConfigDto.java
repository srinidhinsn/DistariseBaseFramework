package com.distarise.distabank.deposit.model;

import com.distarise.distabank.util.DistabankUtils;

import java.math.BigDecimal;
import java.util.Date;

public class FixedDepositConfigDto {
    private Long id;
    private String clientId;
    private Date effectiveDate;
    private Date endDate;
    private BigDecimal roi;
    private String calcMethod;
    private Integer minDuration;
    private String accountNoSeq;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

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

    public FixedDepositConfigDto(String clientId, Date effectiveDate, Date endDate, BigDecimal roi, String calcMethod,
                                 Integer minDuration, String accountNoSeq) {
        this.clientId = clientId;
        this.effectiveDate = effectiveDate;
        this.endDate = endDate;
        this.roi = roi;
        this.calcMethod = calcMethod;
        this.minDuration = minDuration;
        this.accountNoSeq = accountNoSeq;
    }

    public FixedDepositConfigDto() {
    }

    public String getEffectiveAndEndDateDropDown(){
        if (null != this.endDate) {
            return this.effectiveDate + DistabankUtils.GENERIC_SEPERATOR + this.endDate;
        } else {
            return this.effectiveDate + DistabankUtils.GENERIC_SEPERATOR;
        }
    }
}
