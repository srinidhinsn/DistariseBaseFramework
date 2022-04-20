package com.distarise.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageDetailsDto implements Serializable {
    private ClientDto clientDto;
    private NavigationDto navigationDto;
    private String url;
    private List<String> successMessages;
    private List<String> warningMessages;
    private List<String> errorMessages;

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

    public List<String> getSuccessMessages() {
        return successMessages;
    }

    public void setSuccessMessages(List<String> successMessages) {
        this.successMessages = successMessages;
    }

    public List<String> getWarningMessages() {
        return warningMessages;
    }

    public void setWarningMessages(List<String> warningMessages) {
        this.warningMessages = warningMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public PageDetailsDto(ClientDto clientDto, NavigationDto navigationDto, String url) {
        this.clientDto = clientDto;
        this.navigationDto = navigationDto;
        this.url = url;
    }

    public PageDetailsDto() {
        this.successMessages = new ArrayList<>();
        this.warningMessages = new ArrayList<>();
        this.errorMessages = new ArrayList<>();
    }
}
