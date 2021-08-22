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

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String handleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHandleName() {
		return handleName;
	}

	public void setHandleName(String handleName) {
		this.handleName = handleName;
	}

}
