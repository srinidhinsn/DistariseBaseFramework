package com.distarise.base.model;

import java.util.List;

public class PageDetailsDto {
    private ClientDto clientDto;
    private NavigationDto navigationDto;

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

    public PageDetailsDto(ClientDto clientDto, NavigationDto navigationDto) {
        this.clientDto = clientDto;
        this.navigationDto = navigationDto;
    }

    public PageDetailsDto() {
    }
}
