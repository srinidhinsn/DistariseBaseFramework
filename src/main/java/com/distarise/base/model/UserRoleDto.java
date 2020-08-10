package com.distarise.base.model;

import java.util.List;

public class UserRoleDto {
    private String clientId;
    private String userId;
    private List<String> rolesList;

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

    public List<String> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<String> rolesList) {
        this.rolesList = rolesList;
    }

    public UserRoleDto(String clientId, String userId, List<String> rolesList) {
        this.clientId = clientId;
        this.userId = userId;
        this.rolesList = rolesList;
    }

    public UserRoleDto() {
    }
}
