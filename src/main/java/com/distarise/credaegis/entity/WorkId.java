package com.distarise.credaegis.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class WorkId implements Serializable {
    @Column(name = "PID")
    private Long pid;

    @Column(name = "EID")
    private Long eid;

    @Column(name = "LID")
    private Long lid;

    public WorkId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkId that = (WorkId) o;
        return Objects.equals(pid, that.pid) &&
                Objects.equals(lid, that.lid) &&
                Objects.equals(eid, that.eid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lid, eid, pid);
    }
}
