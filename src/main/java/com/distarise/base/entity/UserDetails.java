package com.distarise.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "USERDETAILS")
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USERID")
    private String userId;

    @Column(name = "PASSWORD")
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetails(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public UserDetails() {
    }
}
