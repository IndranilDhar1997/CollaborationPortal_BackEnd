package com.collaborate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.model.Event;

@Repository("eventDAO")
@Transactional
public class EventDAO {

	@Autowired SessionFactory sessionFactory;
	
	public boolean addEvent(Event event){
		try{
			sessionFactory.getCurrentSession().save(event);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Event> listEvent(){
		
		return sessionFactory.getCurrentSession().createQuery("from Event").list();
	}
	
	public Event getEventByEventId(int eventId) {
		return (Event) sessionFactory.getCurrentSession().get(Event.class, eventId);
	}
}
