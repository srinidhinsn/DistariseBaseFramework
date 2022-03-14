package com.distarise.base.model;

public class RoleDto {
    private String roleName;
    private String description;
    private String clientId;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public RoleDto(String roleName, String description, String clientId) {
        this.roleName = roleName;
        this.description = description;
        this.clientId = clientId;
    }

    public RoleDto() {
    }
}
