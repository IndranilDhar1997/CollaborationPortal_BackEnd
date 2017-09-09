package com.collaborate.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collaborate.dao.ForumDAO;
import com.collaborate.dao.UserDetailsDAO;
import com.collaborate.model.Blog;
import com.collaborate.model.Forum;
import com.collaborate.model.UserDetails;

@RestController
public class ForumController {

	@Autowired Forum forum;
	@Autowired ForumDAO forumDAO;
	@Autowired UserDetails userDetails;
	@Autowired UserDetailsDAO userDetailsDAO;
	
	@GetMapping(value="/getForums")
	public ResponseEntity<List<Forum>> list()
	{
		List<Forum> listForums=forumDAO.list();
		return new ResponseEntity<List<Forum>>(listForums,HttpStatus.OK);
	}
	
	@PostMapping(value="/insertForum")
	public ResponseEntity<Forum> createForum(@RequestBody Forum forum){
		
		
	    forum.setCreateDate(new Date());
	    forumDAO.save(forum);
	
		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/deleteForum")
	public ResponseEntity<String> deleteForum(@RequestBody Forum forum) {
		
		if (forumDAO.delete(forum))
			return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
		else
			return new ResponseEntity<String>("problem in deletion", HttpStatus.NOT_IMPLEMENTED);

	}

	@PostMapping(value = "/updateForum")
	public ResponseEntity<String> updateforum(@RequestBody Forum forum) {

	if(forumDAO.update(forum)){
		return new ResponseEntity<String>("Succesfully Updated",HttpStatus.OK);
	}else{
		return new ResponseEntity<String>("Problem in updation",HttpStatus.BAD_REQUEST);
	}
	}


	
	
	
}
