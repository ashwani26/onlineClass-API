package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.SubjectService;
import com.example.demo.model.Subject;

@RestController
@CrossOrigin
public class SubjectController {
	@Autowired
    private SubjectService service;
	
	
	@GetMapping("/subject")
	public String getSubjectregisterForm() {
		return "subject registration form";
	}
	
	@PostMapping("/Subject")
	  Subject addSubject(@RequestBody Subject subject) {
	    return service.save(subject);
	  }
	
	@GetMapping("/getAllSubject")
	public List<Subject> getAllSubject() {
		return service.listAll();
	}
	
	@GetMapping("/getAllSubject/{standardID}")
	public List<Subject> getAllSubjectByUserID(@PathVariable  String standardID) {
		return service.getListofSubjectByUserID(Long.valueOf(standardID));
	}
}
