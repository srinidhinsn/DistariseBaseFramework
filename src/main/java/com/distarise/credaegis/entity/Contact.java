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
@Table(name = "CONTACT")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(generator="s_contact_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="s_contact_id",sequenceName="S_CONTACT_ID", initialValue = 1000, allocationSize=1)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PID", insertable = false, updatable = false)
    Person person;

    @Column(name = "PID")
    private Long pid;

    @Column(name = "NUMBER", length = 12)
    private String number;

    @Column(name = "TYPE")
    private String type;

    public Contact() {
    }

    public Contact(Long id, Long pid, Person person, String number, String type) {
        this.id = id;
        this.pid = pid;
        this.person = person;
        this.number = number;
        this.type = type;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
