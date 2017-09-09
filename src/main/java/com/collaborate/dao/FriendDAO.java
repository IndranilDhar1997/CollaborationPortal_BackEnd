package com.collaborate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.model.Friend;

@Repository("friendDAO")
@Transactional
public class FriendDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().save(friend);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().update(friend);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Friend getByid(int friendId, int userId) {
		return (Friend) sessionFactory.getCurrentSession()
				.createQuery("from Friend where userDetails.userId='" + friendId + "' and friend.userId='" + userId + "'")
				.uniqueResult();

	}

	public List<Friend> getmyFriends(int userId) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Friend where friend.userId='" + userId + "'and status='Confirm'").list();
	}

	public List<Friend> getmySentRequest(int userId) {

		return sessionFactory.getCurrentSession()
				.createQuery("from Friend where userDetails.userId='" + userId + "' and status='new' and initiator='1'")
				.list();
	}

	public List<Friend> showmyFriendRequest(int userId) {

		return sessionFactory.getCurrentSession()
				.createQuery("from Friend where userDetails.userId='" + userId + "' and status='new' and initiator='0'")
				.list();
	}

}
