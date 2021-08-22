package com.te4a.springboot.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="thread")
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "threadIdGenerator")
    @SequenceGenerator(name = "threadIdGenerator", sequenceName = "threadIdSeq")
    @Column
    private int id;

    @Column(length = 100,nullable = true)
    private String name;

    @Column(nullable = true)
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
