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
* @date 2016��10��29������10:35:25
* @parameter �ļ��ϴ���action
* @version
*/
@SuppressWarnings("serial")
public class FileUpLoadAction extends ActionSupport {
	//�ϴ����ļ�����Ӧ�ϴ�������ļ���
	private File[] photo ;
	//�ϴ��ļ���
	private String[] photoFileName ;
	//�ϴ��ļ�����
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

	//������
	public String doFile() {
		File target = null ;
		MyFile[] myFile = null ;
		ServletContext actionContext = null ;
		for (int i = 0 ; i < photo.length ; i++) {
			try {
				actionContext = ServletActionContext.getServletContext();
				myFile = new MyFile[photo.length];
				String targets = actionContext.getRealPath("/files");
				//target������ָ����ı���·����������f���£����ϴ����ļ���Ϊ���浽���ļ���
				target = new File("f:",photoFileName[i]);
				System.out.println(target.getAbsolutePath());
				//�����ļ�����һ��������ָ�ļ����ڶ���������ָ·��
				FileUtils.copyFile(photo[i], target);
				//Ϊ�ļ������е�ûһ��������ļ������ļ�·�����Ը�ֵ
				myFile[i] = new MyFile();
				myFile[i].setFileName(photoFileName[i]);
				myFile[i].setFilePath(target.getAbsolutePath());
				new FileDaoImpl().addFile(myFile[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//���ļ���ӽ����ݿ���
		//����ɹ�������һ��SUCCESS��ͼ
		return SUCCESS ;
	}
}
