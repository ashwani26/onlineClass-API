package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.CandidateAnswerRepository;
import com.example.demo.Repository.CandidateExamRepository;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.model.CandidateAnswer;
import com.example.demo.model.CandidateExam;
import com.example.demo.model.Question;
 
@Service
@Transactional
public class QuestionService {
 
    @Autowired
    private QuestionRepository repo;
    
    @Autowired
    private CandidateAnswerRepository candAnswerRepo;
    
    
    @Autowired
    private CandidateExamRepository candExamRepo;
     
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
    
    public List<CandidateAnswer> saveAllAnswer(List<CandidateAnswer> answers) {
        return candAnswerRepo.saveAll(answers);
    }
    
    public CandidateExam saveCandidateExam(CandidateExam candidateExam) {
        return candExamRepo.save(candidateExam);
    }
    
    public boolean isExamAlreadyAttempted(long fkPaperID,long fkUserID) {
        return candExamRepo.getCandidateExamByUserAndPaperID(fkPaperID,fkUserID).size()>0 ? true : false;
    }
    
    public List<CandidateExam> getStudentReport(long fkUserID) {
        return candExamRepo.getStudentReport(fkUserID);
    }
}
