package com.distarise.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "COMPONENTITEM")
public class ComponentItem implements Serializable {

    @Id
    @GeneratedValue(generator="s_componentitem_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="s_componentitem_id",sequenceName="S_COMPONENTITEM_ID", initialValue = 1000, allocationSize=1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COMPONENTID")
    private String componentId;

    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "SORTORDER")
    private Integer sortOrder;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "EDITABLE", columnDefinition = "boolean default true")
    private Boolean editable;

    @Column(name = "VISIBLE", columnDefinition = "boolean default true")
    private Boolean visible;

    @Column(name = "SELECTED", columnDefinition = "boolean default false")
    private Boolean selected;

    @Column(name = "TYPE")
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

    public ComponentItem(String componentId, String clientId,
                         Integer sortOrder, String value, String label, Boolean editable, Boolean visible, Long id,
                         String type) {
        this.componentId = componentId;
        this.clientId = clientId;
        this.sortOrder = sortOrder;
        this.value = value;
        this.label = label;
        this.editable = editable;
        this.visible = visible;
        this.id = id;
        this.type = type;
    }

    public ComponentItem() {
    }
}
