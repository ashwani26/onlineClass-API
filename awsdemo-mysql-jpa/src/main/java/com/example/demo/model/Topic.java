package com.example.demo.model;

public class Topic {
	private long topicID;
	private long topicName;
	private long fkSubjectID;

	public long getTopicID() {
		return topicID;
	}

	public void setTopicID(long topicID) {
		this.topicID = topicID;
	}

	public long getTopicName() {
		return topicName;
	}

	public void setTopicName(long topicName) {
		this.topicName = topicName;
	}

	public long getFkSubjectID() {
		return fkSubjectID;
	}

	public void setFkSubjectID(long fkSubjectID) {
		this.fkSubjectID = fkSubjectID;
	}

}
