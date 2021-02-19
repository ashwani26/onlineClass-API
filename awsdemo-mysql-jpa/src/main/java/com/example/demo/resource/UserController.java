package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.model.User;
import com.example.demo.model.UserRoleType;
import com.example.demo.model.UserStandardAssociation;

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
	  User newuser(@RequestBody User newUser) {
	    return service.save(newUser);
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
}
