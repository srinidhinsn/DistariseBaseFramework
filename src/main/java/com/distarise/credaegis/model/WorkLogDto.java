package com.distarise.credaegis.model;


import java.util.Date;

public class WorkLogDto {
    private Long id;
    private Long pid;
    private Long eid;
    private Long tid;
    private String taskName;
    private String status;
    private Date reviewDate;
    private Date lastUpdated;
    private String comment;

    public WorkLogDto() {
    }

    public WorkLogDto(Long id, Long pid, Long eid, Long tid, String taskName, String status, Date reviewDate, Date lastUpdated, String comment) {
        this.id = id;
        this.pid = pid;
        this.eid = eid;
        this.tid = tid;
        this.taskName = taskName;
        this.status = status;
        this.reviewDate = reviewDate;
        this.lastUpdated = lastUpdated;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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
