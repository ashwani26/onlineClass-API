package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.SubjectRepository;
import com.example.demo.model.Subject;
 
@Service
@Transactional
public class SubjectService {
 
    @Autowired
    private SubjectRepository repo;
     
    public List<Subject> listAll() {
        return repo.findAll();
    }
     
    public Subject save(Subject Subject) {
        return repo.save(Subject);
    }
     
    public Subject get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    
	/*
	 * public boolean saveSubjectUserAssociation(UserSubjectAssociation
	 * userSubjectAssociation) {
	 * 
	 * }
	 */
    
    public List<Subject> getListofSubjectByStandardID(long fkstandardID){
    	return repo.getListofSubjectByStandardID(fkstandardID);
    }
    
    
    
  
}
