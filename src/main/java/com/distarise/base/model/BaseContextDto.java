package com.distarise.base.model;

public class BaseContextDto {
    private String clientId;
    private String module;
    private String pageName;
    private UserRoleDto userRoleDto;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public UserRoleDto getUserRoleDto() {
        return userRoleDto;
    }

    public void setUserRoleDto(UserRoleDto userRoleDto) {
        this.userRoleDto = userRoleDto;
    }

    public BaseContextDto(String clientId, String module, String pageName, UserRoleDto userRoleDto) {
        this.clientId = clientId;
        this.module = module;
        this.pageName = pageName;
        this.userRoleDto = userRoleDto;
    }

    public BaseContextDto() {
    }
}
