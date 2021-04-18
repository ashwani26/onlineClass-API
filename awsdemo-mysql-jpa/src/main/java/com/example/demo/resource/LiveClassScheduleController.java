package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.LiveClassScheduleService;
import com.example.demo.model.LiveClassSchedule;

@RestController
@CrossOrigin
public class LiveClassScheduleController {
	
	@Autowired
	private LiveClassScheduleService service;
	
	
	@PostMapping(value="/saveSchedule")    
    public ResponseEntity<String> saveLiveClassSchedule(@RequestBody LiveClassSchedule liveClassSchedule){    
			service.save(liveClassSchedule);    
		 return new ResponseEntity<>("Schedule added successfully", HttpStatus.OK);
    }   
	
	  
}
