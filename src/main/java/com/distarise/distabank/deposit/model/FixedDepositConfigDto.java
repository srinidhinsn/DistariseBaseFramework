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
    private String calcFrequency;
    private Integer minDuration;
    private BigDecimal maturityValueDeviation;

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

    public String getCalcFrequency() {
        return calcFrequency;
    }

    public void setCalcFrequency(String calcFrequency) {
        this.calcFrequency = calcFrequency;
    }

    public Integer getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(Integer minDuration) {
        this.minDuration = minDuration;
    }

    public BigDecimal getMaturityValueDeviation() {
        return maturityValueDeviation;
    }

    public void setMaturityValueDeviation(BigDecimal maturityValueDeviation) {
        this.maturityValueDeviation = maturityValueDeviation;
    }

    public FixedDepositConfigDto(String clientId, Date effectiveDate, Date endDate, BigDecimal roi, String calcMethod,
                                 Integer minDuration, BigDecimal deviation, String calcFrequency) {
        this.clientId = clientId;
        this.effectiveDate = effectiveDate;
        this.endDate = endDate;
        this.roi = roi;
        this.calcMethod = calcMethod;
        this.minDuration = minDuration;
        this.maturityValueDeviation = deviation;
        this.calcFrequency = calcFrequency;
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
