package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chapter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long chapterID;
	private String chapterName;
	private long fkSubjectID;
	
	
	public Chapter(long chapterID, String chapterName) {
		super();
		this.chapterID = chapterID;
		this.chapterName = chapterName;
	}
	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getFkSubjectID() {
		return fkSubjectID;
	}
	public void setFkSubjectID(long fkSubjectID) {
		this.fkSubjectID = fkSubjectID;
	}
	public long getChapterID() {
		return chapterID;
	}
	public void setChapterID(long chapterID) {
		this.chapterID = chapterID;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

}
