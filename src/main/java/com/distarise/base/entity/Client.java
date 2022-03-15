package com.distarise.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "HEADER")
    private String header;

    @Column(name = "FOOTER")
    private String footer;

    @Column(name = "STATICFOLDER")
    private String staticFolder;

    @Column(name = "LOGO")
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

    public String getStaticFolder() {
        return staticFolder;
    }

    public void setStaticFolder(String staticFolder) {
        this.staticFolder = staticFolder;
    }

    public Client(String id, String header, String footer, String logo, String staticFolder) {
        this.id = id;
        this.header = header;
        this.footer = footer;
        this.logo = logo;
        this.staticFolder = staticFolder;
    }

    public Client() {
    }
}
