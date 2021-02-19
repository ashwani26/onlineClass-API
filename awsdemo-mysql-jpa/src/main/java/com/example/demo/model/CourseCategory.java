package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseCategoryID;
	private String subject;
	private long fkStandardID;

	public long getCourseCategoryID() {
		return courseCategoryID;
	}

	public void setCourseCategoryID(long courseCategoryID) {
		this.courseCategoryID = courseCategoryID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public long getFkStandardID() {
		return fkStandardID;
	}

	public void setFkStandardID(long fkStandardID) {
		this.fkStandardID = fkStandardID;
	}
}
