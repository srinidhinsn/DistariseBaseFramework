package com.distarise.base.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "NAVITEM")
@IdClass(NavigationItemId.class)
public class NavigationItem implements Serializable {
    @Id
    @Column(name = "ID")
    private String id;

    @Id
    @Column(name = "UINAVID")
    private String navigationId;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "URL")
    private String url;

    @Column(name = "SORTORDER")
    private Integer sortOrder;

    @Column(name = "LAYOUTID")
    private String layoutId;

    @Column(name = "NAVITEMID")
    private String navigationItemId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNavigationId() {
        return navigationId;
    }

    public void setNavigationId(String navigationId) {
        this.navigationId = navigationId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(String layoutId) {
        this.layoutId = layoutId;
    }

    public String getNavigationItemId() {
        return navigationItemId;
    }

    public void setNavigationItemId(String navigationItemId) {
        this.navigationItemId = navigationItemId;
    }

    public NavigationItem(String id, String navigationId, String label, String url,
                          Integer sortOrder, String layoutId, String navigationItemId) {
        this.id = id;
        this.navigationId = navigationId;
        this.label = label;
        this.url = url;
        this.sortOrder = sortOrder;
        this.layoutId = layoutId;
        this.navigationItemId = navigationItemId;
    }

    public NavigationItem() {
    }
}
