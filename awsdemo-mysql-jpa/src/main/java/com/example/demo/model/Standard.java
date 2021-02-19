package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Standard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long standardID;
	private String className;

	public long getStandardID() {
		return standardID;
	}

	public void setStandardID(long standardID) {
		this.standardID = standardID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
