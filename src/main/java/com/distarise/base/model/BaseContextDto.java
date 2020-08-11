package com.distarise.base.model;

import java.util.Optional;

public class BaseContextDto {
    private String clientId;
    private String module;
    private String pageName;
    private Optional<UserRoleDto> userRoleDto;

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

    public Optional<UserRoleDto> getUserRoleDto() {
        return userRoleDto;
    }

    public void setUserRoleDto(Optional<UserRoleDto> userRoleDto) {
        this.userRoleDto = userRoleDto;
    }

    public BaseContextDto(String clientId, String module, String pageName, Optional<UserRoleDto> userRoleDto) {
        this.clientId = clientId;
        this.module = module;
        this.pageName = pageName;
        this.userRoleDto = userRoleDto;
    }

    public BaseContextDto() {
    }
}
