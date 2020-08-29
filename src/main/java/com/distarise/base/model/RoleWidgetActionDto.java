package com.distarise.base.model;

import java.io.Serializable;
import java.util.List;

public class RoleWidgetActionDto implements Serializable {
    private String clientId;
    private String roleName;
    private String widgetId;
    private String action;
    private String enabled;
    private String visible;

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

    public String getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(String widgetId) {
        this.widgetId = widgetId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public RoleWidgetActionDto(String clientId, String roleName, String widgetId,
                               String action, String enabled, String visible) {
        this.clientId = clientId;
        this.roleName = roleName;
        this.widgetId = widgetId;
        this.action = action;
        this.enabled = enabled;
        this.visible = visible;
    }

    public RoleWidgetActionDto() {
    }
}
