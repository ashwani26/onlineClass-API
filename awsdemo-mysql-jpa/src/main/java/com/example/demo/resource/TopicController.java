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
	
	@GetMapping("/getAllTopic/{topicID}")
	public List<Topic> getAllTopicByChapterID(@PathVariable  String topicID) {
		return service.getListofTopicByChpID(Long.valueOf(topicID));
	}
}
