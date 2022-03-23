package com.distarise.base.model;

import java.io.Serializable;

public class UserRoleDto implements Serializable {

    private String roleName;
    private String clientId;
    private String userId;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public UserRoleDto(String roleName, String clientId, String userId) {
        this.roleName = roleName;
        this.clientId = clientId;
        this.userId = userId;
    }

    public UserRoleDto() {
    }
}
