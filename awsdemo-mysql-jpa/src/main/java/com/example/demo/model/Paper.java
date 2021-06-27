package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Paper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paperID;
	private String paperName;
	private long fkSubjectID;
	private long fkCourseID;
	private long fkStandardID;
	private Date scheduledDate;
	private int totalQuestion;
	private int marksPerQuestion;
	private int totalMarks;
	private String courseName;
	private String subjectName;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public long getPaperID() {
		return paperID;
	}

	public void setPaperID(long paperID) {
		this.paperID = paperID;
	}

	
	public long getFkStandardID() {
		return fkStandardID;
	}

	public void setFkStandardID(long fkStandardID) {
		this.fkStandardID = fkStandardID;
	}

	
	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public long getFkSubjectID() {
		return fkSubjectID;
	}

	public void setFkSubjectID(long fkSubjectID) {
		this.fkSubjectID = fkSubjectID;
	}

	public long getFkCourseID() {
		return fkCourseID;
	}

	public void setFkCourseID(long fkCourseID) {
		this.fkCourseID = fkCourseID;
	}

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public int getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(int totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public int getMarksPerQuestion() {
		return marksPerQuestion;
	}

	public void setMarksPerQuestion(int marksPerQuestion) {
		this.marksPerQuestion = marksPerQuestion;
	}


}
