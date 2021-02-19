package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	  Standard addStandard(@RequestBody Standard standard) {
	    return service.save(standard);
	  }
	
	@GetMapping("/getAllStandard")
	public List<Standard> getAllStandard() {
		return service.listAll();
	}
}
