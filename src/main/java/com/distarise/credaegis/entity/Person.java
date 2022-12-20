package com.distarise.credaegis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {
    @Id
    @GeneratedValue(generator="s_person_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="s_person_id",sequenceName="S_PERSON_ID", initialValue = 1000, allocationSize=1)
    @Column(name = "PID")
    private Long pid;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "DOB")
    private Date dob;

    @Column(name = "GENDER")
    private char gender;

    @Column(name = "OCCUPATION")
    private String occupation;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CONTACT")
    private String contact;

    @Column(name = "REPORTTYPE")
    private String reportType;

    @Column(name = "PATH")
    private String path;

    @Column(name = "FILENAME")
    private String fileName;

    @Column(name = "REFERRAL")
    private String referral;

    @Column(name = "CREDITSCORE")
    private Integer creditScore;

    @Column(name = "OCCUPATIONDATE")
    private Date occupationDate;


    @Column(name = "COREFACTORID")
    private String corefactorId;
    @OneToMany(mappedBy = "pid", targetEntity = Email.class)
    private List emailList;

    @OneToMany(mappedBy = "pid", targetEntity = Contact.class)
    private List contactList;

    @OneToMany(mappedBy = "pid", targetEntity = Address.class)
    private List addressList;

    @OneToMany(mappedBy = "pid", targetEntity = Identity.class)
    private List identityList;

    @OneToMany(mappedBy = "pid", targetEntity = Lead.class)
    private List leadList;

    public Person() {
    }

    public Person(Long pid, String firstName, String lastName, Date dob, char gender, String occupation, String email, String contact, String reportType, String path, String fileName, String referral, Date occupationDate, List emailList, List contactList, List addressList, List identityList, List leadList) {
        this.pid = pid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.occupation = occupation;
        this.email = email;
        this.contact = contact;
        this.reportType = reportType;
        this.path = path;
        this.fileName = fileName;
        this.referral = referral;
        this.occupationDate = occupationDate;
        this.emailList = emailList;
        this.contactList = contactList;
        this.addressList = addressList;
        this.identityList = identityList;
        this.leadList = leadList;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }

    public Date getOccupationDate() {
        return occupationDate;
    }

    public void setOccupationDate(Date occupationDate) {
        this.occupationDate = occupationDate;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public String getCorefactorId() {
        return corefactorId;
    }

    public void setCorefactorId(String corefactorId) {
        this.corefactorId = corefactorId;
    }

    public List getEmailList() {
        return emailList;
    }

    public void setEmailList(List emailList) {
        this.emailList = emailList;
    }

    public List getContactList() {
        return contactList;
    }

    public void setContactList(List contactList) {
        this.contactList = contactList;
    }

    public List getAddressList() {
        return addressList;
    }

    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }

    public List getIdentityList() {
        return identityList;
    }

    public void setIdentityList(List identityList) {
        this.identityList = identityList;
    }

    public List getLeadList() {
        return leadList;
    }

    public void setLeadList(List leadList) {
        this.leadList = leadList;
    }
}
