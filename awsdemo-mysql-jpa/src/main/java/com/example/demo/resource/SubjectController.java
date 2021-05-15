package com.example.demo.resource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.StandardService;
import com.example.demo.Service.SubjectService;
import com.example.demo.model.Subject;

@RestController
@CrossOrigin
public class SubjectController {
	@Autowired
    private SubjectService service;
	@Autowired
	private StandardService standardService;
	
	
	@GetMapping("/subject")
	public String getSubjectregisterForm() {
		return "subject registration form";
	}
	
	@PostMapping("/Subject")
	  Subject addSubject(@RequestBody Subject subject) {
		subject.setStandardName(standardService.get(subject.getFkStandaradID()).getClassName());
	    return service.save(subject);
	  }
	
	@GetMapping("/getAllSubject")
	public List<Subject> getAllSubject() {
		List<Subject> listOfSubject = service.listAll();
		return listOfSubject;
	}
	
	@GetMapping("/getAllSubject/{standardID}")
	public List<Subject> getAllSubjectByUserID(@PathVariable("standardID")  String standardID) {
		 List<Subject> listOfSubject = service.getListofSubjectByStandardID(Long.valueOf(standardID));
		 
		 return listOfSubject;
	}
	
	@GetMapping("/getClassAndSubjectMap")
	public Map<String, List<Subject>> getClassAndSubjectMap() {
		List<Subject> listOfSubject = service.listAll();
		Map<String, List<Subject>> sublistGrouped =
				 listOfSubject.stream().collect(Collectors.groupingBy(w -> w.getStandardName()));
		return sublistGrouped;
	}
}
