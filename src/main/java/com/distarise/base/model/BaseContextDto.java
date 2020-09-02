package com.distarise.base.model;

import java.io.Serializable;
import java.util.Optional;

public class BaseContextDto implements Serializable {
    private String clientId;
    private String module;
    private String pageName;
    private UserDetailsDto userDetailsDto;

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

    public UserDetailsDto getUserDetailsDto() {
        return userDetailsDto;
    }

    public void setUserDetailsDto(UserDetailsDto userDetailsDto) {
        this.userDetailsDto = userDetailsDto;
    }

    public BaseContextDto(String clientId, String module, String pageName, UserDetailsDto userDetailsDto) {
        this.clientId = clientId;
        this.module = module;
        this.pageName = pageName;
        this.userDetailsDto = userDetailsDto;
    }

    public BaseContextDto() {
    }
}
