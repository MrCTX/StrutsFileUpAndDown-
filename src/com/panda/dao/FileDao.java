package com.panda.dao;

import java.util.List;

import com.panda.bean.MyFile;

/*
* @author MrC
* @date 2016年10月29日上午9:59:57
* @parameter
* @version
*/
//文件操作的统一接口
public interface FileDao {
	@SuppressWarnings("rawtypes")
	public List getAllFilesPath();
	public void addFile(MyFile myFile);
}
