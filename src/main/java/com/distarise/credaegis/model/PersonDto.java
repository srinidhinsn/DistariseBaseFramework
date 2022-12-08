package com.distarise.credaegis.model;

import java.util.Date;
import java.util.List;

public class PersonDto {
    private Long pid;
    private String firstName;
    private String lastName;
    private Date dob;
    private char gender;
    private String occupation;
    private String email;
    private String contact;
    private String reportType;
    private String path;
    private String fileName;
    private String referral;
    private Date occupationDate;
    private Integer creditScore;
    private List<EmailDto> emailList;
    private List<ContactDto> contactList;
    private List<AddressDto> addressList;
    private List<IdentityDto> identityList;
    private List<LeadDto> leadDtoList;

    public PersonDto() {
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

    public List<EmailDto> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<EmailDto> emailList) {
        this.emailList = emailList;
    }

    public List<ContactDto> getContactList() {
        return contactList;
    }

    public void setContactList(List<ContactDto> contactList) {
        this.contactList = contactList;
    }

    public List<AddressDto> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressDto> addressList) {
        this.addressList = addressList;
    }

    public List<IdentityDto> getIdentityList() {
        return identityList;
    }

    public void setIdentityList(List<IdentityDto> identityList) {
        this.identityList = identityList;
    }

    public List<LeadDto> getLeadDtoList() {
        return leadDtoList;
    }

    public void setLeadDtoList(List<LeadDto> leadDtoList) {
        this.leadDtoList = leadDtoList;
    }
}
