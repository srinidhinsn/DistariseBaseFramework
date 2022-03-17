package com.distarise.base.model;

public class ConfigPageDetailsDto {
    private String clientId;
    private String uiNavId;
    private String navItemId;
    private String WidgetId;
    private String componentId;
    private String roleName;
    private String action;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUiNavId() {
        return uiNavId;
    }

    public void setUiNavId(String uiNavId) {
        this.uiNavId = uiNavId;
    }

    public String getNavItemId() {
        return navItemId;
    }

    public void setNavItemId(String navItemId) {
        this.navItemId = navItemId;
    }

    public String getWidgetId() {
        return WidgetId;
    }

    public void setWidgetId(String widgetId) {
        WidgetId = widgetId;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ConfigPageDetailsDto(String clientId, String uiNavId, String navItemId, String widgetId, String componentId) {
        this.clientId = clientId;
        this.uiNavId = uiNavId;
        this.navItemId = navItemId;
        this.WidgetId = widgetId;
        this.componentId = componentId;
    }

    public ConfigPageDetailsDto(String clientId, String uiNavId, String navItemId, String widgetId, String componentId,
                                String roleName, String action) {
        this.clientId = clientId;
        this.uiNavId = uiNavId;
        this.navItemId = navItemId;
        this.WidgetId = widgetId;
        this.componentId = componentId;
        this.roleName = roleName;
        this.action = action;
    }

    public ConfigPageDetailsDto() {
        this.clientId = "";
        this.uiNavId = "";
        this.navItemId = "";
        this.WidgetId = "";
        this.componentId = "";
        this.roleName = "";
    }
}
