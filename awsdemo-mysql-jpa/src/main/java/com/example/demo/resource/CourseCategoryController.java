package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CourseCategoryService;
import com.example.demo.model.CourseCategory;

@RestController
@CrossOrigin
public class CourseCategoryController {
	@Autowired
	private CourseCategoryService service;

	@GetMapping("/courseCategory")
	public String getCourseAddForm() {
		return "Standard registration form";
	}

	@PostMapping("/courseCategory")
	CourseCategory addCourse(@RequestBody CourseCategory coursecategory) {
		return service.save(coursecategory);
	}

	@GetMapping("/getAllCourseCategory")
	List<CourseCategory> addCourse() {
		return service.listAll();
	}
}
