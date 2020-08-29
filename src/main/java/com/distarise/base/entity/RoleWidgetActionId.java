package com.distarise.base.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class RoleWidgetActionId implements Serializable {

    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "ROLENAME")
    private String roleName;

    @Column(name = "ACTION")
    private String action;

    @Column(name = "WIDGETID")
    private String widgetId;

    public RoleWidgetActionId(String clientId, String roleName, String widgetId, String action) {
        this.clientId = clientId;
        this.roleName = roleName;
        this.widgetId = widgetId;
        this.action = action;
    }

    public RoleWidgetActionId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleWidgetActionId that = (RoleWidgetActionId) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(action, that.action) &&
                Objects.equals(widgetId, that.widgetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, roleName, action, widgetId);
    }
}
