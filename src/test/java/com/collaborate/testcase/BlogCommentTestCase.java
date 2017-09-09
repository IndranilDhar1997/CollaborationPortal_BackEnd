package com.collaborate.testcase;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.dao.BlogCommentDAO;
import com.collaborate.dao.BlogDAO;
import com.collaborate.dao.UserDetailsDAO;
import com.collaborate.model.Blog;
import com.collaborate.model.BlogComment;
import com.collaborate.model.UserDetails;

public class BlogCommentTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static Blog blog;
	@Autowired
	static BlogDAO blogDAO;
	@Autowired
	static UserDetails userDetails;
	@Autowired
	static UserDetailsDAO userDetailsDAO;
	@Autowired
	static BlogCommentDAO blogCommentDAO;
	@Autowired
	static BlogComment blogComment;
	
	
	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.collaborate");
		context.refresh();

		blogDAO = (BlogDAO) context.getBean("blogDAO");
		blog = (Blog) context.getBean("blog");
		userDetails = (UserDetails) context.getBean("userDetails");
		userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		blogComment=(BlogComment) context.getBean("blogComment");
		blogCommentDAO=(BlogCommentDAO) context.getBean("blogCommentDAO");
		

	}

	/*@Test
	public void createBlogCommentTestCase(){
		UserDetails userDetails = new UserDetails();
		Blog blog= new Blog();
		BlogComment  blogComment = new BlogComment();
		userDetails=userDetailsDAO.getUserByUserId(3);
		blog=blogDAO.getBlogByBlogId(7);
		blogComment.setUserDetails(userDetails);
		blogComment.setBlog(blog);
		blogComment.setCommentDate(new Date());
		blogComment.setBlogComment("Carry On");
		
		boolean flag= blogCommentDAO.save(blogComment);
		assertEquals("createBlogCommentTestCase", flag,true);
		
	}*/
	
	/*	@Test
	public void updateBlogCommentTestCase(){
		BlogComment blogComment= new BlogComment();
		blogComment=blogCommentDAO.getBlogCommentByBcomId(11);
		blogComment.setBlogComment("This is updated blog comment");
		boolean flag=blogCommentDAO.update(blogComment);
		assertEquals("BlogCommentTestCase", flag,true);
	
	
}*/
	
	
/*	@Test
	public void getAllBlogComment(){
		
		int actualSize=blogCommentDAO.list().size();
		assertEquals(3,actualSize);
	}*/
}