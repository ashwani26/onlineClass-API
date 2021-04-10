package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.ChapterRepository;
import com.example.demo.model.Chapter;


@Service
@Transactional
public class ChapterService {
	
	@Autowired
	private ChapterRepository repo1;
	
	public List<Chapter> listAll() {
        return repo1.findAll();
    }
	
	public Chapter save(Chapter chapter) {
        return repo1.save(chapter);
    }
     
    public Chapter get(long id) {
        return repo1.findById(id).get();
    }
     
    public void delete(long id) {
    	repo1.deleteById(id);
    }
    

}
