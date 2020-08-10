package com.distarise.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NAVITEM")
public class NavigationItem {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "UINAVID")
    private Long navigationId;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "URL")
    private String url;

    @Column(name = "SORTORDER")
    private Integer sortOrder;

    @Column(name = "LAYOUTID")
    private Long layoutId;

    @Column(name = "NAVITEMID")
    private Long navigationItemId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNavigationId() {
        return navigationId;
    }

    public void setNavigationId(Long navigationId) {
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

    public Long getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(Long layoutId) {
        this.layoutId = layoutId;
    }

    public Long getNavigationItemId() {
        return navigationItemId;
    }

    public void setNavigationItemId(Long navigationItemId) {
        this.navigationItemId = navigationItemId;
    }

    public NavigationItem(Long id, Long navigationId, String label, String url,
                          Integer sortOrder, Long layoutId, Long navigationItemId) {
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
