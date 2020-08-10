package com.distarise.base.entity;

import javax.persistence.*;
import java.io.Serializable;

public class UserRoleId implements Serializable {

    @Column(name = "ROLENAME")
    private String roleName;

    @Column(name = "CLIENTID")
    private String clientId;

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

    public UserRoleId(String roleName, String clientId) {
        this.roleName = roleName;
        this.clientId = clientId;
    }

    public UserRoleId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoleId that = (UserRoleId) o;

        if (!roleName.equals(that.roleName)) return false;
        return clientId.equals(that.clientId);
    }

    @Override
    public int hashCode() {
        int result = roleName.hashCode();
        result = 31 * result + clientId.hashCode();
        return result;
    }
}