package com.distarise.credaegis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CASE")
public class Case implements Serializable {

    @Id
    @GeneratedValue(generator="s_case_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="s_case_id",sequenceName="S_CASE_ID", initialValue = 1000, allocationSize=1)
    @Column(name = "CID")
    private Long cid;

    @ManyToOne
    @JoinColumn(name = "PID", insertable = false, updatable = false)
    Person person;

    @Column(name = "PID")
    private Long pid;

    @Column(name = "ACCOUNTNO")
    private String accountNo;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "ACCOUNTTYPE")
    private String accountType;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PROBLEMSTATEMENT")
    private String problemStatement;

    @Column(name = "OWNERSHIP")
    private String ownership;

    @Column(name = "ACCOUNTNAME")
    private String accountName;

    @Column(name = "LATESTPAYMENTDONE")
    private String latestPaymentDone;

    @Column(name = "CREDITSTATUS")
    private String creditStatus;

    @Column(name = "AMOUNTOVERDUE")
    private Long amountOverdue;

    @Column(name = "SANCTIONEDAMOUNT")
    private Long sanctionedAmount;

    @Column(name = "CURRENTBALANCE")
    private Long currentBalance;


    @Column(name = "HIGHCREDIT")
    private Long highCredit;

    public Case() {
    }

    public Case(Long cid, Person person, Long pid, String accountNo, String title, String accountType, String status, String problemStatement, String latestPaymentDone, String ownership, String accountName) {
        this.cid = cid;
        this.person = person;
        this.pid = pid;
        this.accountNo = accountNo;
        this.title = title;
        this.accountType = accountType;
        this.status = status;
        this.problemStatement = problemStatement;
        this.latestPaymentDone = latestPaymentDone;
        this.ownership = ownership;
        this.accountName = accountName;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
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
}
