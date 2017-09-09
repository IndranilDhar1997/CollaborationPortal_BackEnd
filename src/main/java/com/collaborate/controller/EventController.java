package com.collaborate.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.collaborate.dao.EventDAO;
import com.collaborate.model.Event;
import com.google.gson.Gson;

@RestController
public class EventController {

	@Autowired EventDAO eventDAO;
	@Autowired Event event;
	
	@PostMapping("/createEvent")
	public ResponseEntity<Event> createEvent(@RequestBody Event event){
		event.setEventDate(new Date());
		eventDAO.addEvent(event);
		return new ResponseEntity<Event>(event,HttpStatus.OK);
	}
	
	
	@GetMapping("/getEvents")
	public ResponseEntity<List<Event>> eventList(){
		List<Event> getEvents=eventDAO.listEvent();
		return new ResponseEntity<List<Event>>(getEvents,HttpStatus.OK);
	}
	
	@GetMapping("/getEventById/{eventId}")
	public ResponseEntity<List<Event>> getEventById(@PathVariable("eventId")int eventId){
		
		List<Event> getEventById=(List<Event>) eventDAO.getEventByEventId(eventId);
		return new ResponseEntity<List<Event>>(getEventById,HttpStatus.OK);
	}
	
	
	@PostMapping("/uploadFile")
	public ResponseEntity<Event> uploadFile (@RequestParam("file") MultipartFile file,@RequestParam("event") String event){
		
		String fileName=null;
		if(!file.isEmpty()){
			try{
				fileName=file.getOriginalFilename();
				System.out.println("FileName:"+fileName);
				Gson gson = new Gson();
				Event ev = gson.fromJson(event,Event.class);
				ev.setImageUrl(fileName);
				ev.setEventDate(new Date());
				eventDAO.addEvent(ev);
				byte[] bytes=file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File("D:/P-II images/Events/"+fileName)));
				buffStream.write(bytes);
				buffStream.close();
				return new ResponseEntity<Event>(ev,HttpStatus.OK);
			}catch(Exception e){
				return new ResponseEntity<Event>(HttpStatus.BAD_REQUEST);
			}
		}else{
			return new ResponseEntity<Event>(HttpStatus.CONFLICT);
		}
	}
		
	}
	
	

