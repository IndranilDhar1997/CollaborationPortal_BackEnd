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

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Component
public class Blog {
	
	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int blogId;
	private String blogName;
	private String blogContent;
	private Date createDate;
	private String Status;
	//private int likes;
	
	
	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	
	
    @JsonManagedReference
	@OneToMany(mappedBy="blog",fetch=FetchType.EAGER)
	private Set<BlogComment> blogComment;
	
	public Set<BlogComment> getBlogComment() {
		return blogComment;
	}

	public void setBlogComment(Set<BlogComment> blogComment) {
		this.blogComment = blogComment;
	}

	@ManyToOne(cascade=CascadeType.PERSIST)
	private UserDetails userDetails;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	/*public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}*/

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}


	
}
