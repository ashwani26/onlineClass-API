package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.TopicRepository;
import com.example.demo.model.Chapter;
import com.example.demo.model.Topic;


@Service
@Transactional
public class TopicService {
	
	@Autowired
	private TopicRepository repo;
	
	public List<Topic> listAll() {
        return repo.findAll();
    }
	
	public Topic save(Topic topic) {
        return repo.save(topic);
    }
     
    public Topic get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
    	repo.deleteById(id);
    }
    
    public List<Topic> getListofTopicByChpID(long ChpID){
    	return repo.getListofTopicByChapterID(ChpID);
    }
    
    public List<Topic> getListofTopicFreeStudyMaterialVailable(long ChpID){
    	return repo.getListofTopicFreeStudyMaterialVailable(ChpID);
    }
    
    public List<Topic> getListofTopicPremiumStudyMaterialVailable(long ChpID){
    	return repo.getListofTopicPremiumStudyMaterialVailable(ChpID);
    }
    
    

}
