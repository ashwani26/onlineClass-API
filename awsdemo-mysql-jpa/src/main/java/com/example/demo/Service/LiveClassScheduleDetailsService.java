package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.LiveClassScheduleDetailsRepository;
import com.example.demo.model.LiveClassScheduleDetails;


@Service
@Transactional
public class LiveClassScheduleDetailsService {
	
	@Autowired
	private LiveClassScheduleDetailsRepository  repo1;
	
	public List<LiveClassScheduleDetails> listAll() {
        return repo1.findAll();
    }
	
	public LiveClassScheduleDetails save(LiveClassScheduleDetails LiveClassScheduleDetails) {
        return repo1.save(LiveClassScheduleDetails);
    }
     
    public LiveClassScheduleDetails get(long id) {
        return repo1.findById(id).get();
    }
     
    public void delete(long id) {
    	repo1.deleteById(id);
    }
  

}
