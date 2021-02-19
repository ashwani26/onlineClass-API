package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CourseService;
import com.example.demo.model.Course;
import com.example.demo.model.StudyMaterial;

@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	private CourseService service;

	@GetMapping("/listCourse")
	public List<Course> getAllCourseList() {
		return service.listAll();
	}

	@GetMapping("/listCourse/{courseID}")
	public List<StudyMaterial> getStudyMaterialListByCourseID(@PathVariable String courseID) {
		return service.listAllStudymaterialByCourseID(Long.valueOf(courseID));
	}

}
