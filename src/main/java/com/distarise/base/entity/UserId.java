package com.distarise.base.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

public class UserId implements Serializable {

    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "USERID")
    private String userId;

    public UserId(String clientId, String userId) {
        this.clientId = clientId;
        this.userId = userId;
    }

    public UserId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserId userId1 = (UserId) o;

        if (!clientId.equals(userId1.clientId)) return false;
        return userId.equals(userId1.userId);
    }

    @Override
    public int hashCode() {
        int result = clientId.hashCode();
        result = 31 * result + userId.hashCode();
        return result;
    }
}
