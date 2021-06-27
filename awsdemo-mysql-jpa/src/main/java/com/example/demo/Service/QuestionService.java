package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.QuestionRepository;
import com.example.demo.model.Question;
 
@Service
@Transactional
public class QuestionService {
 
    @Autowired
    private QuestionRepository repo;
     
    public List<Question> listAll() {
        return repo.findAll();
    }
     
    public Question save(Question Question) {
        return repo.save(Question);
    }
     
    public Question get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
