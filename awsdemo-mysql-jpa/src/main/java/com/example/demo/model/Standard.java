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
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Standard(long standardID, String className) {
		super();
		this.standardID = standardID;
		this.className = className;
	}

	public Standard() {
		super();
	}

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
