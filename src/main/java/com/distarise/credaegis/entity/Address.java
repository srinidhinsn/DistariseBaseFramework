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
@Table(name = "ADDRESS")
public class Address implements Serializable {

    @Id
    @GeneratedValue(generator="s_address_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="s_address_id",sequenceName="S_ADDRESS_ID", initialValue = 1000, allocationSize=1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PID")
    private Long pid;

    @ManyToOne
    @JoinColumn(name = "PID", insertable = false, updatable = false)
    Person person;

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

    public Address() {
    }

    public Address(Long id, Long pid, Person person, String addressline1, String addressline2, String city, String state, String country, String pincode) {
        this.id = id;
        this.pid = pid;
        this.person = person;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
