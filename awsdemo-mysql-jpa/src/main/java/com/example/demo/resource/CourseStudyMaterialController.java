package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CourseStudyMaterialService;
import com.example.demo.model.CourseStudyMaterial;

@RestController
@CrossOrigin
public class CourseStudyMaterialController {
	@Autowired
	private CourseStudyMaterialService service;

	@GetMapping("/csm")
	public String getCourseStudyMaterialAddForm() {
		return "Course Study Material Assoction ";
	}

	@PostMapping("/csm")
	CourseStudyMaterial addCourseStudyMaterial(@RequestBody CourseStudyMaterial CourseStudyMaterial) {
		return service.save(CourseStudyMaterial);
	}
}
