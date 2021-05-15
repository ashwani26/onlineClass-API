package com.example.demo.model;

import java.util.Date;

public class LiveClassScheduleViewModel {
	private String courseName;
	private String subject;
	private Date date;
	private String slot;
	private long scheduleID;
	private boolean isEnded;
	private long studyDuration;

	
	public long getStudyDuration() {
		return studyDuration;
	}

	public void setStudyDuration(long studyDuration) {
		this.studyDuration = studyDuration;
	}

	public boolean getIsEnded() {
		return isEnded;
	}

	public void setIsEnded(boolean isEnded) {
		this.isEnded = isEnded;
	}

	public long getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(long scheduleID) {
		this.scheduleID = scheduleID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getDate() {
		return date;
	}


	public LiveClassScheduleViewModel(String courseName, String subject, Date date, String slot, long scheduleID,
			boolean isEnded, long studyDuration) {
		super();
		this.courseName = courseName;
		this.subject = subject;
		this.date = date;
		this.slot = slot;
		this.scheduleID = scheduleID;
		this.isEnded = isEnded;
		this.studyDuration = studyDuration;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

}
