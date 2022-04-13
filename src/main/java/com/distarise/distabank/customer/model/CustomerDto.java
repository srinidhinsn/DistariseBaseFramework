package com.distarise.distabank.customer.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CustomerDto implements Serializable {
    public static final String DATE_YYYY_MM_DD = "yyyy-MM-dd";

    private String clientId;
    private Long id;
    private String firstname;
    private String lastname;
    private Date dob;
    private String gender;
    private String addressline1;
    private String addressline2;
    private String city;
    private String state;
    private String country;
    private Boolean active;
    private String pincode;
    private String phone;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public CustomerDto(String clientId, Long id, String firstname, String lastname, String gender,
                       String addressline1, String addressline2, String city,
                       String state, String country, Boolean active, String pincode, String phone,
                       Date dob) {
        this.clientId = clientId;
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.active = active;
        this.pincode = pincode;
        this.phone = phone;
        this.dob = dob;
    }

    public CustomerDto() {
        this.id = 0L;
        this.firstname = "";
        this.lastname = "";
    }

    @Override
    public boolean equals(Object obj) {
        Boolean isEqual = false;
        if (obj instanceof CustomerDto){
            CustomerDto c = (CustomerDto) obj;
            if (c.getId() == this.id){
                return true;
            }
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
