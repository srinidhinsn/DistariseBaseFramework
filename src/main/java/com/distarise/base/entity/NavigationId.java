package com.distarise.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

public class NavigationId implements Serializable {

    @Column(name = "ID")
    private String id;

    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "ROLENAME")
    private String roleName;

    @Column(name = "MODULE")
    private String module;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public NavigationId(String id, String clientId, String roleName, String module) {
        this.id = id;
        this.clientId = clientId;
        this.roleName = roleName;
        this.module = module;
    }

    public NavigationId() {
    }
}
