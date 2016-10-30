package com.panda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.panda.bean.MyFile;
import com.panda.jdbc.JdbcUtil;

/*
* @author MrC
* @date 2016��10��29������10:02:41
* @parameter
* @version
*/
public class FileDaoImpl implements FileDao {
	private  Connection connection ;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getAllFilesPath() {
		//�������϶������ڴ�File����
		List arrayList = new ArrayList();
		//�������ݿ�
		connection = JdbcUtil.getConnection();
		//��ѯ�������ݵ�sql���
		String sql = "select * from myFile" ;
		MyFile file = null ;
		Statement statement = null;
		ResultSet resultSet = null ;
		try {
			statement = connection.createStatement();
		    resultSet = statement.executeQuery(sql);
		    //ֻҪresultSet�������ݣ��Ͳ��϶�ȡ������ֵ��������File���������
			while (resultSet.next()) {
				file = new MyFile();
				file.setId(resultSet.getInt("id"));
				file.setFileName(resultSet.getString("filename"));
				file.setFilePath(resultSet.getString("filepath"));
				//��ӽ�List������
				arrayList.add(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//�ر����ݿ�
		JdbcUtil.closeConnection(connection, statement, resultSet);
		//���ؼ��϶���
		return arrayList ;
	}
	//���ϴ����ļ���ӽ����ݿ�
	public void addFile(MyFile file) {
		connection = JdbcUtil.getConnection();
		String sql = "insert into myFile values(null,?,?)";
		PreparedStatement ps = null ;
		try {
			 ps = connection.prepareStatement(sql);
				ps.setString(1, file.getFileName());
				ps.setString(2, file.getFilePath());
				ps.executeUpdate() ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		JdbcUtil.closeConnection(connection, ps);
	}

}
