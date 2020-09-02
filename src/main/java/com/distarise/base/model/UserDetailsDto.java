package com.distarise.base.model;

import java.io.Serializable;
import java.util.List;

public class UserDetailsDto implements Serializable {
    private String clientId;
    private String userId;
    private String password;
    private String title;
    private String firstname;
    private String lastname;
    private String roleName;
    private List<RoleWidgetActionDto> roleAccessList;


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

    public List<RoleWidgetActionDto> getRoleAccessList() {
        return roleAccessList;
    }

    public void setRoleAccessList(List<RoleWidgetActionDto> roleAccessList) {
        this.roleAccessList = roleAccessList;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserDetailsDto(String clientId, String userId, String password, String title, String firstname,
                          String lastname, String roleName, List<RoleWidgetActionDto> roleAccessList) {
        this.clientId = clientId;
        this.userId = userId;
        this.password = password;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.roleName = roleName;
        this.roleAccessList = roleAccessList;
    }

    public UserDetailsDto() {
    }
}
