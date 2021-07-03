package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.TopicService;
import com.example.demo.model.Chapter;
import com.example.demo.model.Topic;


@RestController
@CrossOrigin
public class TopicController {
	
	@Autowired
	private TopicService service;
	
	@GetMapping("/topic")
	public String getTopicRegistrationForm() {
		return "Topic registration form";
	}
	
	@PostMapping("/topic")
	Topic addChapter(@RequestBody Topic topic) {
		return service.save(topic);
	}
	
	@GetMapping("/getAllTopic")
	public List<Topic> getAllTopic() {
		return service.listAll();
	}
	
	@GetMapping("/getAllTopic/{chapterID}")
	public List<Topic> getAllTopicByChapterID(@PathVariable  String chapterID) {
		return service.getListofTopicByChpID(Long.valueOf(chapterID));
	}
	
	@GetMapping("/getAllTopicForFSM/{chapterID}")
	public List<Topic> getAllTopicByChapterIDForFreeStudyMaterial(@PathVariable  String chapterID) {
		return service.getListofTopicFreeStudyMaterialVailable(Long.valueOf(chapterID));
	}
	
	@GetMapping("/getAllTopicForPremium/{chapterID}")
	public List<Topic> getAllTopicByChapterIDForPremium(@PathVariable  String chapterID) {
		return service.getListofTopicPremiumStudyMaterialVailable(Long.valueOf(chapterID));
	}
}
