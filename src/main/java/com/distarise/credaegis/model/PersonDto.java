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
    private String password;
    private Date occupationDate;
    private List<EmailDto> emailList;
    private List<ContactDto> contactList;
    private List<AddressDto> addressList;
    private List<IdentityDto> identityList;
    private List<CaseDto> caseDtoList;

    public PersonDto() {
    }

    public PersonDto(Long pid, String firstName, String lastName, Date dob, char gender, String occupation, String email, String contact, String reportType, String path, String fileName, String referral, String password, Date occupationDate, List emailList, List contactList, List addressList, List identityList, List caseDtoList) {
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
        this.password = password;
        this.occupationDate = occupationDate;
        this.emailList = emailList;
        this.contactList = contactList;
        this.addressList = addressList;
        this.identityList = identityList;
        this.caseDtoList = caseDtoList;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getOccupationDate() {
        return occupationDate;
    }

    public void setOccupationDate(Date occupationDate) {
        this.occupationDate = occupationDate;
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

    public List getTaskList() {
        return caseDtoList;
    }

    public void setTaskList(List caseDtoList) {
        this.caseDtoList = caseDtoList;
    }
}
