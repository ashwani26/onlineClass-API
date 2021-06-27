package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;

	private String uName;
	private String password;
	private String fName;
	private String mName;
	private String lName;
	private String eID;
	private String mobile;
	private String email;
	private int roleType;
	private String userImagePath;
	private String country;
	private String state;

	// for teacher roletype
	private long fkStandardID;
	private String standardName;
	
	private long fkSubjectID;
	private String subjectName;
	
	private boolean isAvailable;
	private boolean isPremium;
	private String description;
	private long fkDocumentLibraryID;

	
	public long getFkDocumentLibraryID() {
		return fkDocumentLibraryID;
	}


	public void setFkDocumentLibraryID(long fkDocumentLibraryID) {
		this.fkDocumentLibraryID = fkDocumentLibraryID;
	}


	public String getStandardName() {
		return standardName;
	}


	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean getIsPremium() {
		return isPremium;
	}

	public void setIsPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public int getRoleType() {
		return roleType;
	}


	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}


	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String geteID() {
		return eID;
	}

	public void seteID(String eID) {
		this.eID = eID;
	}

	public String getUserImagePath() {
		return userImagePath;
	}

	public void setUserImagePath(String userImagePath) {
		this.userImagePath = userImagePath;
	}
}
