package com.distarise.credaegis.model;


public class ContactDto {
    private Long id;
    private String number;
    private String type;

    private Long pid;

    public ContactDto() {
    }

    public ContactDto(Long id, Long pid, String number, String type) {
        this.id = id;
        this.pid = pid;
        this.number = number;
        this.type = type;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
