package com.collaborate.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Component
public class JobApplication {

	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int jobAppliedId;
	private Date jobApplied;
	private String remarks;
	private String status;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	private JobDetail jobDetail;
	
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private UserDetails userDetails;



	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public int getJobAppliedId() {
		return jobAppliedId;
	}

	public void setJobAppliedId(int jobAppliedId) {
		this.jobAppliedId = jobAppliedId;
	}

	public Date getJobApplied() {
		return jobApplied;
	}

	public void setJobApplied(Date jobApplied) {
		this.jobApplied = jobApplied;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JobDetail getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}




}
