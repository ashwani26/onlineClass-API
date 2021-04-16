package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.SlotMasterService;
import com.example.demo.model.SlotMaster;

@RestController
@CrossOrigin
public class SlotMasterController {
	@Autowired
    private SlotMasterService service;
	
	
	@GetMapping("/sm")
	public String getSlotMasterregisterForm() {
		return "slot master registration form";
	}
	
	@PostMapping("/SlotMaster")
	  SlotMaster addSlotMaster(@RequestBody SlotMaster SlotMaster) {
	    return service.save(SlotMaster);
	  }
	
	@GetMapping("/getAllSlotMaster")
	public List<SlotMaster> getAllSlotMaster() {
		return service.listAll();
	}
	
	
	
}
