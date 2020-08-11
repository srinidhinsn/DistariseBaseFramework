package com.distarise.base.model;

public class UserDetailsDto {
    private String clientId;
    private String userId;
    private String password;
    private String title;
    private String firstname;
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

    public UserDetailsDto(String clientId, String userId, String password, String title, String firstname, String lastname) {
        this.clientId = clientId;
        this.userId = userId;
        this.password = password;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserDetailsDto() {
    }
}
