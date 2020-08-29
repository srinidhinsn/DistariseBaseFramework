package com.distarise.base.model;

import java.io.Serializable;
import java.util.List;

public class UserRoleDto implements Serializable {
    private String clientId;
    private String userId;
    private List<UserRoleDto> rolesList;

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

    public List<UserRoleDto> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<UserRoleDto> rolesList) {
        this.rolesList = rolesList;
    }

    public UserRoleDto(String clientId, String userId, List<UserRoleDto> rolesList) {
        this.clientId = clientId;
        this.userId = userId;
        this.rolesList = rolesList;
    }

    public UserRoleDto() {
    }
}
