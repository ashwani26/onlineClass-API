package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LiveClassSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long liveClassScheduleID;
	private long fkCourseID;
	private long fkSubjectID;
	private long fkUserID;
	private Date scheduleDate;
	private long fkSlotID;
	private boolean isEnded;
	private long studyDuration;
	

	public long getStudyDuration() {
		return studyDuration;
	}

	public void setStudyDuration(long studyDuration) {
		this.studyDuration = studyDuration;
	}

	public void setEnded(boolean isEnded) {
		this.isEnded = isEnded;
	}

	public boolean getIsEnded() {
		return isEnded;
	}

	public void setIsEnded(boolean isEnded) {
		this.isEnded = isEnded;
	}

	public long getLiveClassScheduleID() {
		return liveClassScheduleID;
	}

	public void setLiveClassScheduleID(long liveClassScheduleID) {
		this.liveClassScheduleID = liveClassScheduleID;
	}

	public long getFkCourseID() {
		return fkCourseID;
	}

	public void setFkCourseID(long fkCourseID) {
		this.fkCourseID = fkCourseID;
	}

	public long getFkSubjectID() {
		return fkSubjectID;
	}

	public void setFkSubjectID(long fkSubjectID) {
		this.fkSubjectID = fkSubjectID;
	}

	public long getFkUserID() {
		return fkUserID;
	}

	public void setFkUserID(long fkUserID) {
		this.fkUserID = fkUserID;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public long getFkSlotID() {
		return fkSlotID;
	}

	public void setFkSlotID(long fkSlotID) {
		this.fkSlotID = fkSlotID;
	}

}
