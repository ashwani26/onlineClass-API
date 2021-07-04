package com.example.demo.model;

import java.util.Date;

public class StudentReportViewModel {
	private Date attemptDate;
	private String testName;
	private int totalMarks;
	private int marksObtain;
	private String comment;
	
	public Date getAttemptDate() {
		return attemptDate;
	}
	public void setAttemptDate(Date attemptDate) {
		this.attemptDate = attemptDate;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getMarksObtain() {
		return marksObtain;
	}
	public void setMarksObtain(int marksObtain) {
		this.marksObtain = marksObtain;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	
}
