package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.model.User;
import com.example.demo.model.UserRoleType;
import com.example.demo.model.UserSubjectAssociation;
import com.example.demo.viewModel.UserViewModel;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
    private UserService service;
	
	
	@GetMapping("/user")
	public String addUser() {
		return "user registration form";
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
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		return service.listAll();
	}

	@GetMapping("/getAllTeacher")
	public List<User> getAllTeacher() {
		return service.findUserByRoleTypeli(UserRoleType.TEACHER);
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
}
