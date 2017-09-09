package com.collaborate.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.collaborate.model.Blog;
import com.collaborate.model.Forum;
import com.collaborate.model.JobApplication;
import com.collaborate.model.UserDetails;

@Repository("blogDAO")
@Transactional
public class BlogDAO {

	@Autowired SessionFactory sessionFactory;
	
public boolean save(Blog blog){
		
		try{
			sessionFactory.getCurrentSession().save(blog);
		}catch(Exception e){
			e.printStackTrace();
		return false;
		}
	return true;
	}


/*public List<Blog> getBlogByBlogId(int blogId){
	return sessionFactory.getCurrentSession().createQuery("from Blog where blogId='"+blogId+"'").list();
	
}*/



	
	public boolean update(Blog blog){
		
		try{
			sessionFactory.getCurrentSession().update(blog);
		}catch(Exception e){
			e.printStackTrace();
		return false;
		}
	return true;
	}
	
	public boolean delete(Blog blog) {
		
		try {
			
			sessionFactory.getCurrentSession().delete(blog);
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
		return true;
	}
	
	public List<Blog> list() {
		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
	}
	public Blog getBlogByUserid(int userId){
		return (Blog) sessionFactory.getCurrentSession().get("UserDetails.class", userId);
	}
}
