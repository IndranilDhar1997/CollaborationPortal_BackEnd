package com.collaborate.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.collaborate.model.UserDetails;
import com.collaborate.model.UserProfile;

@Repository("userDetailsDAO")
@Transactional

public class UserDetailsDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean save(UserDetails userDetails) {

		try {
			sessionFactory.getCurrentSession().save(userDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(UserDetails userDetails) {

		try {
			sessionFactory.getCurrentSession().update(userDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public UserDetails getUserByEmailId(String emailId) {
		UserDetails userDetails;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from UserDetails where emailId=?");
			query.setParameter(0, emailId);
			userDetails = (UserDetails) query.uniqueResult();
		} catch (Exception e) {
			userDetails = null;
			e.printStackTrace();
		}
		return userDetails;
	}

	public UserDetails getUserByUserId(int userId) {
		return (UserDetails) sessionFactory.getCurrentSession().get(UserDetails.class, userId);
	}

	/* User Profile insertion DAO */
	public boolean saveUserProfile(UserProfile userProfile) {
		try {
			sessionFactory.getCurrentSession().save(userProfile);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<UserDetails> getAllUser(){
		return sessionFactory.getCurrentSession().createQuery("from UserDetails").list();
	}
	
	public void IsOnline(int userId){
		
	/*	String hql="UPDATE Friend SET isOnline='Online' where friendId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, friendId);
		query.executeUpdate();*/
		
		sessionFactory.getCurrentSession().createQuery
		("UPDATE UserDetails SET isOnline='Online' where userId='"+userId+"'").executeUpdate();
				
	}
	
	
    /*   public void IsOffline(int userId){
		
		String hql="UPDATE Friend SET isOnline='Offline' where friendId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, friendId);
		query.executeUpdate();
    	   
    	 sessionFactory.getCurrentSession().createQuery
   		("UPDATE UserDetails SET isOnline='Oline' where userId='"+userId+"'").executeUpdate();   
				
	}*/
}
