package com.distarise.credaegis.model;


public class LeadDto {
    private Long lid;
    private String accountNo;
    private String title;
    private String accountType;
    private String ownership;
    private String status;
    private String problemStatement;

    private String accountName;

    private String latestPaymentDone;
    private String creditStatus;
    private Long amountOverdue;
    private Long sanctionedAmount;
    private Long currentBalance;
    private Long highCredit;
    private Long pid;

    public LeadDto() {
    }

    public LeadDto(Long lid, String accountNo, String title, String accountType, String ownership, String status, String problemStatement, String latestPaymentDone, String accountName, Long pid) {
        this.lid = lid;
        this.accountNo = accountNo;
        this.title = title;
        this.accountType = accountType;
        this.ownership = ownership;
        this.status = status;
        this.problemStatement = problemStatement;
        this.latestPaymentDone = latestPaymentDone;
        this.accountName = accountName;
        this.pid = pid;
    }

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getLatestPaymentDone() {
        return latestPaymentDone;
    }

    public void setLatestPaymentDone(String latestPaymentDone) {
        this.latestPaymentDone = latestPaymentDone;
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus;
    }

    public Long getAmountOverdue() {
        return amountOverdue;
    }

    public void setAmountOverdue(Long amountOverdue) {
        this.amountOverdue = amountOverdue;
    }

    public Long getSanctionedAmount() {
        return sanctionedAmount;
    }

    public void setSanctionedAmount(Long sanctionedAmount) {
        this.sanctionedAmount = sanctionedAmount;
    }

    public Long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Long currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Long getHighCredit() {
        return highCredit;
    }

    public void setHighCredit(Long highCredit) {
        this.highCredit = highCredit;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
