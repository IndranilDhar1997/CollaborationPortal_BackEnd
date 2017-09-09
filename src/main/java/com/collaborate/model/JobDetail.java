package com.collaborate.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity	
@Component
public class JobDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int jobId;
	private String jobTitle;
	private String jobDesc;
	private Date postDate;
	private String qualification;
	private String status;
	
/*	@JsonManagedReference
	@OneToMany(mappedBy="jobDetail",fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private JobApplication jobApplication;
	
	
	public JobApplication getJobApplication() {
		return jobApplication;
	}
	public void setJobApplication(JobApplication jobApplication) {
		this.jobApplication = jobApplication;
	}*/
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
