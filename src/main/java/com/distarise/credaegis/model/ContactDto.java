package com.distarise.credaegis.model;


public class ContactDto {
    private Long cid;
    private String number;
    private String type;

    private Long pid;

    public ContactDto() {
    }

    public ContactDto(Long cid, Long pid, String number, String type) {
        this.cid = cid;
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

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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
