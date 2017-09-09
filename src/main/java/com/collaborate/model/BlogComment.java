package com.collaborate.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Component
public class BlogComment {

	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int bcomId;
	private String blogComment;
	private Date commentDate;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private UserDetails userDetails;
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Blog blog;

	public int getBcomId() {
		return bcomId;
	}

	public void setBcomId(int bcomId) {
		this.bcomId = bcomId;
	}

	public String getBlogComment() {
		return blogComment;
	}

	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
}
