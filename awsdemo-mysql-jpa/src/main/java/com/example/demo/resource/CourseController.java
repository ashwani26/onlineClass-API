package com.example.demo.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Service.CourseService;
import com.example.demo.Service.DocumentLibraryService;
import com.example.demo.Service.FileStorageService;
import com.example.demo.customException.FileStorageException;
import com.example.demo.model.Course;
import com.example.demo.model.DayMaster;
import com.example.demo.model.DocumentLibrary;
import com.example.demo.model.SlotMaster;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
public class CourseController {
	 @Autowired
	    private FileStorageService fileStorageService;
		 @Autowired 
		 private DocumentLibraryService docService;
		 @Autowired
			private CourseService service;
	private static String UPLOADED_FOLDER = "/home/amitk/studymaterial/freelancing/lms/cdn";

	@GetMapping("/course")
	public String getCourseAddForm() {
		return "Course registration form";
	}

	@PostMapping("/course")
	public void addCourse(@RequestParam("course")  String course,@RequestParam("file") MultipartFile file) {
	// upload file
		String fileName = null;
		Course courseObj = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			 courseObj = mapper.readValue(course, Course.class);
			
			fileName = fileStorageService.storeFile(file);
		} catch (FileStorageException e) {
			// TODO Auto-generated catch block
			return ;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
			        .path("/downloadFile/")
			        .path(fileName)
			        .toUriString();
			UUID uuid = UUID.randomUUID();
			

			DocumentLibrary docLib =  new DocumentLibrary(uuid.toString(),fileName, fileDownloadUri, file.getContentType(), file.getSize());
			docLib =  docService.save(docLib);
			if(docLib!=null)
				courseObj.setFkDocumentLibID(docLib.getDocLibID());
			service.save(courseObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ;
		}

		return ;
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
