package com.panda.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

/*
* @author MrC
* @date 2016年10月29日上午10:36:17
* @parameter 文件下载的Action
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
