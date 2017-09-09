package com.collaborate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.model.Blog;
import com.collaborate.model.BlogComment;

@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAO {

	@Autowired SessionFactory sessionFactory;
	
public boolean save(BlogComment blogComment){
		
		try{
			sessionFactory.getCurrentSession().save(blogComment);
		}catch(Exception e){
			e.printStackTrace();
		return false;
		}
	return true;
	}
	
	public boolean update(BlogComment blogComment){
		
		try{
			sessionFactory.getCurrentSession().update(blogComment);
		}catch(Exception e){
			e.printStackTrace();
		return false;
		}
	return true;
	}
	
	public boolean delete(int bcomId) {
		try {
			sessionFactory.getCurrentSession().delete("BlogComment.class", bcomId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
		return true;
	}
	
	public List<BlogComment> list() {
		return sessionFactory.getCurrentSession().createQuery("from BlogComment").list();
	}
	
	public BlogComment getBlogCommentByBcomId(int bcomId) {
		return (BlogComment) sessionFactory.getCurrentSession().get(BlogComment.class, bcomId);
	}
	
	public BlogComment getBcommentByBlogId(int blogId){
		return (BlogComment) sessionFactory.getCurrentSession().get("Blog.class", blogId);
	}
}
