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

import com.example.demo.Service.StandardService;
import com.example.demo.model.Standard;

@RestController
@CrossOrigin
public class StandardController {
	@Autowired
    private StandardService service;
	
	
	@GetMapping("/standard")
	public String getStandardregisterForm() {
		return "Standard registration form";
	}
	
	@PostMapping("/standard")
	ResponseEntity<String> addStandard(@RequestBody Standard standard) {
	     service.save(standard);
		return new ResponseEntity<String>("Standard added successfully", HttpStatus.OK);
	  }
	
	@GetMapping("/getAllStandard")
	public List<Standard> getAllStandard() {
		return service.listAll();
	}
	
	@GetMapping("/getStandard/{standardID}")
	public Standard getStandardByStanardID(@PathVariable  String standardID) {
		return service.get(Long.valueOf(standardID));
	}
}
