package com.distarise.base.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "WIDGET")
@IdClass(WidgetId.class)
public class Widget implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Id
    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "NAVITEMID")
    private Long navigationItemId;

    @Column(name = "CSSCLASS")
    private String cssClass;

    @Column(name = "WIDGETTITLE")
    private String widgetTitle;

    @Column(name = "LAYOUTID")
    private Long layoutId;

    @Column(name = "SORTORDER")
    private Integer sortOrder;

    @Column(name = "WIDGETID")
    private Long widgetId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Long getNavigationItemId() {
        return navigationItemId;
    }

    public void setNavigationItemId(Long navigationItemId) {
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

    public Long getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(Long layoutId) {
        this.layoutId = layoutId;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Long getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(Long widgetId) {
        this.widgetId = widgetId;
    }

    public Widget(Long id, String clientId, Long navigationItemId, String cssClass,
                  String widgetTitle, Long layoutId, Integer sortOrder, Long widgetId) {
        this.id = id;
        this.clientId = clientId;
        this.navigationItemId = navigationItemId;
        this.cssClass = cssClass;
        this.widgetTitle = widgetTitle;
        this.layoutId = layoutId;
        this.sortOrder = sortOrder;
        this.widgetId = widgetId;
    }

    public Widget() {
    }
}
