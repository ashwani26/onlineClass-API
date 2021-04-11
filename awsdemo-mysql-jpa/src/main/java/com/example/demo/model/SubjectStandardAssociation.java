package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubjectStandardAssociation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subjectStandardAssociationID;
	private long fkSubjectID;
	private long fkStandardID;

	public long getSubjectStandardAssociationID() {
		return subjectStandardAssociationID;
	}

	public void setSubjectStandardAssociationID(long subjectStandardAssociationID) {
		this.subjectStandardAssociationID = subjectStandardAssociationID;
	}

	public long getFkSubjectID() {
		return fkSubjectID;
	}

	public void setFkSubjectID(long fkSubjectID) {
		this.fkSubjectID = fkSubjectID;
	}

	public long getFkStandardID() {
		return fkStandardID;
	}

	public void setFkStandardID(long fkStandardID) {
		this.fkStandardID = fkStandardID;
	}

}
