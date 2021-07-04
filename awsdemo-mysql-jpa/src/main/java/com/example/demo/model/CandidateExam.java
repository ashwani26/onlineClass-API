package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CandidateExam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long candidateExamID;
	private long fkUserID;
	private long fkPaperID;
	private boolean isExamCompleted;
	private int marksObtained;
	private Date attemptDate;
	private String testName;
	private int totalMarks;
	
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
	public Date getAttemptDate() {
		return attemptDate;
	}
	public void setAttemptDate(Date attemptDate) {
		this.attemptDate = attemptDate;
	}
	public long getCandidateExamID() {
		return candidateExamID;
	}
	public void setCandidateExamID(long candidateExamID) {
		this.candidateExamID = candidateExamID;
	}
	public long getFkUserID() {
		return fkUserID;
	}
	public void setFkUserID(long fkUserID) {
		this.fkUserID = fkUserID;
	}
	public long getFkPaperID() {
		return fkPaperID;
	}
	public void setFkPaperID(long fkPaperID) {
		this.fkPaperID = fkPaperID;
	}
	public boolean getIsExamCompleted() {
		return isExamCompleted;
	}
	public void setISExamCompleted(boolean isExamCompleted) {
		this.isExamCompleted = isExamCompleted;
	}
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	
	
	
}
