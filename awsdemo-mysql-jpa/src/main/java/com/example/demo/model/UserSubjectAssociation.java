package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserSubjectAssociation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userSubjAssociationID;
	private long userID;
	private long subjectID;
	private long standardID;
	

	public long getStandardID() {
		return standardID;
	}

	public void setStandardID(long standardID) {
		this.standardID = standardID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(long subjectID) {
		this.subjectID = subjectID;
	}

	public long getUserSubjAssociationID() {
		return userSubjAssociationID;
	}

	public void setUserSubjAssociationID(long userSubjAssociationID) {
		this.userSubjAssociationID = userSubjAssociationID;
	}

}
