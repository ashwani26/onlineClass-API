package com.example.demo.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ChapterService;
import com.example.demo.model.Chapter;
import com.example.demo.model.Standard;
import com.example.demo.model.Subject;

@RestController
@CrossOrigin
public class ChapterController {
	
	
	@Autowired
	private ChapterService service;
	
	@GetMapping("/chapter")
	public String getChapterRegistrationForm() {
		return "Chapter registration form";
	}
	
	@PostMapping("/chapter")
	Chapter addChapter(@RequestBody Chapter chapter) {
		return service.save(chapter);
	}
	
	@GetMapping("/getAllChapter")
	public List<Chapter> getAllChapter() {
		return service.listAll();
	}
	
	
	@GetMapping("/getAllChapter/{subjectID}")
	public List<Chapter> getAllChapterBySubjectID(@PathVariable  String subjectID) {
		return service.getListofChapterBySubjectID(Long.valueOf(subjectID));
	}
	
	@GetMapping("/getChapterGrid")
	public Map<Standard, Map<Subject, List<Chapter>>> getChapterGrid() {
		Map<Standard, Map<Subject, List<Chapter>>> classMap = new HashMap<>();
		
		List<Chapter> chapterList = new ArrayList<>();
		Chapter chapter1 = new Chapter(1, "Chapter-1");
		Chapter chapter2 = new Chapter(1, "Chapter-2");
		chapterList.add(chapter1);chapterList.add(chapter2);
		
		List<Chapter> chapterList2 = new ArrayList<>();
		Chapter chapter3 = new Chapter(3, "Chapter-3");
		Chapter chapter4 = new Chapter(4, "Chapter-4");
		chapterList2.add(chapter3);chapterList2.add(chapter4);
		
		Map<Subject, List<Chapter>> subjectMap = new HashMap<>();
		
		Subject subject1 = new Subject(1, "subject-1");
		Subject subject2 = new Subject(2, "subject-2");
		subjectMap.put(subject1, chapterList);
		subjectMap.put(subject2, chapterList2);
		
		Standard standard1 = new Standard(1, "class=10th");
		classMap.put(standard1, subjectMap);
		
		/*****************************************************/
		List<Chapter> chapterList3 = new ArrayList<>();
		Chapter chapter5 = new Chapter(5, "Chapter-5");
		Chapter chapter6 = new Chapter(6, "Chapter-6");
		chapterList3.add(chapter5);chapterList3.add(chapter6);
		
		List<Chapter> chapterList4 = new ArrayList<>();
		Chapter chapter7 = new Chapter(7, "Chapter-7");
		Chapter chapter8 = new Chapter(8, "Chapter-8");
		chapterList4.add(chapter7);chapterList4.add(chapter8);
		
		Map<Subject, List<Chapter>> subjectMap2 = new HashMap<>();
		
		Subject subject3 = new Subject(3, "subject-3");
		Subject subject4 = new Subject(4, "subject-4");
		subjectMap2.put(subject3, chapterList3);
		subjectMap2.put(subject4, chapterList4);
		
		Standard standard2 = new Standard(2, "class=11th");
		classMap.put(standard2, subjectMap2);
		
		
		
		
		
		return classMap;
	}
	 
	

}
