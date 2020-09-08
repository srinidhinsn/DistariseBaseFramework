package com.distarise.base.model;

import java.io.Serializable;
import java.util.List;

public class WidgetDto implements Serializable {
    private String id;
    private String clientId;
    private String navigationItemId;
    private String cssClass;
    private String widgetTitle;
    private String layoutId;
    private Integer sortOrder;
    private String widgetId;
    private Integer colspan;
    private Integer rowspan;
    private LayoutDto layoutDto;
    private List<ComponentDto> componentDtos;

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

    public List<ComponentDto> getComponentDtos() {
        return componentDtos;
    }

    public void setComponentDtos(List<ComponentDto> componentDtos) {
        this.componentDtos = componentDtos;
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

    public void setRowspan(Integer rowspan) {
        this.rowspan = rowspan;
    }

    public LayoutDto getLayoutDto() {
        return layoutDto;
    }

    public void setLayoutDto(LayoutDto layoutDto) {
        this.layoutDto = layoutDto;
    }

    public WidgetDto(String id, String clientId, String navigationItemId, String cssClass,
                     String widgetTitle, String layoutId, Integer sortOrder, String widgetId,
                     Integer rowspan, Integer colspan, LayoutDto layoutDto, List<ComponentDto> componentDtos) {
        this.id = id;
        this.clientId = clientId;
        this.navigationItemId = navigationItemId;
        this.cssClass = cssClass;
        this.widgetTitle = widgetTitle;
        this.layoutId = layoutId;
        this.sortOrder = sortOrder;
        this.widgetId = widgetId;
        this.componentDtos = componentDtos;
        this.rowspan = rowspan;
        this.colspan = colspan;
        this.layoutDto = layoutDto;
    }

    public WidgetDto() {
    }
}
