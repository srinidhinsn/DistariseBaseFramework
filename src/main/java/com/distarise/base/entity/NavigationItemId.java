package com.distarise.base.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class NavigationItemId implements Serializable {
    @Column(name = "UINAVID")
    private String navigationId;

    @Column(name = "ID")
    private String id;

    public NavigationItemId(String navigationId, String id) {
        this.navigationId = navigationId;
        this.id = id;
    }

    public NavigationItemId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NavigationItemId that = (NavigationItemId) o;
        return Objects.equals(navigationId, that.navigationId) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(navigationId, id);
    }
}
