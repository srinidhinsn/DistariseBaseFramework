package com.distarise.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ROLEWIDGETACTION")
@IdClass(RoleWidgetActionId.class)
public class RoleWidgetAction implements Serializable {
    @Id
    @Column(name = "ROLENAME")
    private String roleName;

    @Id
    @Column(name = "CLIENTID")
    private String clientId;

    @Id
    @Column(name="WIDGETID")
    private String widgetId;

    @Id
    @Column(name="ACTION")
    private String action;

    @Column(name="VISIBLE")
    private Boolean visible;

    @Column(name="ENABLED", columnDefinition = "boolean default true")
    private Boolean enabled;


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

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public RoleWidgetAction(String roleName, String clientId, String widgetId, Boolean visible,
                            String action, Boolean enabled) {
        this.roleName = roleName;
        this.clientId = clientId;
        this.widgetId = widgetId;
        this.visible = visible;
        this.action = action;
        this.enabled = enabled;
    }

    public RoleWidgetAction() {
    }
}
