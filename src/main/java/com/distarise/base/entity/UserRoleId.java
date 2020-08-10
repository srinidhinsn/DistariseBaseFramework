package com.distarise.base.entity;

import javax.persistence.*;
import java.io.Serializable;

public class UserRoleId implements Serializable {

    @Column(name = "ROLENAME")
    private String roleName;

    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name="USERID")
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

    public UserRoleId() {
    }

    public UserRoleId(String roleName, String clientId, String userId) {
        this.roleName = roleName;
        this.clientId = clientId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoleId that = (UserRoleId) o;

        if (!roleName.equals(that.roleName)) return false;
        if (!clientId.equals(that.clientId)) return false;
        return userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        int result = roleName.hashCode();
        result = 31 * result + clientId.hashCode();
        result = 31 * result + userId.hashCode();
        return result;
    }
}
