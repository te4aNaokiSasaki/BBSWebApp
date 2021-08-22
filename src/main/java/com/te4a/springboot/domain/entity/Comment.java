package com.te4a.springboot.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentIdGenerator")
    @SequenceGenerator(name = "commentIdGenerator", sequenceName = "commentIdSeq")
    @Column
    private int id;

	@Column(nullable = false)
	private int threadId;
	
	@Column(nullable = false)
	private String handleName;;
	
	@Column(nullable = false)
	private String comment;
	
	@Column(nullable = false)
	private Date commentDate;;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public String getHandleName() {
		return handleName;
	}

	public void setHandleName(String handleName) {
		this.handleName = handleName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
}
