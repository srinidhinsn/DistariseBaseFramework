package com.distarise.base.model;

import java.io.Serializable;

public class PageDetailsDto implements Serializable {
    private ClientDto clientDto;
    private NavigationDto navigationDto;
    private String url;

    public ClientDto getClientDto() {
        return clientDto;
    }

    public void setClientDto(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public NavigationDto getNavigationDto() {
        return navigationDto;
    }

    public void setNavigationDto(NavigationDto navigationDto) {
        this.navigationDto = navigationDto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PageDetailsDto(ClientDto clientDto, NavigationDto navigationDto, String url) {
        this.clientDto = clientDto;
        this.navigationDto = navigationDto;
        this.url = url;
    }

    public PageDetailsDto() {
    }
}
