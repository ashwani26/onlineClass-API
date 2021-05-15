package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseStudentAssociation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseStudentAssociationID;
	private long fkUserID;
	private long fkCourseID;

	public long getCourseStudentAssociationID() {
		return courseStudentAssociationID;
	}

	public void setCourseStudentAssociationID(long courseStudentAssociationID) {
		this.courseStudentAssociationID = courseStudentAssociationID;
	}

	public long getFkUserID() {
		return fkUserID;
	}

	public void setFkUserID(long fkUserID) {
		this.fkUserID = fkUserID;
	}

	public long getFkCourseID() {
		return fkCourseID;
	}

	public void setFkCourseID(long fkCourseID) {
		this.fkCourseID = fkCourseID;
	}

}
