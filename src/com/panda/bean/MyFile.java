package com.panda.bean;
/*
* @author MrC
* @date 2016��10��29������10:00:33
* @parameter ����һ��javaBean����������������ļ�����
* @version 
*/
public class MyFile {
	private int id ;
	private String FileName;
	private String FilePath ;
	
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		this.FileName = fileName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilePath() {
		return FilePath;
	}
	public void setFilePath(String filePath) {
		this.FilePath = filePath;
	}
	
}
