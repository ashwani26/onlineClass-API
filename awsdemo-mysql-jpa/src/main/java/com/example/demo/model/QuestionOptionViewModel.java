package com.example.demo.model;

public class QuestionOptionViewModel {
	private String questionTxt;
	private int noOfOption;
	private int correctOptionID;
	private long fkPaperID;
	private String optionText1;
	private String optionText2;
	private String optionText3;
	private String optionText4;
	public QuestionOptionViewModel(String questionTxt, String optionText1, String optionText2, String optionText3,
			String optionText4) {
		super();
		this.questionTxt = questionTxt;
		this.optionText1 = optionText1;
		this.optionText2 = optionText2;
		this.optionText3 = optionText3;
		this.optionText4 = optionText4;
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
