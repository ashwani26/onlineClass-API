package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CourseStudentAssociationService;
import com.example.demo.model.CourseStudentAssociation;

@RestController
@CrossOrigin
public class CourseStudentAssociationController {
	@Autowired
	private CourseStudentAssociationService service;

	/*
	 * @GetMapping("/CourseStudentAssociation") public String getCourseAddForm() { return
	 * "Standard registration form"; }
	 */

	@PostMapping("/addCourseStudent")
	CourseStudentAssociation addCourse(@RequestBody CourseStudentAssociation CourseStudentAssociation) {
		return service.save(CourseStudentAssociation);
	}

	
}
