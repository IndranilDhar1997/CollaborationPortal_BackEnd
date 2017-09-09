package com.collaborate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collaborate.dao.FriendDAO;
import com.collaborate.model.Friend;
import com.collaborate.model.UserDetails;

@RestController
public class FriendController {

	@Autowired FriendDAO friendDAO;
	@Autowired Friend friend;
	
	@PostMapping("/sendRequest")
	public ResponseEntity<Void> sendRequest(@RequestBody Friend friend)
	{
		if(friendDAO.addFriend(friend)==true){
			Friend f = new Friend();
			f.setUserDetails(friend.getFriend());
			f.setFriend(friend.getUserDetails());
			f.setStatus("new");
			f.setInitiator(0);
			friendDAO.addFriend(f);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/acceptfriend")
	public ResponseEntity<Void> acceptfriend(@RequestBody Friend friend){
		if(friendDAO.updateFriend(friend)==true){
			Friend frnd=friendDAO.getByid(friend.getFriend().getUserId(), friend.getUserDetails().getUserId());
			frnd.setStatus(friend.getStatus());
			friendDAO.updateFriend(frnd);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallfriends/{userId}")
	public ResponseEntity<List<Friend>> getAllFriends(@PathVariable("userId")int userId){
		
		List<Friend> myfriends = friendDAO.getmyFriends(userId);
		return new ResponseEntity<List<Friend>>(myfriends,HttpStatus.OK);
	}
	
	@GetMapping("getmysendrequest/{userId}")
	public ResponseEntity<List<Friend>> getmysendrequest(@PathVariable("userId") int userId){
		
		List<Friend> mysentrequest = friendDAO.getmySentRequest(userId);
		return new ResponseEntity<List<Friend>>(mysentrequest,HttpStatus.OK);
		
	}

	@GetMapping("/getmyrequest/{userId}")
	public ResponseEntity<List<Friend>> getmyrequest(@PathVariable("userId") int userId){
		
		List<Friend> myrequest=friendDAO.showmyFriendRequest(userId);
		return new ResponseEntity<List<Friend>>(myrequest,HttpStatus.OK);
	}
}
