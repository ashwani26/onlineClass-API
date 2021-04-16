package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.SlotMasterRepository;
import com.example.demo.Repository.StudyMaterialRepository;
import com.example.demo.model.SlotMaster;



@Service
@Transactional
public class SlotMasterService {
	
	@Autowired
	private SlotMasterRepository repo1;
	
	public List<SlotMaster> listAll() {
        return repo1.findAll();
    }
	
	public SlotMaster save(SlotMaster SlotMaster) {
        return repo1.save(SlotMaster);
    }
     
    public SlotMaster get(long id) {
        return repo1.findById(id).get();
    }
     
    public void delete(long id) {
    	repo1.deleteById(id);
    }
    
  
    

}
