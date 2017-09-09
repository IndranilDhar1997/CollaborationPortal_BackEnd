package com.collaborate.testcase;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.dao.UserDetailsDAO;
import com.collaborate.model.UserDetails;


public class UserDetailsTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static UserDetails userDetails;
	@Autowired static UserDetailsDAO userDetailsDAO;
	
	
	@BeforeClass
	public static void init(){
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com.collaborate");
		//context.refresh();
		
		userDetails=(UserDetails) context.getBean("userDetails");
		userDetailsDAO=(UserDetailsDAO) context.getBean("userDetailsDAO");
		
	}

	/*@Test
	public void createUserDetailsTestCase(){
		
		UserDetails userDetails=new UserDetails();
		userDetails.setUserName("Monojit Saha");
		userDetails.setEmailId("mono@yahoo.in");
		userDetails.setPassword("00000");
		userDetails.setRole("User");
		userDetails.setStatus("Activate");
		userDetails.setIsOnline("No");
		
		boolean flag=userDetailsDAO.save(userDetails);
		assertEquals("createUserDetailsTestCase", flag,true);
	}*/
	
	/*@Test
	public void updateUserDetailsTestCase(){
		UserDetails userDetails= new UserDetails();
		userDetails=userDetailsDAO.getUserByUserId(3);
		userDetails.setEmailId("jon@yahoo.in");
		boolean flag=userDetailsDAO.update(userDetails);
		assertEquals("updateUserDetailsTestCase", flag,true);
	}*/
	
	/*@Test
	public void getAllUser(){
		
		int actualSize=userDetailsDAO.list().size();
		assertEquals(4,actualSize);
	}*/
}
