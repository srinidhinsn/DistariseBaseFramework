package com.distarise.distabank.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class FixedDepositId implements Serializable {
    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "ACCOUNTNO")
    private String accountNo;

    public FixedDepositId(String clientId, String accountNo) {
        this.clientId = clientId;
        this.accountNo = accountNo;
    }

    public FixedDepositId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixedDepositId that = (FixedDepositId) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(accountNo, that.accountNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, accountNo);
    }
}
