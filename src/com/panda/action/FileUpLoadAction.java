package com.panda.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.panda.bean.MyFile;
import com.panda.dao.FileDaoImpl;

/*
* @author MrC
* @date 2016年10月29日上午10:35:25
* @parameter 文件上传的action
* @version
*/
@SuppressWarnings("serial")
public class FileUpLoadAction extends ActionSupport {
	//上传的文件，对应上传界面的文件名
	private File[] photo ;
	//上传文件名
	private String[] photoFileName ;
	//上传文件类型
	private String[] photoFileContentType ;
	
	public File[] getPhoto() {
		return photo;
	}

	public void setPhoto(File[] photo) {
		this.photo = photo;
	}


	public String[] getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String[] photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String[] getPhotoFileContentType() {
		return photoFileContentType;
	}

	public void setPhotoFileContentType(String[] photoFileContentType) {
		this.photoFileContentType = photoFileContentType;
	}

	//处理方法
	public String doFile() {
		File target = null ;
		MyFile[] myFile = null ;
		ServletContext actionContext = null ;
		for (int i = 0 ; i < photo.length ; i++) {
			try {
				actionContext = ServletActionContext.getServletContext();
				myFile = new MyFile[photo.length];
				String targets = actionContext.getRealPath("/files");
				//target对象是指具体的保存路径，保存在f盘下，以上传的文件名为保存到的文件名
				target = new File("f:",photoFileName[i]);
				System.out.println(target.getAbsolutePath());
				//保存文件，第一个参数是指文件，第二个参数是指路径
				FileUtils.copyFile(photo[i], target);
				//为文件数组中的没一个对象的文件名和文件路径属性赋值
				myFile[i] = new MyFile();
				myFile[i].setFileName(photoFileName[i]);
				myFile[i].setFilePath(target.getAbsolutePath());
				new FileDaoImpl().addFile(myFile[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//将文件添加进数据库中
		//如果成功，返回一个SUCCESS视图
		return SUCCESS ;
	}
}
