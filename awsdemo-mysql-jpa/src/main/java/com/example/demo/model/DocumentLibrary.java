package com.example.demo.model;

public class DocumentLibrary {
private long docLibID;
private String uuid;
private String fileName;
private String fileType;
private String extension;
public long getDocLibID() {
	return docLibID;
}
public void setDocLibID(long docLibID) {
	this.docLibID = docLibID;
}
public String getUuid() {
	return uuid;
}
public void setUuid(String uuid) {
	this.uuid = uuid;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public String getFileType() {
	return fileType;
}
public void setFileType(String fileType) {
	this.fileType = fileType;
}
public String getExtension() {
	return extension;
}
public void setExtension(String extension) {
	this.extension = extension;
}

}
