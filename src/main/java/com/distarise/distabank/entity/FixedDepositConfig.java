package com.distarise.distabank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "FIXEDDEPOSITCONFIG")
@IdClass(FixedDepositConfigId.class)
public class FixedDepositConfig {
    @Id
    @Column(name = "CLIENTID")
    private String clientId;

    @Id
    @Column(name = "EFFECTIVEDATE")
    private Date effectiveDate;

    @Id
    @Column(name = "ENDDATE")
    private Date endDate;

    @Column(name = "ROI")
    private BigDecimal roi;

    @Column(name = "CALCMETHOD")
    private String calcMethod;

    @Column(name = "MINDURATION")
    private Integer minDuration;

    @Column(name = "ACCOUNTNOSEQ")
    private String accountNoSeq;

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

    public String getAccountNoSeq() {
        return accountNoSeq;
    }

    public void setAccountNoSeq(String accountNoSeq) {
        this.accountNoSeq = accountNoSeq;
    }

    public FixedDepositConfig() {
    }
}
