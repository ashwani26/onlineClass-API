package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.LiveClassScheduleDetailsService;
import com.example.demo.Service.LiveClassScheduleService;
import com.example.demo.model.LiveClassSchedule;
import com.example.demo.model.LiveClassScheduleDetails;
import com.example.demo.model.LiveClassScheduleViewModel;
import com.example.demo.model.User;

@RestController
@CrossOrigin
public class LiveClassScheduleController {

	@Autowired
	private LiveClassScheduleService service;

	@Autowired
	private LiveClassScheduleDetailsService detailService;

	@PostMapping(value = "/saveSchedule")
	public ResponseEntity<String> saveLiveClassSchedule(@RequestBody LiveClassSchedule liveClassSchedule) {
		service.save(liveClassSchedule);
		return new ResponseEntity<>("Schedule added successfully", HttpStatus.OK);
	}

	@GetMapping("/getAllSchedule/{teacherID}")
	public List<LiveClassScheduleViewModel> getAllUser(@PathVariable("teacherID") String teacherID) {
		return service.getLiveClasScheduleViewModelList(Long.valueOf(teacherID));
	}
	
	@GetMapping("/getAllScheduleForStudent/{studentID}")
	public List<LiveClassScheduleViewModel> getAllScheduleForStudent(@PathVariable("studentID") String studentID) {
		return service.getListOfScheduleByStudentID(Long.valueOf(studentID));
	}

	@PostMapping(value = "/saveScheduleDetails")
	public ResponseEntity<String> saveLiveClassScheduleDetails(
			@RequestBody LiveClassScheduleDetails liveClassScheduleDetails) {
		detailService.save(liveClassScheduleDetails);
		if (liveClassScheduleDetails.getLiveClassScheduleDetailsID() > 0) {
			// update is ended flag
			LiveClassSchedule lcsObj = service.get(liveClassScheduleDetails.getFkLiveClassScheduleID());
			lcsObj.setIsEnded(true);
			// set study duration in second. currently slot size is taken of 1 hour by default
			lcsObj.setStudyDuration(60 * 60);
			service.save(lcsObj);
		}
		return new ResponseEntity<>("Schedule details added successfully", HttpStatus.OK);
	}

}
