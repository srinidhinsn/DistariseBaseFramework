package com.distarise.base.model;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ComponentDto implements Serializable {
    private String id;
    private String widgetId;
    private String clientId;
    private Integer sortOrder;
    private String type;
    private String label;
    private Boolean editable;
    private String redirectUrl;
    private String keyOrAction;
    private Boolean visible;
    private String value;
    private Boolean multiLevel;
    private Integer colspan;
    private Integer rowspan;
    private List<ComponentItemDto> componentItemDtos;
    private List<Map<String, String>> gridValues;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(String widgetId) {
        this.widgetId = widgetId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getKeyOrAction() {
        return keyOrAction;
    }

    public void setKeyOrAction(String keyOrAction) {
        this.keyOrAction = keyOrAction;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getMultiLevel() {
        return multiLevel;
    }

    public void setMultiLevel(Boolean multiLevel) {
        this.multiLevel = multiLevel;
    }

    public List<ComponentItemDto> getComponentItemDtos() {
        return componentItemDtos;
    }

    public void setComponentItemDtos(List<ComponentItemDto> componentItemDtos) {
        this.componentItemDtos = componentItemDtos;
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

    public List<Map<String, String>> getGridValues() {
        return gridValues;
    }

    public void setGridValues(List<Map<String, String>> gridValues) {
        this.gridValues = gridValues;
    }

    public ComponentDto(String id, String widgetId, String clientId, Integer sortOrder,
                        String type, String label, Boolean editable, String keyOrAction,
                        Boolean visible, String value, Boolean multiLevel,
                        Integer rowspan, Integer colspan, List<ComponentItemDto> componentItemDtos) {
        this.id = id;
        this.widgetId = widgetId;
        this.clientId = clientId;
        this.sortOrder = sortOrder;
        this.type = type;
        this.label = label;
        this.editable = editable;
        this.keyOrAction = keyOrAction;
        this.visible = visible;
        this.value = value;
        this.componentItemDtos = componentItemDtos;
        this.multiLevel = multiLevel;
        this.rowspan = rowspan;
        this.colspan = colspan;
    }

    public ComponentDto() {
    }
}
