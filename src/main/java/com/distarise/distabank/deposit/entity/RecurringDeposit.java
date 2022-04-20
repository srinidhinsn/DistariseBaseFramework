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
@Table(name = "RECURRINGDEPOSIT")
public class RecurringDeposit {
    @Id
    @GeneratedValue(generator="s_fddeposit_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="s_fddeposit_id",sequenceName="S_FDDEPOSIT_ID", initialValue = 1000, allocationSize=1)
    private Long id;

    @Column(name = "CLIENTID")
    private String clientId;

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
    private BigDecimal maturityValue;

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

    @Column(name = "CALCFREQUENCY")
    private String calcFrequency;

    @Column(name = "STATUS", columnDefinition = "varchar(20) default 'Pending'")
    private String status;

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

    public BigDecimal getMaturityValue() {
        return maturityValue;
    }

    public void setMaturityValue(BigDecimal maturityValue) {
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

    public String getCalcFrequency() {
        return calcFrequency;
    }

    public void setCalcFrequency(String calcFrequency) {
        this.calcFrequency = calcFrequency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RecurringDeposit() {
    }
}
