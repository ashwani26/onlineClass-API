package com.example.demo.model;

import java.util.Date;

public class BaseModel {
	private String createdBy;
	private Date dateCreated;
	private String modifedBy;
	private Date dateModified;
	private boolean deleted;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getModifedBy() {
		return modifedBy;
	}

	public void setModifedBy(String modifedBy) {
		this.modifedBy = modifedBy;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
