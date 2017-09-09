package com.collaborate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.collaborate.model.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDAO {

	@Autowired SessionFactory sessionFactory;
	
public boolean save(Forum forum){
		
		try{
			sessionFactory.getCurrentSession().save(forum);
		}catch(Exception e){
			e.printStackTrace();
		return false;
		}
	return true;
	}
	
	public boolean update(Forum forum){
		
		try{
			sessionFactory.getCurrentSession().update(forum);
		}catch(Exception e){
			e.printStackTrace();
		return false;
		}
	return true;
	}
	
	public boolean delete(Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
		return true;
	}
	
	public List<Forum> list() {
		return sessionFactory.getCurrentSession().createQuery("from Forum").list();
	}
	
	public Forum getForumByForumId(int forumId) {
		return (Forum) sessionFactory.getCurrentSession().get(Forum.class, forumId);
	}
}
