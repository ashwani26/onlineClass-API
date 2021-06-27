package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.OptionRepository;
import com.example.demo.model.QuestionOption;
 
@Service
@Transactional
public class OptionService {
 
    @Autowired
    private OptionRepository repo;
     
    public List<QuestionOption> listAll() {
        return repo.findAll();
    }
     
    public QuestionOption save(QuestionOption QuestionOption) {
        return repo.save(QuestionOption);
    }
     
    public QuestionOption get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
