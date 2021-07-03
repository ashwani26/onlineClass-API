package com.example.demo.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.Service.StandardService;
import com.example.demo.Service.SubjectService;
import com.example.demo.Service.UserService;
import com.example.demo.customException.FileStorageException;
import com.example.demo.model.Course;
import com.example.demo.model.DayMaster;
import com.example.demo.model.DocumentLibrary;
import com.example.demo.model.User;
import com.example.demo.model.UserRoleType;
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
	@Autowired
	private StandardService standardService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private UserService teacherService;

	private static String UPLOADED_FOLDER = "/home/amitk/studymaterial/freelancing/lms/cdn";

	@GetMapping("/course")
	public String getCourseAddForm() {
		return "Course registration form";
	}

	@PostMapping("/course")
	public ResponseEntity<String> addCourse(@RequestParam("course") String course,
			@RequestParam("file") MultipartFile file) {
		// upload file
		String fileName = null;
		Course courseObj = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			courseObj = mapper.readValue(course, Course.class);

			fileName = fileStorageService.storeFile(file);
		} catch (FileStorageException e) {
			return new ResponseEntity<>("Course registration failed-FileStorageException",
					HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (JsonMappingException e) {
			return new ResponseEntity<>("Course registration failed-JsonMappingException",
					HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (JsonProcessingException e) {
			return new ResponseEntity<>("Course registration failed-JsonProcessingException",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
					.path(fileName).toUriString();
			UUID uuid = UUID.randomUUID();
			DocumentLibrary docLib = new DocumentLibrary(uuid.toString(), fileName, fileDownloadUri,
					file.getContentType(), file.getSize());
			docLib = docService.save(docLib);
			if (docLib != null) {
				courseObj.setFkDocumentLibID(docLib.getDocLibID());
				courseObj.setLogoPath(fileDownloadUri);
				courseObj.setSubjectName(subjectService.get(courseObj.getFkSubjectID()).getSubName());
				courseObj.setStandardName(standardService.get(courseObj.getFkStandardID()).getClassName());
				// set document
			}
			service.save(courseObj);
		} catch (Exception e) {
			return new ResponseEntity<>("Course registration failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("Course added successfully", HttpStatus.OK);
	}

	@GetMapping("/getAllCourse")
	public List<Course> getAllCourse() {
		return service.listAll();
	}

	@GetMapping("/getAllCourse/{courseID}")
	public Course getCourseByCourseID(@PathVariable("courseID") String courseID) {
		Course courseObj = service.get(Long.valueOf(courseID));
		return courseObj;
	}
	
	@GetMapping("/getCourseDetail/{courseID}")
	public Course getCourseDetailByCourseID(@PathVariable("courseID") String courseID) {
		Course courseObj = service.get(Long.valueOf(courseID));
		return courseObj;
	}

	@PostMapping("/updateCourse")
	public ResponseEntity<String> updateCourse(@RequestParam("course") String course,
			@RequestParam("file") MultipartFile file) {
		// upload file
		String fileName = null;
		Course courseObj = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			courseObj = mapper.readValue(course, Course.class);
			if(!fileStorageService.deletePrevFile(file)) {
				throw new FileStorageException("FIle deletion failed");
			}
			fileName = fileStorageService.storeFile(file);
		} catch (FileStorageException e) {
			return new ResponseEntity<>("Course registration failed-FileStorageException",
					HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (JsonMappingException e) {
			return new ResponseEntity<>("Course registration failed-JsonMappingException",
					HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (JsonProcessingException e) {
			return new ResponseEntity<>("Course registration failed-JsonProcessingException",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
					.path(fileName).toUriString();
			UUID uuid = UUID.randomUUID();
			DocumentLibrary docLib = new DocumentLibrary(uuid.toString(), fileName, fileDownloadUri,
					file.getContentType(), file.getSize());
			docLib = docService.save(docLib);
			if (docLib != null) {
				courseObj.setFkDocumentLibID(docLib.getDocLibID());
				courseObj.setLogoPath(fileDownloadUri);
				courseObj.setSubjectName(subjectService.get(courseObj.getFkSubjectID()).getSubName());
				courseObj.setStandardName(standardService.get(courseObj.getFkStandardID()).getClassName());
				// set document
			}
			service.update(courseObj);
		} catch (Exception e) {
			return new ResponseEntity<>("Course updation failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("Course updated successfully", HttpStatus.OK);
	}

	@GetMapping("/getAllDayMaster")
	public DayMaster[] getAllDayMaster() {
		return DayMaster.values();
	}

	@GetMapping("/deleteCourse/{courseID}")
	public ResponseEntity<String> deleteCourseByCourseID(@PathVariable("courseID") String courseID) {
		service.delete(Long.valueOf(courseID));
		return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
	}

	@PostMapping("/saveTeacher")
	public ResponseEntity<String> saveTeacher(@RequestParam("teacher") String teacher,
			@RequestParam("file") MultipartFile file) {
		// upload file
		String fileName = null;
		User userObj = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			userObj = mapper.readValue(teacher, User.class);

			fileName = fileStorageService.storeFile(file);
		} catch (FileStorageException e) {
			return new ResponseEntity<>("Teacher registration failed-FileStorageException",
					HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (JsonMappingException e) {
			return new ResponseEntity<>("Teacher registration failed-JsonMappingException",
					HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (JsonProcessingException e) {
			return new ResponseEntity<>("Teacher registration failed-JsonProcessingException",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
					.path(fileName).toUriString();
			UUID uuid = UUID.randomUUID();
			DocumentLibrary docLib = new DocumentLibrary(uuid.toString(), fileName, fileDownloadUri,
					file.getContentType(), file.getSize());
			docLib = docService.save(docLib);
			if (docLib != null) {
				// set role type teacher
				userObj.setRoleType(UserRoleType.TEACHER.ordinal());
				userObj.setFkDocumentLibraryID(docLib.getDocLibID());
				userObj.setUserImagePath(fileDownloadUri);
				userObj.setSubjectName(subjectService.get(userObj.getFkSubjectID()).getSubName());
				userObj.setStandardName(standardService.get(userObj.getFkStandardID()).getClassName());
				// set document
			}
			teacherService.save(userObj);
		} catch (Exception e) {
			return new ResponseEntity<>("Teacher registration failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("Teacher added successfully", HttpStatus.OK);
	}

	@PostMapping("/updateUserProfile")
	public ResponseEntity<String> updateUserProfile(@RequestParam("user") String user,
			@RequestParam("file") MultipartFile file) {
		// upload file
		String fileName = null;
		User userObj = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			userObj = mapper.readValue(user, User.class);

			fileName = fileStorageService.storeFile(file);
		} catch (FileStorageException e) {
			return new ResponseEntity<>("Teacher registration failed-FileStorageException",
					HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (JsonMappingException e) {
			return new ResponseEntity<>("Teacher registration failed-JsonMappingException",
					HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (JsonProcessingException e) {
			return new ResponseEntity<>("Teacher registration failed-JsonProcessingException",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
					.path(fileName).toUriString();
			UUID uuid = UUID.randomUUID();
			DocumentLibrary docLib = new DocumentLibrary(uuid.toString(), fileName, fileDownloadUri,
					file.getContentType(), file.getSize());
			docLib = docService.save(docLib);
			User userDbObj = null;
			if (docLib != null) {
				
				 userDbObj = teacherService.get(userObj.getUserID()) ;
				userDbObj.setFkDocumentLibraryID(docLib.getDocLibID());
				userDbObj.setUserImagePath(fileDownloadUri);
				userDbObj.setMobile(userObj.getMobile());
				userDbObj.setEmail(userObj.getEmail());
				// set document
			}
			teacherService.updateUserByUserName(userDbObj);  
		} catch (Exception e) {
			return new ResponseEntity<>("User Profile update failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("User Profile added successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getCourseCount")
	public int getCourseCount() {
		return service.listAll().size();
	}
	
	@GetMapping("/getCourseToBuy/{studentID}")
	public List<Course> getNonRegisteredCourseForStudent(@PathVariable("studentID") String studentID) {
		return service.getAllCourseNotRegisteredbyStudent(Long.valueOf(studentID));
	}
	
	@GetMapping("/getAllreadyRegisteredCourse/{studentID}")
	public List<Course> getAllCourseregisteredByStudent(@PathVariable("studentID") String studentID) {
		return service.getAllRegisteredCoursebyStudent(Long.valueOf(studentID));
	}

	@GetMapping("/getAllCourseToBuy/{studentID}")
	public List<Course> getAllCourseNotRegisteredbyStudent(@PathVariable("studentID") String studentID) {
		return service.getAllCourseNotRegisteredbyStudent(Long.valueOf(studentID));
	}
	
//	@GetMapping("/getAllCourse/{standardID}")
//	public List<Course> getAllCourseByStandardId(@PathVariable("standardID") String standardID) {
//		return service.getAllCourseByStandardID(Long.valueOf(standardID));
//	}
}
