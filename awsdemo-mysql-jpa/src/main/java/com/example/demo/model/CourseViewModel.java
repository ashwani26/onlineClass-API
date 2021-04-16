package com.example.demo.model;

import java.util.Date;

public class CourseViewModel {
	private String courseName;
	private String subjectList;
	private String standardName;
	private Date startDate;
	private Date endDate;
	private double Price;
	private String courseLogoPath;
	

	public String getCourseLogoPath() {
		return courseLogoPath;
	}

	public void setCourseLogoPath(String courseLogoPath) {
		this.courseLogoPath = courseLogoPath;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(String subjectList) {
		this.subjectList = subjectList;
	}

	public String getStandardName() {
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
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

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

}
