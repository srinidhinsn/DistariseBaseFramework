package com.distarise.distabank.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class FixedDepositConfigId implements Serializable {
    @Column(name = "CLIENTID")
    private String clientId;

    @Id
    @Column(name = "EFFECTIVEDATE")
    private Date effectiveDate;

    @Id
    @Column(name = "ENDDATE")
    private Date endDate;

    public FixedDepositConfigId(String clientId, Date effectiveDate, Date endDate) {
        this.clientId = clientId;
        this.effectiveDate = effectiveDate;
        this.endDate = endDate;
    }

    public FixedDepositConfigId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixedDepositConfigId that = (FixedDepositConfigId) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(effectiveDate, that.effectiveDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, effectiveDate, endDate);
    }
}
