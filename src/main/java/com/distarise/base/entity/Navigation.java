package com.distarise.base.entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "UINAV")
public class Navigation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CLIENTID")
    private String clientId;

    @Column(name = "ROLENAME")
    private String roleName;

    @Column(name = "PAGETITLE")
    private String pageTitle;

    @Column(name = "PAGEDESCRIPTION")
    private String pageDescription;

    @Column(name = "MODULE")
    private String module;

    @Column(name = "PAGENAME")
    private String pageName;

    @Column(name = "REDIRECTPAGENAME")
    private String redirectPageName;

    @Column(name = "CSSCLASS")
    private String cssClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getRedirectPageName() {
        return redirectPageName;
    }

    public void setRedirectPageName(String redirectPageName) {
        this.redirectPageName = redirectPageName;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public Navigation(Long id, String clientId, String roleName, String pageTitle,
                      String pageDescription, String module, String pageName,
                      String redirectPageName, String cssClass) {
        this.id = id;
        this.clientId = clientId;
        this.roleName = roleName;
        this.pageTitle = pageTitle;
        this.pageDescription = pageDescription;
        this.module = module;
        this.pageName = pageName;
        this.redirectPageName = redirectPageName;
        this.cssClass = cssClass;
    }

    public Navigation() {
    }
}
