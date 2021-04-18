package com.example.demo.model;

public class StandardViewModel {
private String className;
private String subjectList;
public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public String getSubjectList() {
	return subjectList;
}
public StandardViewModel(String className, String subjectList) {
	super();
	this.className = className;
	this.subjectList = subjectList;
}
public void setSubjectList(String subjectList) {
	this.subjectList = subjectList;
}

}
