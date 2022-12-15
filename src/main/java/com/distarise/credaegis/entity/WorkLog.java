package com.distarise.credaegis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "WORKLOG")
public class WorkLog implements Serializable {

    @Id
    @GeneratedValue(generator="s_worklog_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="s_worklog_id",sequenceName="S_WORKLOG_ID", initialValue = 1000, allocationSize=1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PID")
    private Long pid;

    @Column(name = "EID")
    private Long eid;

    @Column(name = "LID")
    private Long lid;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "REVIEWDATE")
    private Date reviewDate;

    @Column(name = "LASTUPDATED")
    private Date lastUpdated;

    @Column(name = "COMMENT")
    private String comment;

    public WorkLog() {
    }

    public WorkLog(Long id, Long pid, Long eid, Long lid, String title, String status, Date reviewDate, Date lastUpdated, String comment) {
        this.id = id;
        this.pid = pid;
        this.eid = eid;
        this.lid = lid;
        this.title = title;
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