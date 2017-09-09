package com.collaborate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collaborate.dao.UserDetailsDAO;
import com.collaborate.model.Friend;
import com.collaborate.model.UserDetails;
import com.collaborate.model.UserProfile;


@RestController
public class UserController {

	@Autowired
	UserDetails userDetails;
	@Autowired
	UserDetailsDAO userDetailsDAO;
	@Autowired UserProfile userProfile;
	@Autowired Friend friend;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/register")
	public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails userDetails) {
		//userDetails.setRole("User");
		userDetailsDAO.save(userDetails);
		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<UserDetails> validateUser(@RequestBody UserDetails userDetails) {

		userDetails = userDetailsDAO.getUserByEmailId(userDetails.getEmailId());
		if (userDetails != null && ((userDetails.getPassword()).equals(userDetails.getPassword()))) {
			userDetails.setIsOnline("Online");
			userDetailsDAO.IsOnline(userDetails.getUserId());
			return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserDetails>(userDetails, HttpStatus.BAD_REQUEST);
		}
	}
	
	/*User profile insertion controller method*/
	
	@PostMapping("/saveUserProfile")
	public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile){
		
		userDetailsDAO.saveUserProfile(userProfile);
		return new ResponseEntity<UserProfile>(userProfile,HttpStatus.OK);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserDetails>> getAllUser(){
		List<UserDetails> getAllUser = userDetailsDAO.getAllUser();
		return new ResponseEntity<List<UserDetails>>(getAllUser,HttpStatus.OK);
	}
	
	@GetMapping("/myprofile/{userId}")
	public ResponseEntity<UserDetails> getMyProfile(@PathVariable("userId")int userId){
		
		UserDetails myprofile=userDetailsDAO.getUserByUserId(userId);
		return new ResponseEntity<UserDetails>(myprofile,HttpStatus.OK);
	}
	
	@PostMapping("/updateOffline")
	public ResponseEntity<UserDetails> updateOffline(@RequestBody UserDetails userDetails){
		userDetails.setIsOnline("Offline");
		userDetailsDAO.update(userDetails);
		System.out.println("property of userdetails:"+userDetails.getIsOnline());		
		return new ResponseEntity<UserDetails>(userDetails,HttpStatus.OK);
	}
	
	@PostMapping("/updateProfile")
	public ResponseEntity<UserDetails> updateProfile(@RequestBody UserDetails userDetails){
		userDetailsDAO.update(userDetails);
		return new ResponseEntity<UserDetails>(userDetails,HttpStatus.OK);
	}
}
