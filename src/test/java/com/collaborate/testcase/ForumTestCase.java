package com.collaborate.testcase;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.dao.BlogDAO;
import com.collaborate.dao.ForumDAO;
import com.collaborate.dao.UserDetailsDAO;
import com.collaborate.model.Blog;
import com.collaborate.model.Forum;
import com.collaborate.model.UserDetails;

public class ForumTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired static Forum forum;
	@Autowired static ForumDAO forumDAO;
	@Autowired static UserDetails userDetails;
	@Autowired static UserDetailsDAO userDetailsDAO;
	
	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.collaborate");
		context.refresh();

		forumDAO = (ForumDAO) context.getBean("forumDAO");
		forum = (Forum) context.getBean("forum");
		userDetails = (UserDetails) context.getBean("userDetails");
		userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");

	}
	
	/*@Test
	public void createForumTestCase(){
		userDetails= new UserDetails();
		forum=new Forum();
		userDetails=userDetailsDAO.getUserByUserId(4);
		forum.setUserDetails(userDetails);
		forum.setForumName("Admission Forum");
		forum.setForumContent("This is a student Forum");
		forum.setStatus("A");
		forum.setCreateDate(new Date());
		boolean flag=forumDAO.save(forum);
		assertEquals("createForumTestCase",flag,true);
	}*/
/*	
	@Test
	public void updateForumTestCase(){
		userDetails=new UserDetails();
		forum=new Forum();
		forum=forumDAO.getForumByForumId(13);
		forum.setStatus("recent updation");
		boolean flag= forumDAO.update(forum);
		assertEquals("updateForumTestCase",true,flag);
	}*/
	
/*	@Test
	public void getAllForum(){
		
		int actualSize=forumDAO.list().size();
		assertEquals(2,actualSize);
	}*/
	
}
