package com.distarise.base.model;

import java.io.Serializable;

public class ClientDto implements Serializable {
    private String id;
    private String header;
    private String footer;
    private String logo;
    private String staticFolder;

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

    public String getStaticFolder() {
        return staticFolder;
    }

    public void setStaticFolder(String staticFolder) {
        this.staticFolder = staticFolder;
    }

    public ClientDto(String id, String header, String footer, String logo, String staticFolder) {
        this.id = id;
        this.header = header;
        this.footer = footer;
        this.logo = logo;
        this.staticFolder = staticFolder;
    }

    public ClientDto() {
    }
}
