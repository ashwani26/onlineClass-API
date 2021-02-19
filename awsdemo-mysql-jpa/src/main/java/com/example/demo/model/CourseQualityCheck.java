package com.example.demo.model;

public class CourseQualityCheck {
	private long courseQualityCheckID;
	private boolean isQCpassed;
	private String comments;
	private QualityCheckStatus qualityCheckStatus;

	public long getCourseQualityCheckID() {
		return courseQualityCheckID;
	}

	public void setCourseQualityCheckID(long courseQualityCheckID) {
		this.courseQualityCheckID = courseQualityCheckID;
	}

	public boolean isQCpassed() {
		return isQCpassed;
	}

	public void setQCpassed(boolean isQCpassed) {
		this.isQCpassed = isQCpassed;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public QualityCheckStatus getQualityCheckStatus() {
		return qualityCheckStatus;
	}

	public void setQualityCheckStatus(QualityCheckStatus qualityCheckStatus) {
		this.qualityCheckStatus = qualityCheckStatus;
	}
}
