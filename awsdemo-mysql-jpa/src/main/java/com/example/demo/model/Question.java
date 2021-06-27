package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long questionID;
	private String questionTxt;
	private int noOfOption;
	private int correctOptionID;
	private long fkPaperID;

	public long getFkPaperID() {
		return fkPaperID;
	}

	public void setFkPaperID(long fkPaperID) {
		this.fkPaperID = fkPaperID;
	}

	public long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(long questionID) {
		this.questionID = questionID;
	}

	public String getQuestionTxt() {
		return questionTxt;
	}

	public void setQuestionTxt(String questionTxt) {
		this.questionTxt = questionTxt;
	}

	public int getNoOfOption() {
		return noOfOption;
	}

	public void setNoOfOption(int noOfOption) {
		this.noOfOption = noOfOption;
	}

	public int getCorrectOptionID() {
		return correctOptionID;
	}

	public void setCorrectOptionID(int correctOptionID) {
		this.correctOptionID = correctOptionID;
	}

}
