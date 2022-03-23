package com.distarise.base.model;

import java.io.Serializable;
import java.util.Objects;

public class RoleWidgetActionDto implements Comparable, Serializable {
    private String clientId;
    private String roleName;
    private String widgetId;
    private String action;
    private Boolean enabled;
    private Boolean visible;

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
        if (null == action){
            this.action = "";
        } else {
            this.action = action;
        }
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public RoleWidgetActionDto(String clientId, String roleName, String widgetId,
                               String action, Boolean enabled, Boolean visible) {
        this.clientId = clientId;
        this.roleName = roleName;
        this.widgetId = widgetId;
        if (null == action){
            this.action = "";
        } else {
            this.action = action;
        }
        this.enabled = enabled;
        this.visible = visible;
    }

    public RoleWidgetActionDto(String clientId, String roleName, String widgetId,
                               String action, Boolean enabled) {
        this.clientId = clientId;
        this.roleName = roleName;
        this.widgetId = widgetId;
        if (null == action){
            this.action = "";
        } else {
            this.action = action;
        }
        this.enabled = enabled;
    }

    public RoleWidgetActionDto() {
    }

    @Override
    public boolean equals(Object obj) {
        Boolean isEqual = false;
        if (obj instanceof RoleWidgetActionDto){
            RoleWidgetActionDto roleWidgetActionDto = (RoleWidgetActionDto) obj;
            if (roleWidgetActionDto.getClientId().equals(this.clientId) &&
                    roleWidgetActionDto.getWidgetId().equals(this.widgetId) &&
                    roleWidgetActionDto.getRoleName().equals(this.roleName) &&
                    roleWidgetActionDto.getAction().equals(this.action)){
                isEqual = true;
            }

        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, roleName, action, widgetId);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof RoleWidgetActionDto){
            RoleWidgetActionDto roleWidgetActionDto = (RoleWidgetActionDto) o;
            if (roleWidgetActionDto.getWidgetId().compareTo(this.widgetId) == 0){
                return 0;
            } else if (roleWidgetActionDto.getWidgetId().compareTo(this.widgetId) > 0){
                return -1;
            } else if (roleWidgetActionDto.getWidgetId().compareTo(this.widgetId) < 0){
                return 1;
            }
        }
        return 0;
    }
}
