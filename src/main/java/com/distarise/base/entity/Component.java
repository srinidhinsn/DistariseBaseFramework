package com.distarise.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "COMPONENT")
@IdClass(ComponentId.class)
public class Component implements Serializable {
    @Id
    @Column(name = "ID")
    private String id;

    @Id
    @Column(name = "WIDGETID")
    private String widgetId;

    @Id
    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "SORTORDER")
    private Integer sortOrder;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "EDITABLE")
    private Boolean editable;

    @Column(name = "REDIRECTURL")
    private String redirectUrl;

    @Column(name = "KEYORACTION")
    private String keyOrAction;

    @Column(name = "VISIBLE")
    private Boolean visible;

    @Column(name = "MULTILEVEL", columnDefinition = "boolean default false")
    private Boolean multiLevel;

    @Column(name = "VALUE")
    private String value;

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

    public Boolean getMultiLevel() {
        return multiLevel;
    }

    public void setMultiLevel(Boolean multiLevel) {
        this.multiLevel = multiLevel;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Component(String id, String widgetId, String clientId, Integer sortOrder,
                     String type, String label, Boolean editable, String redirectUrl,
                     String keyOrAction, Boolean visible, Boolean isMultiLevel, String value,
                     Integer rowspan, Integer colspan) {
        this.id = id;
        this.widgetId = widgetId;
        this.clientId = clientId;
        this.sortOrder = sortOrder;
        this.type = type;
        this.label = label;
        this.editable = editable;
        this.keyOrAction = keyOrAction;
        this.visible = visible;
        this.redirectUrl = redirectUrl;
        this.multiLevel = isMultiLevel;
        this.value = value;
        this.rowspan = rowspan;
        this.colspan = colspan;
    }

    public Component() {
    }
}
