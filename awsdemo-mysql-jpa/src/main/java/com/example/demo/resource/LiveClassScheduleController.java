package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.LiveClassScheduleService;
import com.example.demo.model.LiveClassSchedule;

@RestController
@CrossOrigin
public class LiveClassScheduleController {
	
	@Autowired
	private LiveClassScheduleService service;
	
	
	@RequestMapping(value="/save",method = RequestMethod.POST)    
    public String saveLiveClassSchedule(@ModelAttribute("liveClassSchedule") LiveClassSchedule liveClassSchedule){    
		service.save(liveClassSchedule);    
        return "redirect:/";
    }   
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsaveLiveClassSchedule(@ModelAttribute("liveClassSchedule") LiveClassSchedule liveClassSchedule){    
		//service.update(liveClassSchedule);    
        return "redirect:/";    
    }   
}
