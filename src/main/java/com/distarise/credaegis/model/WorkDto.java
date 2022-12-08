package com.distarise.credaegis.model;


import java.util.Date;

public class WorkDto {

    private Long pid;
    private Long eid;
    private Long lid;
    private String employeeName;
    private String title;
    private String status;
    private Date reviewDate;
    private Date lastUpdated;
    private String comment;

    public WorkDto() {
    }

    public WorkDto(Long pid, Long eid, Long lid, String title, String status, Date reviewDate, Date lastUpdated, String comment) {
        this.pid = pid;
        this.eid = eid;
        this.lid = lid;
        this.title = title;
        this.status = status;
        this.reviewDate = reviewDate;
        this.lastUpdated = lastUpdated;
        this.comment = comment;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
