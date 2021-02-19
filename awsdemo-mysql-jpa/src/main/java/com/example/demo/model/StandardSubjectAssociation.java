package com.example.demo.model;

public class StandardSubjectAssociation {
	private long stdSubjectAssID;
	private long fkStandardID;
	private long fkSubjectID;

	public long getStdSubjectAssID() {
		return stdSubjectAssID;
	}

	public void setStdSubjectAssID(long stdSubjectAssID) {
		this.stdSubjectAssID = stdSubjectAssID;
	}

	public long getFkStandardID() {
		return fkStandardID;
	}

	public void setFkStandardID(long fkStandardID) {
		this.fkStandardID = fkStandardID;
	}

	public long getFkSubjectID() {
		return fkSubjectID;
	}

	public void setFkSubjectID(long fkSubjectID) {
		this.fkSubjectID = fkSubjectID;
	}

}
