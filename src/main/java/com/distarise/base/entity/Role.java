package com.distarise.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ROLE")
@IdClass(RoleId.class)
public class Role implements Serializable {
    @Id
    @Column(name = "ROLENAME")
    private String roleName;

    @Id
    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name="ROLEDESCRIPTION")
    private String description;



    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role(String roleName, String clientId, String description) {
        this.roleName = roleName;
        this.clientId = clientId;
        this.description = description;
    }

    public Role() {
    }
}
