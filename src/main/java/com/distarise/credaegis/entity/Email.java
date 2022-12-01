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
@Table(name = "EMAIL")
public class Email implements Serializable {
    @Id
    @GeneratedValue(generator="s_email_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="s_email_id",sequenceName="S_EMAIL_ID", initialValue = 1000, allocationSize=1)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PID", insertable = false, updatable = false)
    Person person;

    @Column(name = "PID")
    private Long pid;
    @Column(name = "EMAIL")
    private String email;

    public Email() {
    }

    public Email(Long id, Long pid, Person person, String email) {
        this.id = id;
        this.pid = pid;
        this.person = person;
        this.email = email;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
