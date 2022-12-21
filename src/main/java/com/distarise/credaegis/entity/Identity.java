package com.distarise.credaegis.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "IDENTITY")
public class Identity implements Serializable {
    @Id
    @GeneratedValue(generator="s_identity_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="s_identity_id",sequenceName="S_IDENTITY_ID", initialValue = 1000, allocationSize=1)
    @Column(name = "IID")
    private Long iid;
    @Column(name = "ID")
    private String id;

    @ManyToOne
    @JoinColumn(name = "PID", insertable = false, updatable = false)
    Person person;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "PID")
    private Long pid;

    public Identity() {
    }

    public Identity(String id, Long pid, Person person, String type) {
        this.pid = pid;
        this.id = id;
        this.person = person;
        this.type = type;
    }

    public Long getIid() {
        return iid;
    }

    public void setIid(Long iid) {
        this.iid = iid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
