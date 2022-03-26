package com.distarise.distabank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "FIXEDDEPOSIT")
@IdClass(FixedDepositId.class)
public class FixedDeposit {
    @Id
    @Column(name = "CLIENTID")
    private String clientId;

    @Id
    @Column(name = "ACCOUNTNO")
    private String accountNo;

    @Column(name = "CUSTOMERID")
    private Long customerId;

    @Column(name = "CUSTOMERNAME")
    private String customerName;

    @Column(name = "STARTDATE")
    private Date effectiveDate;

    @Column(name = "MATURITYDATE")
    private Date maturityDate;

    @Column(name = "MATURITYVALUE")
    private Date maturityValue;

    @Column(name = "ROI")
    private BigDecimal roi;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "AMOUNTTEXT")
    private String amountText;

    @Column(name = "WITHDRAWALDATE")
    private Date withdrawalDate;

    @Column(name = "REFERENCECODE")
    private String referenceCode;

    @Column(name = "CALCMETHOD")
    private String calcMethod;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getMaturityValue() {
        return maturityValue;
    }

    public void setMaturityValue(Date maturityValue) {
        this.maturityValue = maturityValue;
    }

    public BigDecimal getRoi() {
        return roi;
    }

    public void setRoi(BigDecimal roi) {
        this.roi = roi;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAmountText() {
        return amountText;
    }

    public void setAmountText(String amountText) {
        this.amountText = amountText;
    }

    public Date getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(Date withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getCalcMethod() {
        return calcMethod;
    }

    public void setCalcMethod(String calcMethod) {
        this.calcMethod = calcMethod;
    }

    public FixedDeposit() {
    }
}
