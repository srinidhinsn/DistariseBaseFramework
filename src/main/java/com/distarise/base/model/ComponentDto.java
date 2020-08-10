package com.distarise.base.model;


public class ComponentDto {
    private Long id;
    private Long widgetId;
    private String clientId;
    private Integer sortOrder;
    private String type;
    private String label;
    private Boolean editable;
    private String keyOrAction;
    private Boolean visible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWidgetId() {
        return widgetId;
    }

    public void setWidgetId(Long widgetId) {
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

    public ComponentDto(Long id, Long widgetId, String clientId, Integer sortOrder,
                     String type, String label, Boolean editable, String keyOrAction, Boolean visible) {
        this.id = id;
        this.widgetId = widgetId;
        this.clientId = clientId;
        this.sortOrder = sortOrder;
        this.type = type;
        this.label = label;
        this.editable = editable;
        this.keyOrAction = keyOrAction;
        this.visible = visible;
    }

    public ComponentDto() {
    }
}
