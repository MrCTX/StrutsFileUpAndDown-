package com.panda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/*
* @author MrC
* @date 2016��10��13������10:22:27
* @parameter �������ݿ�Ĳ���
* @version
*/
public class JdbcUtil {
	private static Connection connection ;
	private static String driver ;
	private static String url ;
	private static String user ;
	private static String password ;
	static {
		Properties properties = new Properties();
		//��õ�ǰ����������
		ClassLoader loader = JdbcUtil.class.getClassLoader();
		try {
			//�����ļ���Դ
			properties.load(loader.getResourceAsStream("jdbc.properties"));
			//ͨ������ö�Ӧ�ļ�ֵ
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			System.out.println(driver+url+user+password);
			//ͨ��driver��������
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			//�������ݿ�
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (connection != null) {
			return connection;
		}
		return null;
	}
	
	//�ر�������
	public static void closeConnection(Connection connection ,Statement statement ,ResultSet resultSet) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (resultSet != null) {
							try {
								resultSet.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
	
	
	//�ر�������
		public static void closeConnection(Connection connection ,PreparedStatement statement ) {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (statement != null) {
						try {
							statement.close();
						} catch (Exception e) {
				}
					}
				}
			}
		}
		
	public static void main(String[] args) {
		connection = getConnection();
		System.out.println(connection);
	}
}
