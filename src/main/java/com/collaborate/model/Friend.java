package com.collaborate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Friend {

	@Id@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int friendId;
	@OneToOne
	private UserDetails friend;
	@OneToOne
	private UserDetails userDetails;
	
	private String status;
	
	private int initiator;

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public UserDetails getFriend() {
		return friend;
	}

	public void setFriend(UserDetails friend) {
		this.friend = friend;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getInitiator() {
		return initiator;
	}

	public void setInitiator(int initiator) {
		this.initiator = initiator;
	}
	
}
