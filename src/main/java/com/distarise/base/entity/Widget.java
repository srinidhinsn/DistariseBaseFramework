package com.distarise.base.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "WIDGET")
@IdClass(WidgetId.class)
public class Widget implements Serializable {
    @Id
    @Column(name = "ID")
    private String id;

    @Id
    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "NAVITEMID")
    private String navigationItemId;

    @Column(name = "CSSCLASS")
    private String cssClass;

    @Column(name = "WIDGETTITLE")
    private String widgetTitle;

    @Column(name = "LAYOUTID")
    private String layoutId;

    @Column(name = "SORTORDER")
    private Integer sortOrder;

    @Column(name = "WIDGETID")
    private String widgetId;

    @Column(name = "REDIRECTURL")
    private String redirectUrl;

    @Column(name = "COLSPAN", columnDefinition = "integer default 1")
    private Integer colspan;

    @Column(name = "ROWSPAN", columnDefinition = "integer default 1")
    private Integer rowspan;

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

    public String getNavigationItemId() {
        return navigationItemId;
    }

    public void setNavigationItemId(String navigationItemId) {
        this.navigationItemId = navigationItemId;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getWidgetTitle() {
        return widgetTitle;
    }

    public void setWidgetTitle(String widgetTitle) {
        this.widgetTitle = widgetTitle;
    }

    public String getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(String layoutId) {
        this.layoutId = layoutId;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(String widgetId) {
        this.widgetId = widgetId;
    }

    public Integer getColspan() {
        return colspan;
    }

    public void setColspan(Integer colspan) {
        this.colspan = colspan;
    }

    public Integer getRowspan() {
        return rowspan;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public void setRowspan(Integer rowspan) {
        this.rowspan = rowspan;
    }
    public Widget(String id, String clientId, String navigationItemId, String cssClass,
                  String widgetTitle, String layoutId, Integer sortOrder, String widgetId,
                  Integer rowspan, Integer colspan) {
        this.id = id;
        this.clientId = clientId;
        this.navigationItemId = navigationItemId;
        this.cssClass = cssClass;
        this.widgetTitle = widgetTitle;
        this.layoutId = layoutId;
        this.sortOrder = sortOrder;
        this.widgetId = widgetId;
        this.rowspan = rowspan;
        this.colspan = colspan;
    }

    public Widget() {
    }
}
