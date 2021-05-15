package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LiveClassScheduleDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long liveClassScheduleDetailsID;
	private long fkLiveClassScheduleID;
	private String description;

	public long getLiveClassScheduleDetailsID() {
		return liveClassScheduleDetailsID;
	}

	public void setLiveClassScheduleDetailsID(long liveClassScheduleDetailsID) {
		this.liveClassScheduleDetailsID = liveClassScheduleDetailsID;
	}

	public long getFkLiveClassScheduleID() {
		return fkLiveClassScheduleID;
	}

	public void setFkLiveClassScheduleID(long fkLiveClassScheduleID) {
		this.fkLiveClassScheduleID = fkLiveClassScheduleID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
