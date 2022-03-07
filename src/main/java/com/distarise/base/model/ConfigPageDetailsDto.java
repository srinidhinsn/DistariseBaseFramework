package com.distarise.base.model;

import java.io.Serializable;
import java.util.List;

public class ConfigPageDetailsDto extends PageDetailsDto {
    private List<NavigationDto> navigationDtoList;

    public List<NavigationDto> getNavigationDtoList() {
        return navigationDtoList;
    }

    public void setNavigationDtoList(List<NavigationDto> navigationDtoList) {
        this.navigationDtoList = navigationDtoList;
    }

    public ConfigPageDetailsDto() {
    }
}
