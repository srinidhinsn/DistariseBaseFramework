package com.distarise.base.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class ComponentId implements Serializable {
    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "ID")
    private String id;

    @Column (name = "WIDGETID")
    private String widgetId;

    public ComponentId(String clientId, String id, String widgetId) {
        this.clientId = clientId;
        this.id = id;
        this.widgetId = widgetId;
    }

    public ComponentId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponentId that = (ComponentId) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(id, that.id) &&
                Objects.equals(widgetId, that.widgetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, id, widgetId);
    }
}
