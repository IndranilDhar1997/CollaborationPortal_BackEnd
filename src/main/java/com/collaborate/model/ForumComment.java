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
public class ForumComment {

	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int fcomId;
	private String forumComment;
	private Date fcomDate;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private UserDetails userDetails;
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Forum forum;

	public int getFcomId() {
		return fcomId;
	}

	public void setFcomId(int fcomId) {
		this.fcomId = fcomId;
	}

	public String getForumComment() {
		return forumComment;
	}

	public void setForumComment(String forumComment) {
		this.forumComment = forumComment;
	}

	public Date getFcomDate() {
		return fcomDate;
	}

	public void setFcomDate(Date fcomDate) {
		this.fcomDate = fcomDate;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}
	
	
}
