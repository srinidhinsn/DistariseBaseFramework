package com.distarise.base.model;


public class LayoutDto {
    private String id;
    private Boolean topNav;
    private Boolean leftNav;
    private Boolean breadcrumbs;
    private Integer rows;
    private Integer cols;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getTopNav() {
        return topNav;
    }

    public void setTopNav(Boolean topNav) {
        this.topNav = topNav;
    }

    public Boolean getLeftNav() {
        return leftNav;
    }

    public void setLeftNav(Boolean leftNav) {
        this.leftNav = leftNav;
    }

    public Boolean getBreadcrumbs() {
        return breadcrumbs;
    }

    public void setBreadcrumbs(Boolean breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public LayoutDto(String id, Boolean topNav, Boolean leftNav, Boolean breadcrumbs, Integer rows, Integer cols) {
        this.id = id;
        this.topNav = topNav;
        this.leftNav = leftNav;
        this.breadcrumbs = breadcrumbs;
        this.rows = rows;
        this.cols = cols;
    }

    public LayoutDto() {
    }
}
