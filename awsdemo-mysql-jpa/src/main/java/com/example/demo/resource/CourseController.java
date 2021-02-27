package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CourseService;
import com.example.demo.model.Course;

@RestController
@CrossOrigin
public class CourseController {
	@Autowired
    private CourseService service;

	
	
	@GetMapping("/course")
	public String getCourseAddForm() {
		return "Course registration form";
	}
	
	@PostMapping("/course")
	  Course addCourse(@RequestBody Course course) {
	    return service.save(course);
	  }
	
	@GetMapping("/getAllCourse")
	public List<Course> getAllCourse() {
		return service.listAll();
	}
	
	@GetMapping("/getAllCourse/{courseID}")
	public Course getCourseByCourseID(@PathVariable("courseID") String courseID) {
		return service.get(Long.valueOf(courseID));
	}
	
	
}
