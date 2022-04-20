package com.distarise.distabank.deposit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "RECURRINGDEPOSITCONFIG")
public class RecurringDepositConfig {

    @Id
    @GeneratedValue(generator="s_fdconfig_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="s_fdconfig_id",sequenceName="S_FDCONFIG_ID", initialValue = 1000, allocationSize=1)
    private Long id;

    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "EFFECTIVEDATE")
    private Date effectiveDate;

    @Column(name = "ENDDATE")
    private Date endDate;

    @Column(name = "ROI")
    private BigDecimal roi;

    @Column(name = "MATURITYVALUEDEVIATION")
    private BigDecimal maturityValueDeviation;

    @Column(name = "CALCMETHOD")
    private String calcMethod;

    @Column(name = "MINDURATION")
    private Integer minDuration;

    @Column(name = "CALCFREQUENCY")
    private String calcFrequency;

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

    public void setMinDuration(Integer minDuration) {
        this.minDuration = minDuration;
    }

    public BigDecimal getMaturityValueDeviation() {
        return maturityValueDeviation;
    }

    public void setMaturityValueDeviation(BigDecimal maturityValueDeviation) {
        this.maturityValueDeviation = maturityValueDeviation;
    }

    public String getCalcFrequency() {
        return calcFrequency;
    }

    public void setCalcFrequency(String calcFrequency) {
        this.calcFrequency = calcFrequency;
    }

    public RecurringDepositConfig() {
    }
}
