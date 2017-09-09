package com.collaborate.testcase;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.dao.BlogCommentDAO;
import com.collaborate.dao.BlogDAO;
import com.collaborate.dao.ForumCommentDAO;
import com.collaborate.dao.ForumDAO;
import com.collaborate.dao.UserDetailsDAO;
import com.collaborate.model.Blog;
import com.collaborate.model.BlogComment;
import com.collaborate.model.Forum;
import com.collaborate.model.ForumComment;
import com.collaborate.model.UserDetails;


public class ForumCommentTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static UserDetails userDetails;
	@Autowired
	static UserDetailsDAO userDetailsDAO;
	
	@Autowired static Forum forum;
	@Autowired static ForumDAO forumDAO;
	@Autowired static ForumComment forumComment;
	@Autowired static ForumCommentDAO forumCommentDAO;
	
	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.collaborate");
		context.refresh();

		forum = (Forum) context.getBean("forum");
		forumDAO = (ForumDAO) context.getBean("forumDAO");
	
		userDetails = (UserDetails) context.getBean("userDetails");
		userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		forumComment=(ForumComment) context.getBean("forumComment");
		forumCommentDAO=(ForumCommentDAO) context.getBean("forumCommentDAO");
		

	}
	
	/*@Test
	public void createForumCommentTestCase(){
		
		userDetails=new UserDetails();
		forum=new Forum();
		forumComment=new ForumComment();
		
		userDetails=userDetailsDAO.getUserByUserId(3);
		forum=forumDAO.getForumByForumId(14);
		forumComment.setUserDetails(userDetails);
		forumComment.setForum(forum);
		forumComment.setFcomDate(new Date());
		forumComment.setForumComment("updation coming");
		
		boolean flag= forumCommentDAO.save(forumComment);
		assertEquals("createForumCommentTestCase", true,flag);
	}
	*/
	
	/*	@Test
	public void updateForumCommentTestCase(){
	
		forumComment= new ForumComment();
		forumComment=forumCommentDAO.getForumCommentByForumCommentId(15);
		forumComment.setForumComment("This is updated forum comment");
		boolean flag=forumCommentDAO.update(forumComment);
		assertEquals("ForumCommentTestCase", flag,true);
	
	
}*/

	
	/*@Test
	public void getAllForumComment(){
		
		int actualSize=forumCommentDAO.list().size();
		assertEquals(2,actualSize);
	}*/
}
