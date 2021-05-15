package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SlotMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long slotID;
	private String slotName;
	private long slotDuration;
	
	
	public long getSlotDuration() {
		return slotDuration;
	}

	public void setSlotDuration(long slotDuration) {
		this.slotDuration = slotDuration;
	}

	public long getSlotID() {
		return slotID;
	}

	public void setSlotID(long slotID) {
		this.slotID = slotID;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

}
