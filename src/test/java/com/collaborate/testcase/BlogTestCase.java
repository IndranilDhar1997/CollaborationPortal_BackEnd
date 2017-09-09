package com.collaborate.testcase;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.dao.BlogDAO;
import com.collaborate.dao.UserDetailsDAO;
import com.collaborate.model.Blog;
import com.collaborate.model.UserDetails;

public class BlogTestCase {

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

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.collaborate");
		context.refresh();

		blogDAO = (BlogDAO) context.getBean("blogDAO");
		blog = (Blog) context.getBean("blog");
		userDetails = (UserDetails) context.getBean("userDetails");
		userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");

	}
	
	/*@Test
	public void createBlogTestCase(){
		Blog blog = new Blog();
		UserDetails userDetails = new UserDetails();
		userDetails=userDetailsDAO.getUserByUserId(4);
		blog.setUserDetails(userDetails);
		blog.setBlogName("SAP");
		blog.setBlogContent("New Launched");
		blog.setLikes(1332);
		blog.setStatus("NA");
		blog.setCreateDate(new Date());
		
		boolean flag = blogDAO.save(blog);
		assertEquals("createBlogTestCase", true,flag);
	}*/

	
	
/*	@Test
	public void updateBlogTestCase(){
		Blog blog= new Blog();
		blog=blogDAO.getBlogByBlogId(6);
		blog.setCreateDate(new Date());
		boolean flag=blogDAO.update(blog);
		assertEquals("BlogTestCase", flag,true);
	}
	*/
	
	/*@Test
	public void deleteBlogTestCase(){
		Blog blog = new Blog();
		blog=blogDAO.getBlogByBlogId(6);
		boolean flag=blogDAO.delete(6);
		assertEquals("deleteBlogTestCase", flag,true);
	}*/
	/*@Test
	public void getAllBlog(){
		
		int actualSize=blogDAO.list().size();
		assertEquals(3,actualSize);
	}*/
}
