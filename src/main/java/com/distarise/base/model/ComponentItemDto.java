package com.distarise.base.model;


import java.io.Serializable;

public class ComponentItemDto implements Serializable {
    public static int ID_MULTIPLIER = 100;
    private Long id;
    private String componentId;
    private String clientId;
    private Integer sortOrder;
    private String value;
    private String label;
    private Boolean editable;
    private Boolean visible;
    private Boolean selected;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ComponentItemDto(String componentId, String clientId,
                            Integer sortOrder, String value, String label, Boolean editable, Boolean visible,
                            String type) {
        this.componentId = componentId;
        this.clientId = clientId;
        this.sortOrder = sortOrder;
        this.value = value;
        this.label = label;
        this.editable = editable;
        this.visible = visible;
        this.type = type;
    }
    public ComponentItemDto(Long id, String componentId, String clientId,
                            Integer sortOrder, String value, String label, Boolean editable, Boolean visible,
                            String type) {
        this.id = id;
        this.componentId = componentId;
        this.clientId = clientId;
        this.sortOrder = sortOrder;
        this.value = value;
        this.label = label;
        this.editable = editable;
        this.visible = visible;
        this.type = type;
    }

    public ComponentItemDto() {
    }
}
