package com.distarise.base.model;

public class ClientDto {
    private String id;
    private String header;
    private String footer;
    private String logo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public ClientDto(String id, String header, String footer, String logo) {
        this.id = id;
        this.header = header;
        this.footer = footer;
        this.logo = logo;
    }

    public ClientDto() {
    }
}
