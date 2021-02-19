package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CourseService;
import com.example.demo.model.Course;

@RestController
@CrossOrigin
public class TeacherController {
	@Autowired
    private CourseService service;
	
	
	@GetMapping("/upload")
	public String formToUploadCourse() {
		return "course uploading form";
	}
	
	@PostMapping("/upload")
	Course adduploadeMaterial(@RequestBody Course course) {
	    return service.save(course);
	  }
}
