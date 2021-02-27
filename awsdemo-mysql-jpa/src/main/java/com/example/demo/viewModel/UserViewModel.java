package com.example.demo.viewModel;

import com.example.demo.model.User;
import com.example.demo.model.UserRoleType;
import com.example.demo.model.UserSubjectAssociation;

public class UserViewModel {
private User user;
private UserSubjectAssociation usa;
private String uName;
private String password;
private String fName;
private String mName;
private String lName;
private String eID;
private String mobile;
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
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public UserRoleType getRoleType() {
	return roleType;
}
public void setRoleType(UserRoleType roleType) {
	this.roleType = roleType;
}
public long getUserID() {
	return userID;
}
public void setUserID(long userID) {
	this.userID = userID;
}
public long getSubjectID() {
	return subjectID;
}
public void setSubjectID(long subjectID) {
	this.subjectID = subjectID;
}
public long getStandardID() {
	return standardID;
}
public void setStandardID(long standardID) {
	this.standardID = standardID;
}
private String email;
private UserRoleType roleType;

private long userID;
private long subjectID;
private long standardID;


public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public UserSubjectAssociation getUsa() {
	return usa;
}
public void setUsa(UserSubjectAssociation usa) {
	this.usa = usa;
}

}
