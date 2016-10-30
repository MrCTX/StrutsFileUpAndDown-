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
* @date 2016年10月29日上午10:02:41
* @parameter
* @version
*/
public class FileDaoImpl implements FileDao {
	private  Connection connection ;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getAllFilesPath() {
		//创建集合对象，用于存File对象
		List arrayList = new ArrayList();
		//连接数据库
		connection = JdbcUtil.getConnection();
		//查询所有数据的sql语句
		String sql = "select * from myFile" ;
		MyFile file = null ;
		Statement statement = null;
		ResultSet resultSet = null ;
		try {
			statement = connection.createStatement();
		    resultSet = statement.executeQuery(sql);
		    //只要resultSet中有数据，就不断读取，并赋值给创建的File对象的属性
			while (resultSet.next()) {
				file = new MyFile();
				file.setId(resultSet.getInt("id"));
				file.setFileName(resultSet.getString("filename"));
				file.setFilePath(resultSet.getString("filepath"));
				//添加进List集合中
				arrayList.add(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//关闭数据库
		JdbcUtil.closeConnection(connection, statement, resultSet);
		//返回集合对象
		return arrayList ;
	}
	//将上传的文件添加进数据库
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
