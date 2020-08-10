package com.distarise.base.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USERROLE")
@IdClass(RoleId.class)
public class UserRole implements Serializable {
    @Id
    @Column(name = "ROLENAME")
    private String roleName;

    @Id
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

    public UserRole(String roleName, String clientId, String userId) {
        this.roleName = roleName;
        this.clientId = clientId;
        this.userId = userId;
    }

    public UserRole() {
    }
}
