package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CandidateAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long candiateAnswerID;
	private long fkQuestionID;
	private long attemptedOptionID;
	private long correctOptionID;
	private boolean isCorrect;
	private Date attemptedDate;
	private int marksobtained;
	private long fkUserID;
	private long fkPaperID;
	
	public long getFkUserID() {
		return fkUserID;
	}
	public void setFkUserID(long fkUserID) {
		this.fkUserID = fkUserID;
	}
	public long getFkPaperID() {
		return fkPaperID;
	}
	public void setFkPaperID(long fkPaperID) {
		this.fkPaperID = fkPaperID;
	}
	public long getCandiateAnswerID() {
		return candiateAnswerID;
	}
	public void setCandiateAnswerID(long candiateAnswerID) {
		this.candiateAnswerID = candiateAnswerID;
	}
	public long getFkQuestionID() {
		return fkQuestionID;
	}
	public void setFkQuestionID(long fkQuestionID) {
		this.fkQuestionID = fkQuestionID;
	}
	public long getAttemptedOptionID() {
		return attemptedOptionID;
	}
	public void setAttemptedOptionID(long attemptedOptionID) {
		this.attemptedOptionID = attemptedOptionID;
	}
	public long getCorrectOptionID() {
		return correctOptionID;
	}
	public void setCorrectOptionID(long correctOptionID) {
		this.correctOptionID = correctOptionID;
	}
	public boolean getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public Date getAttemptedDate() {
		return attemptedDate;
	}
	public void setAttemptedDate(Date attemptedDate) {
		this.attemptedDate = attemptedDate;
	}
	public int getMarksobtained() {
		return marksobtained;
	}
	public void setMarksobtained(int marksobtained) {
		this.marksobtained = marksobtained;
	}
	

}
