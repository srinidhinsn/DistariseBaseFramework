package com.distarise.base.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "USERDETAILS")
@IdClass(UserId.class)
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CLIENTID")
    private String clientId;

    @Id
    @Column(name = "USERID")
    private String userId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDetails(String clientId, String userId, String password, String title, String firstname, String lastname) {
        this.clientId = clientId;
        this.userId = userId;
        this.password = password;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserDetails() {
    }
}
