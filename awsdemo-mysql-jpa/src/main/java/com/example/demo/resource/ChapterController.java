package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ChapterService;
import com.example.demo.model.Chapter;

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
	
	/*
	 * @GetMapping("/getAllChapter/{userID}") public List<Chapter>
	 * getAllChapterByUserID(@PathVariable String userID) { return
	 * service.getListofChapterByUserID(Long.valueOf(userID)); }
	 */

}
