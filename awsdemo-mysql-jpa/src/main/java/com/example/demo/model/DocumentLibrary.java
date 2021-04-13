package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DocumentLibrary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long docLibID;
	private String uuID;
	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;

	public DocumentLibrary(String uuID,String fileName, String fileDownloadUri, String fileType, long size) {
       this.uuID = uuID;
		this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }
	public long getDocLibID() {
		return docLibID;
	}

	public void setDocLibID(long docLibID) {
		this.docLibID = docLibID;
	}

	public String getUuID() {
		return uuID;
	}

	public void setUuID(String uuID) {
		this.uuID = uuID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
