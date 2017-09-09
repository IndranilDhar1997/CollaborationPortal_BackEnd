package com.collaborate.testcase;

import java.util.Date;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.dao.JobDetailDAO;
import com.collaborate.model.JobDetail;

public class JobDetailTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static JobDetail jobDetail;
	@Autowired static JobDetailDAO jobDetailDAO;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.collaborate");
		context.refresh();
		
		jobDetail=(JobDetail) context.getBean("jobDetail");
		jobDetailDAO=(JobDetailDAO) context.getBean("jobDetailDAO");
		
	}
/*	
	@Test
	public void createJobDetailTestCase(){
		jobDetail =new JobDetail();
		jobDetail.setJobTitle("Software Developer");
		jobDetail.setJobDesc("2-3 years Experience");
		jobDetail.setQualification("B.Tech");
		jobDetail.setPostDate(new Date());
		jobDetail.setStatus("vacant");
		boolean flag=jobDetailDAO.save(jobDetail);
		assertEquals("createJobDetailTestCase", flag,true);
	}*/
}
