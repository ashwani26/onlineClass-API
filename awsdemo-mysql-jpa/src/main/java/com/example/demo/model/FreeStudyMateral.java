package com.example.demo.model;

import org.springframework.web.multipart.MultipartFile;

public class FreeStudyMateral {
	private long freeStudymaterialID;
	private long fkTopicID;
	private MultipartFile file;
	private String descriptions;
	private long fkDocLibID;

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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
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
