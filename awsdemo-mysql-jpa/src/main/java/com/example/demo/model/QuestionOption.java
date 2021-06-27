package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionOption {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long optionID;
	private String optionText1;
	private String optionText2;
	private String optionText3;
	private String optionText4;
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

	private long fkQuestionID;

	public long getOptionID() {
		return optionID;
	}

	public void setOptionID(long optionID) {
		this.optionID = optionID;
	}


	public long getFkQuestionID() {
		return fkQuestionID;
	}

	public void setFkQuestionID(long fkQuestionID) {
		this.fkQuestionID = fkQuestionID;
	}
}
