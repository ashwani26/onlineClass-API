package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.LiveClassScheduleRepository;
import com.example.demo.model.LiveClassSchedule;
import com.example.demo.model.LiveClassScheduleViewModel;

@Service
@Transactional
public class LiveClassScheduleService {
	
	@Autowired
	private LiveClassScheduleRepository repo;
	
	public List<LiveClassSchedule> listAll() {
        return repo.findAll();
    }
	
	public LiveClassSchedule get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
    	repo.deleteById(id);
    }
    
	public LiveClassSchedule save(LiveClassSchedule liveClassSchedule) {
        return repo.save(liveClassSchedule);
    }
	
	
	public List<LiveClassScheduleViewModel> getLiveClasScheduleViewModelList(long teacherID){
		return repo.getListOfScheudleByTeacherID(teacherID);
	}
	
	public List<LiveClassScheduleViewModel> getListOfScheduleByStudentID(long studentID){
		return repo.getListOfScheduleByStudentID(studentID);
	}

}
