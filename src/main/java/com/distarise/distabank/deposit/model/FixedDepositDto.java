package com.distarise.distabank.deposit.model;

import java.math.BigDecimal;
import java.util.Date;

public class FixedDepositDto {
    private Long id;
    private String clientId;
    private String accountNo;
    private Long customerId;
    private String customerName;
    private Date effectiveDate;
    private Date maturityDate;
    private BigDecimal maturityValue;
    private BigDecimal roi;
    private BigDecimal amount;
    private String amountText;
    private Date withdrawalDate;
    private BigDecimal withdrawalAmount;
    private String referenceCode;
    private String calcMethod;

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

    public BigDecimal getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
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

    public FixedDepositDto(String accountNo, Long customerId, String customerName, Date effectiveDate,
                           Date maturityDate, BigDecimal maturityValue, BigDecimal roi, BigDecimal amount,
                           String amountText, Date withdrawalDate, BigDecimal withdrawalAmount,
                           String referenceCode, String calcMethod) {
        this.accountNo = accountNo;
        this.customerId = customerId;
        this.customerName = customerName;
        this.effectiveDate = effectiveDate;
        this.maturityDate = maturityDate;
        this.maturityValue = maturityValue;
        this.roi = roi;
        this.amount = amount;
        this.amountText = amountText;
        this.withdrawalDate = withdrawalDate;
        this.withdrawalAmount = withdrawalAmount;
        this.referenceCode = referenceCode;
        this.calcMethod = calcMethod;
    }

    public FixedDepositDto(String clientId, String accountNo, Long customerId, String customerName, Date effectiveDate,
                           Date maturityDate, BigDecimal maturityValue, BigDecimal roi, BigDecimal amount,
                           String amountText, String referenceCode, String calcMethod) {
        this.clientId = clientId;
        this.accountNo = accountNo;
        this.customerId = customerId;
        this.customerName = customerName;
        this.effectiveDate = effectiveDate;
        this.maturityDate = maturityDate;
        this.maturityValue = maturityValue;
        this.roi = roi;
        this.amount = amount;
        this.amountText = amountText;
        this.referenceCode = referenceCode;
        this.calcMethod = calcMethod;
    }

    public FixedDepositDto() {
    }
}
