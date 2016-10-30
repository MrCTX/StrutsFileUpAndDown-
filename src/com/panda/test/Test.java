package com.panda.test;

import static org.junit.Assert.*;

import java.io.File;

import com.panda.bean.MyFile;
import com.panda.dao.FileDaoImpl;


/*
* @author MrC
* @date 2016年10月29日上午11:22:20
* @parameter
* @version
*/
public class Test {
	@org.junit.Test
	public void test() {
		File file = new File("f:","hello.jpg");
		System.out.println(file.getAbsolutePath());
		MyFile[] my = new MyFile[2];
		for(int i = 0 ; i < my.length ;i++) {
			my[i] = new MyFile();
			my[i].setFileName("hello");
			my[i].setFilePath("f:");
		}
		System.out.println(my[0].getFileName());
	}

}
 