package com.collaboration.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class uploadImage implements Serializable{
	private String filename;
	//private CommonsMultipartFile fileData;
	private MultipartFile fileData;

	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public MultipartFile getFileData() {
		return fileData;
	}


	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}


	/*public CommonsMultipartFile getFileData() {
		return fileData;
	}


	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}*/
	
	
}
