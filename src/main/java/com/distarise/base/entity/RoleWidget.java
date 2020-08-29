package com.distarise.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ROLEWIDGET")
@IdClass(RoleWidgetId.class)
public class RoleWidget implements Serializable {
    @Id
    @Column(name = "ROLENAME")
    private String roleName;

    @Id
    @Column(name = "CLIENTID")
    private String clientId;

    @Id
    @Column(name="WIDGETID")
    private String widgetId;

    @Column(name="VISIBLE")
    private String visible;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(String widgetId) {
        this.widgetId = widgetId;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public RoleWidget(String roleName, String clientId, String widgetId, String visible) {
        this.roleName = roleName;
        this.clientId = clientId;
        this.widgetId = widgetId;
        this.visible = visible;
    }

    public RoleWidget() {
    }
}
