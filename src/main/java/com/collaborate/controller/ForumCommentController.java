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

import com.collaborate.dao.ForumCommentDAO;
import com.collaborate.dao.ForumDAO;
import com.collaborate.dao.UserDetailsDAO;
import com.collaborate.model.BlogComment;
import com.collaborate.model.Forum;
import com.collaborate.model.ForumComment;
import com.collaborate.model.UserDetails;

@RestController
public class ForumCommentController {

	@Autowired
	Forum forum;
	@Autowired
	ForumDAO forumDAO;
	@Autowired
	UserDetails userDetails;
	@Autowired
	UserDetailsDAO userDetailsDAO;
	@Autowired
	ForumComment forumComment;
	@Autowired
	ForumCommentDAO forumCommentDAO;
	
	
	@PostMapping("/insertFcomment")
	public ResponseEntity<ForumComment> createforumComment(@RequestBody ForumComment forumComment) {

	forumComment.setFcomDate(new Date());
		forumCommentDAO.save(forumComment);
		return new ResponseEntity<ForumComment>(forumComment, HttpStatus.OK);
	}
	

	@GetMapping("/getFcomments")
	public ResponseEntity<List<ForumComment>> listforumComment() {
		List<ForumComment> listfComment = forumCommentDAO.list();
		return new ResponseEntity<List<ForumComment>>(listfComment, HttpStatus.OK);
	}
}
