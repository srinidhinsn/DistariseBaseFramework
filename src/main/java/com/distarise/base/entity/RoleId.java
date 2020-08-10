package com.distarise.base.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class RoleId implements Serializable {

    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "ROLENAME")
    private String roleName;

    public RoleId(String clientId, String roleName) {
        this.clientId = clientId;
        this.roleName = roleName;
    }

    public RoleId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleId roleId = (RoleId) o;

        if (!clientId.equals(roleId.clientId)) return false;
        return roleName.equals(roleId.roleName);
    }

    @Override
    public int hashCode() {
        int result = clientId.hashCode();
        result = 31 * result + roleName.hashCode();
        return result;
    }
}
