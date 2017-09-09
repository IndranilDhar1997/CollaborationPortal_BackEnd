package com.collaborate.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collaborate.dao.JobDetailDAO;
import com.collaborate.dao.UserDetailsDAO;
import com.collaborate.model.JobApplication;
import com.collaborate.model.JobDetail;
import com.collaborate.model.UserDetails;
import com.collaborate.model.UserProfile;

@RestController
public class JobDetailController {

	@Autowired
	JobDetail jobDetail;
	@Autowired
	JobDetailDAO jobDetailDAO;
	@Autowired JobApplication jobApplication;
	@Autowired UserDetails userDetails;
	@Autowired UserProfile userProfile;
	@Autowired UserDetailsDAO userDetailsDAO;

	@PostMapping("/postJob")
	public ResponseEntity<JobDetail> postJob(@RequestBody JobDetail jobDetail){
		jobDetail.setPostDate(new Date());
		jobDetailDAO.save(jobDetail);
		return new ResponseEntity<JobDetail>(jobDetail,HttpStatus.OK);
	}
	
	@GetMapping("/getJobs")
	public ResponseEntity<List<JobDetail>> getJobs(){
		List<JobDetail> jobs=jobDetailDAO.jobList();
		return new ResponseEntity<List<JobDetail>>(jobs,HttpStatus.OK);
	}
	
	@PostMapping("/insertJobApplication")	
	public ResponseEntity<JobApplication> insertJobAppDetail(@RequestBody JobApplication jobApplication){
		jobApplication.setJobApplied(new Date());
		jobApplication.setRemarks("eligible");
		jobApplication.setStatus("new");
	   /* UserProfile userProfile=userDetailsDAO.getProfileByUserId(userDetails.getUserId());
	    jobApplication.setUserProfile(userProfile);		*/
		jobDetailDAO.save(jobApplication);
		return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.OK);
	}
	
	@GetMapping("/getAppliedCandidates/{jobId}")
	public ResponseEntity<List<JobApplication>> getCandidatesByJobId(@PathVariable("jobId")int jobId){
		
		List<JobApplication> getAppliedCandidate=jobDetailDAO.getCandidatesByJobId(jobId);
		return new ResponseEntity<List<JobApplication>>(getAppliedCandidate, HttpStatus.OK);
	}
	
	@GetMapping("/AllJobApplication")
	public ResponseEntity<List<JobApplication>> getAllJobApplication(){
	    List<JobApplication>listjobapplication=jobDetailDAO.jobApplicationList();
		return new ResponseEntity<List<JobApplication>>(listjobapplication,HttpStatus.OK);
	}
	
	@PostMapping("/updateJobApplication")
	public ResponseEntity<JobApplication> updateJobApplication(@RequestBody JobApplication jobApplication){
	   jobDetailDAO.update(jobApplication);
	   return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.OK);
	}



}

