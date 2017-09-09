package com.collaborate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.model.JobApplication;
import com.collaborate.model.JobDetail;

@Repository("jobDetailDAO")
@Transactional
public class JobDetailDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean save(JobDetail jobDetail) {
		try {
			sessionFactory.getCurrentSession().save(jobDetail);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(JobDetail jobDetail) {
		try {
			sessionFactory.getCurrentSession().update(jobDetail);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<JobDetail> jobList() {
		return sessionFactory.getCurrentSession().createQuery("from JobDetail").list();
	}
	public boolean save (JobApplication jobApplication){
		try{
			sessionFactory.getCurrentSession().save(jobApplication);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public List<JobApplication> getCandidatesByJobId(int jobId){
		return sessionFactory.getCurrentSession().createQuery("from JobApplication where jobDetail.jobId='"+jobId+"'").list();
		
	}
	
	public List<JobApplication> jobApplicationList(){
		return sessionFactory.getCurrentSession().createQuery("from JobApplication").list();
	}
	
	
	public boolean update(JobApplication jobApplication){
		try{
			sessionFactory.getCurrentSession().update(jobApplication);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}



