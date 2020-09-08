package com.distarise.base.model;

import java.io.Serializable;
import java.util.List;

public class NavigationItemDto implements Serializable {
    private String id;
    private String navigationId;
    private String label;
    private String url;
    private Integer sortOrder;
    private String layoutId;
    private String navigationItemId;
    private LayoutDto layoutDto;
    private List<WidgetDto> widgets;


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

    public List<WidgetDto> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<WidgetDto> widgets) {
        this.widgets = widgets;
    }

    public LayoutDto getLayoutDto() {
        return layoutDto;
    }

    public void setLayoutDto(LayoutDto layoutDto) {
        this.layoutDto = layoutDto;
    }

    public NavigationItemDto(String id, String navigationId, String label, String url,
                             Integer sortOrder, String layoutId, String navigationItemId,
                             LayoutDto layoutDto, List<WidgetDto> widgets) {
        this.id = id;
        this.navigationId = navigationId;
        this.label = label;
        this.url = url;
        this.sortOrder = sortOrder;
        this.layoutId = layoutId;
        this.navigationItemId = navigationItemId;
        this.layoutDto = layoutDto;
        this.widgets = widgets;
    }

    public NavigationItemDto() {
    }
}
