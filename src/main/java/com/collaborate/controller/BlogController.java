package com.collaborate.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collaborate.dao.BlogDAO;
import com.collaborate.dao.UserDetailsDAO;
import com.collaborate.model.Blog;
import com.collaborate.model.JobApplication;
import com.collaborate.model.UserDetails;

@RestController
public class BlogController {

	@Autowired
	Blog blog;
	@Autowired
	BlogDAO blogDAO;
	@Autowired
	UserDetails userDetails;
	@Autowired
	UserDetailsDAO userDetailsDAO;

	@GetMapping(value = "/getBlogs")
	public ResponseEntity<List<Blog>> list() {
		List<Blog> listBlogs = blogDAO.list();
		return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.OK);
	}

	@PostMapping(value = "/insertBlog")
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {

		blog.setCreateDate(new Date());
		blogDAO.save(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);

	}
	
	
	

	@PostMapping(value = "/updateBlog")
	public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {

	blogDAO.update(blog);
	return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	
	
/*	@GetMapping("/getBlogByBlogId/{blogId}")
	public ResponseEntity<List<Blog>> getBlogByBlogId(@PathVariable("blogId")int blogId){
		
		List<Blog> getBlogByBlogId=blogDAO.getBlogByBlogId(blogId);
		return new ResponseEntity<List<Blog>>(getBlogByBlogId, HttpStatus.OK);
	}
*/
}
