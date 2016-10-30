package com.panda.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

/*
* @author MrC
* @date 2016��10��29������10:36:17
* @parameter �ļ����ص�Action
* @version
*/
@SuppressWarnings("serial")
public class FileDownLoadAction extends ActionSupport {
	private String filename ;
	@SuppressWarnings("unused")
	private String encoderName ;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	public InputStream getTargetFile() throws Exception {
		File file = new File(filename);
		InputStream targetFile = new FileInputStream(file);
		return targetFile;
	}
	public String execute() throws Exception {
		return SUCCESS;
	}
	
}
