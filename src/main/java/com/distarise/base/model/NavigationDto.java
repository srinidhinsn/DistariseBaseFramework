package com.distarise.base.model;

import com.distarise.base.entity.NavigationItem;

import java.io.Serializable;
import java.util.List;

public class NavigationDto implements Serializable {
    private String id;
    private String clientId;
    private String roleName;
    private String pageTitle;
    private String pageDescription;
    private String module;
    private String pageName;
    private String redirectPageName;
    private String cssClass;
    private List<NavigationItemDto> navigationItems;


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

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
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

    public String getRedirectPageName() {
        return redirectPageName;
    }

    public void setRedirectPageName(String redirectPageName) {
        this.redirectPageName = redirectPageName;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public List<NavigationItemDto> getNavigationItems() {
        return navigationItems;
    }

    public void setNavigationItems(List<NavigationItemDto> navigationItems) {
        this.navigationItems = navigationItems;
    }

    public NavigationDto(String id, String clientId, String roleName, String pageTitle,
                         String pageDescription, String module, String pageName,
                         String redirectPageName, String cssClass, List<NavigationItemDto> navigationItems) {
        this.id = id;
        this.clientId = clientId;
        this.roleName = roleName;
        this.pageTitle = pageTitle;
        this.pageDescription = pageDescription;
        this.module = module;
        this.pageName = pageName;
        this.redirectPageName = redirectPageName;
        this.cssClass = cssClass;
        this.navigationItems = navigationItems;
    }

    public NavigationDto() {
    }
}
