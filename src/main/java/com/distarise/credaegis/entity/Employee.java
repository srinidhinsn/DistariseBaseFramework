package com.distarise.credaegis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable  {
    @Id
    @GeneratedValue(generator="s_employee_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="s_employee_id",sequenceName="S_EMPLOYEE_ID", initialValue = 1000, allocationSize=1)
    @Column(name = "EID")
    private Long eid;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "DOB")
    private Date dob;

    @Column(name = "GENDER")
    private char gender;

    @Column(name = "EMAIL1")
    private String email1;

    @Column(name = "DESIGNATION")
    private String designation;

    @Column(name = "CONTACT")
    private String contact;

    @Column(name = "ADDRESSLINE1")
    private String addressline1;

    @Column(name = "ADDRESSLINE2")
    private String addressline2;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "PINCODE")
    private String pincode;


    public Employee() {
    }

    public Employee(Long eid, String firstName, String lastName, Date dob, char gender, String email1, String designation, String contact, String addressline1, String addressline2, String city, String state, String country, String pincode) {
        this.eid = eid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.email1 = email1;
        this.designation = designation;
        this.contact = contact;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
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

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
