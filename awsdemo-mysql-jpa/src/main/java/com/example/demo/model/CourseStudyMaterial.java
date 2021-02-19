package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseStudyMaterial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseStudyMateialAssID;
	private long courseID;
	private long studyMaterialID;
	private CourseType courseType;

//	private Course course;
//
//	private StudyMaterial studyMaterial;

	public long getCourseStudyMateialAssID() {
		return courseStudyMateialAssID;
	}

	public void setCourseStudyMateialAssID(long courseStudyMateialAssID) {
		this.courseStudyMateialAssID = courseStudyMateialAssID;
	}

	public long getCourseID() {
		return courseID;
	}

	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}

	public long getStudyMaterialID() {
		return studyMaterialID;
	}

	public void setStudyMaterialID(long studyMaterialID) {
		this.studyMaterialID = studyMaterialID;
	}

	public CourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

}
