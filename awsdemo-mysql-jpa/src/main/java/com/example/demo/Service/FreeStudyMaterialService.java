package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.FreeStudyMaterialRepository;
import com.example.demo.model.FreeStudyMateral;



@Service
@Transactional
public class FreeStudyMaterialService {
	
	@Autowired
	private FreeStudyMaterialRepository repo1;
	
	public List<FreeStudyMateral> listAll() {
        return repo1.findAll();
    }
	
	public FreeStudyMateral save(FreeStudyMateral FreeStudyMateral) {
        return repo1.save(FreeStudyMateral);
    }
     
    public FreeStudyMateral get(long id) {
        return repo1.findById(id).get();
    }
     
    public void delete(long id) {
    	repo1.deleteById(id);
    }
    
  
    

}
