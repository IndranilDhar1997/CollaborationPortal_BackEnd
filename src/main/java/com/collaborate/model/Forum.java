package com.collaborate.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Component
public class Forum {

	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int forumId;
	private String forumName;
	private Date createDate;
	private String status;
	private String forumContent;
	
	@JsonManagedReference	
	@OneToMany(mappedBy="forum",fetch=FetchType.EAGER)
	private Set<ForumComment> forumComment;
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private UserDetails userDetails;

	
	public String getForumContent() {
		return forumContent;
	}

	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
	}


	
	public Set<ForumComment> getForumComment() {
		return forumComment;
	}

	public void setForumComment(Set<ForumComment> forumComment) {
		this.forumComment = forumComment;
	}
	
	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
	
}

