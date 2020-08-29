package com.distarise.base.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class RoleWidgetId implements Serializable {

    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "ROLENAME")
    private String roleName;


    @Column(name = "WIDGETID")
    private String widgetId;

    public RoleWidgetId(String clientId, String roleName, String widgetId) {
        this.clientId = clientId;
        this.roleName = roleName;
        this.widgetId = widgetId;
    }

    public RoleWidgetId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleWidgetId that = (RoleWidgetId) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(widgetId, that.widgetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, roleName, widgetId);
    }
}
