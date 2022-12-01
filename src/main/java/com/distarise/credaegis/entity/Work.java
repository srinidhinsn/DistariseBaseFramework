package com.distarise.credaegis.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "WORK")
@IdClass(WorkId.class)
public class Work implements Serializable {

    @Id
    @Column(name = "PID")
    private Long pid;

    @Id
    @Column(name = "EID")
    private Long eid;

    @Id
    @Column(name = "TID")
    private Long tid;

    @Column(name = "TASKNAME")
    private String taskName;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "REVIEWDATE")
    private Date reviewDate;

    @Column(name = "LASTUPDATED")
    private Date lastUpdated;

    @Column(name = "COMMENT")
    private String comment;

    public Work() {
    }

    public Work(Long pid, Long eid, Long tid, String taskName, String status, Date reviewDate, Date lastUpdated, String comment) {
        this.pid = pid;
        this.eid = eid;
        this.tid = tid;
        this.taskName = taskName;
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
