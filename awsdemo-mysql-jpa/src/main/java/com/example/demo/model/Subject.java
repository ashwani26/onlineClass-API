package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subjectID;
	private String subName;
	// to refer icon of subject
	private long fkDocLibID;



	public long getFkDocLibID() {
		return fkDocLibID;
	}

	public void setFkDocLibID(long fkDocLibID) {
		this.fkDocLibID = fkDocLibID;
	}

	public long getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(long subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}



}
