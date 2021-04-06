package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Course {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseID;
	private String courseName;

	// private CourseCategory courseCategory;
	private long fkCourseCategoryID;
	private boolean status;
	private Date endDate;

	private String description;
	private double price;

	// add course
	private String subjectList;// comma seprated subject
	private Date startDate;
	private String logoPath;

	


	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(String subjectList) {
		this.subjectList = subjectList;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getCourseID() {
		return courseID;
	}

	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getFkCourseCategoryID() {
		return fkCourseCategoryID;
	}

	public void setFkCourseCategoryID(long fkCourseCategoryID) {
		this.fkCourseCategoryID = fkCourseCategoryID;
	}

}
