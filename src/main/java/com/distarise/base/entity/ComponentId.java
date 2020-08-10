package com.distarise.base.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class ComponentId implements Serializable {
    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "ID")
    private String id;

    public ComponentId(String clientId, String id) {
        this.clientId = clientId;
        this.id = id;
    }

    public ComponentId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComponentId that = (ComponentId) o;

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
