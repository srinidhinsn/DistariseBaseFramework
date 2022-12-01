package com.distarise.credaegis.model;


public class EmailDto {
    private Long id;
    private String email;

    private Long pid;

    public EmailDto() {
    }

    public EmailDto(Long id, Long pid, String email) {
        this.id = id;
        this.pid = pid;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
