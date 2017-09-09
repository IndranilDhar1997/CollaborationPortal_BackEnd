package com.collaborate.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collaborate.dao.BlogCommentDAO;
import com.collaborate.dao.BlogDAO;
import com.collaborate.dao.UserDetailsDAO;
import com.collaborate.model.Blog;
import com.collaborate.model.BlogComment;
import com.collaborate.model.UserDetails;

@RestController
public class BlogCommentController {

	@Autowired
	Blog blog;
	@Autowired
	BlogDAO blogDAO;
	@Autowired
	UserDetails userDetails;
	@Autowired
	UserDetailsDAO userDetailsDAO;
	@Autowired
	BlogComment blogComment;
	@Autowired
	BlogCommentDAO blogCommentDAO;

	@PostMapping("/insertBcomment")
	public ResponseEntity<BlogComment> createblogComment(@RequestBody BlogComment blogComment) {

		blogComment.setCommentDate(new Date());
		blogCommentDAO.save(blogComment);
		return new ResponseEntity<BlogComment>(blogComment, HttpStatus.OK);
	}

	@GetMapping("/getBcomments")
	public ResponseEntity<List<BlogComment>> listblogComment() {
		List<BlogComment> listbComment = blogCommentDAO.list();
		return new ResponseEntity<List<BlogComment>>(listbComment, HttpStatus.OK);
	}
}
