package com.collaborate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.model.BlogComment;
import com.collaborate.model.ForumComment;

@Repository("forumCommentDAO")
@Transactional
public class ForumCommentDAO {

	@Autowired SessionFactory sessionFactory;
	
public boolean save(ForumComment forumComment){
		
		try{
			sessionFactory.getCurrentSession().save(forumComment);
		}catch(Exception e){
			e.printStackTrace();
		return false;
		}
	return true;
	}
	
	public boolean update(ForumComment forumComment){
		
		try{
			sessionFactory.getCurrentSession().update(forumComment);
		}catch(Exception e){
			e.printStackTrace();
		return false;
		}
	return true;
	}
	
	public boolean delete(int fcomId) {
		try {
			sessionFactory.getCurrentSession().delete("ForumComment.class", fcomId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
		return true;
	}
	
	public List<ForumComment> list() {
		return sessionFactory.getCurrentSession().createQuery("from ForumComment").list();
	}
	
	public ForumComment getForumCommentByForumCommentId(int fcomId) {
		return (ForumComment) sessionFactory.getCurrentSession().get(ForumComment.class, fcomId);
	}

	public ForumComment getFcommentByForumId(int forumId){
		return (ForumComment) sessionFactory.getCurrentSession().get("Forum.class", forumId);
	}
}
