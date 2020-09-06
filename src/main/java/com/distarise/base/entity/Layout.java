package com.distarise.base.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LAYOUT")
public class Layout {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "TOPNAV")
    private Boolean topNav;

    @Column(name = "LEFTNAV")
    private Boolean leftNav;

    @Column(name = "BREADCRUMBS")
    private Boolean breadcrumbs;

    @Column(name = "ROWS")
    private Integer rows;

    @Column(name = "COLS")
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

    public Layout(String id, Boolean topNav, Boolean leftNav, Boolean breadcrumbs, Integer rows, Integer cols) {
        this.id = id;
        this.topNav = topNav;
        this.leftNav = leftNav;
        this.breadcrumbs = breadcrumbs;
        this.rows = rows;
        this.cols = cols;
    }

    public Layout() {
    }
}
