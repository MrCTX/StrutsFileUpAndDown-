package com.panda.dao;

import java.util.List;

import com.panda.bean.MyFile;

/*
* @author MrC
* @date 2016��10��29������9:59:57
* @parameter
* @version
*/
//�ļ�������ͳһ�ӿ�
public interface FileDao {
	@SuppressWarnings("rawtypes")
	public List getAllFilesPath();
	public void addFile(MyFile myFile);
}
