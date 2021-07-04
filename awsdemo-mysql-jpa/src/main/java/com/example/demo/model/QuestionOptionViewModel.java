package com.example.demo.model;

public class QuestionOptionViewModel {
	private String questionTxt;
	private long questionID;
	private int noOfOption;
	private int correctOptionID;
	private long fkPaperID;
	private String optionText1;
	private long fkOption1ID;
	private String optionText2;
	private long fkOption2ID;
	private String optionText3;
	private long fkOption3ID;
	private String optionText4;
	private long fkOption4ID;
	public long getFkOption1ID() {
		return fkOption1ID;
	}

	public long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(long questionID) {
		this.questionID = questionID;
	}

	public void setFkOption1ID(long fkOption1ID) {
		this.fkOption1ID = fkOption1ID;
	}

	public long getFkOption2ID() {
		return fkOption2ID;
	}

	public void setFkOption2ID(long fkOption2ID) {
		this.fkOption2ID = fkOption2ID;
	}

	public long getFkOption3ID() {
		return fkOption3ID;
	}

	public void setFkOption3ID(long fkOption3ID) {
		this.fkOption3ID = fkOption3ID;
	}

	public long getFkOption4ID() {
		return fkOption4ID;
	}

	public void setFkOption4ID(long fkOption4ID) {
		this.fkOption4ID = fkOption4ID;
	}

	public QuestionOptionViewModel(String questionTxt, String optionText1, String optionText2, String optionText3,
			String optionText4,int correctOptionID,long questionID) {
		super();
		this.questionTxt = questionTxt;
		this.optionText1 = optionText1;
		this.optionText2 = optionText2;
		this.optionText3 = optionText3;
		this.optionText4 = optionText4;
		this.correctOptionID = correctOptionID;
		this.questionID = questionID;
	}

	private long fkQuestionID;
	

	public String getOptionText1() {
		return optionText1;
	}

	public void setOptionText1(String optionText1) {
		this.optionText1 = optionText1;
	}

	public String getOptionText2() {
		return optionText2;
	}

	public void setOptionText2(String optionText2) {
		this.optionText2 = optionText2;
	}

	public String getOptionText3() {
		return optionText3;
	}

	public void setOptionText3(String optionText3) {
		this.optionText3 = optionText3;
	}

	public String getOptionText4() {
		return optionText4;
	}

	public void setOptionText4(String optionText4) {
		this.optionText4 = optionText4;
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

	public long getFkPaperID() {
		return fkPaperID;
	}

	public void setFkPaperID(long fkPaperID) {
		this.fkPaperID = fkPaperID;
	}

	public long getFkQuestionID() {
		return fkQuestionID;
	}

	public void setFkQuestionID(long fkQuestionID) {
		this.fkQuestionID = fkQuestionID;
	}

}
