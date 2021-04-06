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
import com.example.demo.model.DayMaster;
import com.example.demo.model.SlotMaster;

@RestController
@CrossOrigin
public class CourseController {
	@Autowired
	private CourseService service;
	private static String UPLOADED_FOLDER = "/home/amitk/studymaterial/freelancing/lms/cdn";

	@GetMapping("/course")
	public String getCourseAddForm() {
		return "Course registration form";
	}

	//02312609302
	// degree 48 th : 48/24496
	@PostMapping("/course")
	List<Course> addCourse(@RequestBody Course course) {
		// upload image/logo
		/*
		 * try {
		 * 
		 * // Get the file and save it somewhere byte[] bytes = file.getBytes(); Path
		 * path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		 * Files.write(path, bytes); } catch (IOException e) {
		 * LoggerFactory.getLogger(CourseController.class).error(e.getMessage()); return
		 * null; }
		 * 
		 * // set logo path course.setLogoPath(UPLOADED_FOLDER +
		 * file.getOriginalFilename());
		 */
		service.save(course);

		return getAllCourse();
	}

	@GetMapping("/getAllCourse")
	public List<Course> getAllCourse() {
		return service.listAll();
	}

	@GetMapping("/getAllCourse/{courseID}")
	public Course getCourseByCourseID(@PathVariable("courseID") String courseID) {
		return service.get(Long.valueOf(courseID));
	}

	@GetMapping("/updateCourse/{courseID}")
	public List<Course> updateCourseByCourseID(@RequestBody Course course) {
		try {
			service.update(course);
		} catch (Exception e) {
			return null;
		}
		return getAllCourse();
	}
	
	@GetMapping("/getAllDayMaster")
	public DayMaster[] getAllDayMaster() {
		return DayMaster.values();
	}
	
	@GetMapping("/getAllSlotMaster")
	public SlotMaster[] getAllSlotMaster() {
		return SlotMaster.values();
	}

}
