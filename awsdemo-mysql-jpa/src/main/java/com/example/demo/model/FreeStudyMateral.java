package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class FreeStudyMateral {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long freeStudymaterialID;
	private long fkTopicID;
	private String descriptions;
	private long fkDocLibID;
	private String downLoadPath;
	private long fkCourseID;
	private boolean isPremium;
	
	

	public long getFkCourseID() {
		return fkCourseID;
	}

	public void setFkCourseID(long fkCourseID) {
		this.fkCourseID = fkCourseID;
	}

	public boolean getIsPremium() {
		return isPremium;
	}

	public void setIsPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	public String getDownLoadPath() {
		return downLoadPath;
	}

	public void setDownLoadPath(String downLoadPath) {
		this.downLoadPath = downLoadPath;
	}

	public long getFreeStudymaterialID() {
		return freeStudymaterialID;
	}

	public void setFreeStudymaterialID(long freeStudymaterialID) {
		this.freeStudymaterialID = freeStudymaterialID;
	}

	public long getFkTopicID() {
		return fkTopicID;
	}

	public void setFkTopicID(long fkTopicID) {
		this.fkTopicID = fkTopicID;
	}


	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public long getFkDocLibID() {
		return fkDocLibID;
	}

	public void setFkDocLibID(long fkDocLibID) {
		this.fkDocLibID = fkDocLibID;
	}

}
