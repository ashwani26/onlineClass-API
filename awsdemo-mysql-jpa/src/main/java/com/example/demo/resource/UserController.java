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

import com.example.demo.Service.DocumentLibraryService;
import com.example.demo.Service.FileStorageService;
import com.example.demo.Service.UserService;
import com.example.demo.customException.FileStorageException;
import com.example.demo.model.DocumentLibrary;
import com.example.demo.model.User;
import com.example.demo.model.UserRoleType;
import com.example.demo.model.UserSubjectAssociation;
import com.example.demo.viewModel.UserViewModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
    private UserService service;
	@Autowired
	private FileStorageService fileStorageService;
	@Autowired
	private DocumentLibraryService docService;
	
	
	@GetMapping("/user")
	public String addUser() {
		return "user registration form";
	}
	
	@CrossOrigin
	@GetMapping("/getUserByID/{userID}")
	public User getUser(@PathVariable("userID") String userID) {
		User userObj = null;
		userObj = service.get(Long.valueOf(userID));
		return userObj;
	}
	
	@PostMapping("/user")
	ResponseEntity<String> newuser(@RequestBody User newUser) {
		// validate user already exists in the system
	   
		User user =service.findUserByUserName( newUser.getuName());
		if(user!=null) {
			return new ResponseEntity<>("User Already exists.Please try with different user Name", HttpStatus.PRECONDITION_FAILED);
			
		}else {
			service.save(newUser);
		}
		return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
		
	  }
	
	@PostMapping("/saveStudent")
	public ResponseEntity<String> saveTeacher(@RequestParam("student") String student,
			@RequestParam("file") MultipartFile file) {
		// upload file
		String fileName = null;
		User userObj = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			userObj = mapper.readValue(student, User.class);

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
				userObj.setRoleType(UserRoleType.STUDENT.ordinal());
				userObj.setFkDocumentLibraryID(docLib.getDocLibID());
				userObj.setUserImagePath(fileDownloadUri);
//				userObj.setSubjectName(subjectService.get(userObj.getFkSubjectID()).getSubName());
//				userObj.setStandardName(standardService.get(userObj.getFkStandardID()).getClassName());
//				// set document
			}
			service.save(userObj);
		} catch (Exception e) {
			return new ResponseEntity<>("Student registration failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("Student added successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		return service.listAll();
	}

	@GetMapping("/getAllTeacher")
	public List<User> getAllTeacher() {
		return service.findUserByRoleTypeli(UserRoleType.TEACHER);
	}
	
	@GetMapping("/getTeacherBySubjectID/{subjectID}")
	public List<User> getAllTeacher(@PathVariable("subjectID") String subjectID) {
		return service.getTeacherBySubjectID(UserRoleType.TEACHER.ordinal(),Long.valueOf(subjectID));
	}
	
	@GetMapping("/getAllTeacher/{stdID}")
	public List<User> getAllTeachByStandard(@PathVariable("stdID") String stdID) {
		return service.findUserByStandardID(Long.valueOf(stdID), UserRoleType.TEACHER);
	}
	
	@PostMapping("/login")
	ResponseEntity<User> login(@RequestBody User newUser) {
		User user =service.findUserByUserName( newUser.getuName());
		if(user!=null) {
			if(user.getPassword().equals(newUser.getPassword())) {
				return new ResponseEntity<>(user, HttpStatus.OK); 
			}
		}
		 return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); 
	}
	
	@PostMapping("/updateUser")
	ResponseEntity<String> updateUser(@RequestBody UserViewModel userVM) {
		User user =service.findUserByUserName(userVM.getuName());
		user.setEmail(userVM.getEmail());
		user.setMobile(userVM.getMobile());
		
		UserSubjectAssociation usa = new UserSubjectAssociation();
		usa.setUserID(userVM.getUserID());
		usa.setStandardID(userVM.getStandardID());
		usa.setSubjectID(userVM.getSubjectID());
		try {
			service.updateUserByUserName(user);
			service.saveUserSubjectAssociation(usa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("user updation failed", HttpStatus.BAD_REQUEST);
			
		}
			
		
		 return new ResponseEntity<>("User updated successfully", HttpStatus.OK); 
	}
	
	// DashBoard Info
	@GetMapping("/getTeacherCount")
	public int getTeacherCount() {
		return service.findUserByRoleTypeli(UserRoleType.TEACHER).size();
	}
	
	@GetMapping("/getStudentCount")
	public int getStudentCount() {
		return service.findUserByRoleTypeli(UserRoleType.STUDENT).size();
	}
	
	
}
