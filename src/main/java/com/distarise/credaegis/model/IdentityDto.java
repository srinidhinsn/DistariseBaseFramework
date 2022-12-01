package com.distarise.credaegis.model;


public class IdentityDto {
    private String id;
    private String type;

    private Long pid;

    public IdentityDto() {
    }

    public IdentityDto(String id, Long pid, String type) {
        this.id = id;
        this.pid = pid;
        this.type = type;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
