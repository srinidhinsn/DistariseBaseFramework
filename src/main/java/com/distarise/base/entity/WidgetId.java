package com.distarise.base.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class WidgetId implements Serializable {
    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "ID")
    private String id;

    @Column(name = "NAVITEMID")
    private String navigationItemId;

    public WidgetId(String clientId, String id, String navigationItemId) {
        this.clientId = clientId;
        this.id = id;
        this.navigationItemId = navigationItemId;
    }

    public WidgetId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WidgetId that = (WidgetId) o;

        if (!clientId.equals(that.clientId)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        int result = clientId.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }
}
