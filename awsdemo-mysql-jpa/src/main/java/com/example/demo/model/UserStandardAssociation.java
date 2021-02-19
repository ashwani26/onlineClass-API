package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserStandardAssociation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long UserAssID;
	private long fkStandardId;
	private long fkUserID;
	
	public long getUserAssID() {
		return UserAssID;
	}
	public void setUserAssID(long userAssID) {
		UserAssID = userAssID;
	}
	public long getFkStandardId() {
		return fkStandardId;
	}
	public void setFkStandardId(long fkStandardId) {
		this.fkStandardId = fkStandardId;
	}
	public long getFkUserID() {
		return fkUserID;
	}
	public void setFkUserID(long fkUserID) {
		this.fkUserID = fkUserID;
	}

	

}
