package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.PaperRepository;
import com.example.demo.model.Paper;
import com.example.demo.model.Question;
import com.example.demo.model.QuestionOptionViewModel;
 
@Service
@Transactional
public class PaperService {
 
    @Autowired
    private PaperRepository repo;
     
    public List<Paper> listAll() {
        return repo.findAll();
    }
     
    public Paper save(Paper Paper) {
        return repo.save(Paper);
    }
     
    public Paper get(long id) {
        return repo.findById(id).get();
    }
    
    public List<QuestionOptionViewModel> getListOfQuestionByPaperID(long fkPaperID) {
        return repo.getListOfQuestionByPaperID(fkPaperID);
    }
    
    
    
    public List<Question> getQuestionByPaperID(long id) {
        return repo.getQuestions(id);
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    

}
