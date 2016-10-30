package com.panda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/*
* @author MrC
* @date 2016年10月13日上午10:22:27
* @parameter 连接数据库的操作
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
		//获得当前类的类加载器
		ClassLoader loader = JdbcUtil.class.getClassLoader();
		try {
			//加载文件资源
			properties.load(loader.getResourceAsStream("jdbc.properties"));
			//通过键获得对应的键值
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			System.out.println(driver+url+user+password);
			//通过driver加载驱动
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			//连接数据库
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (connection != null) {
			return connection;
		}
		return null;
	}
	
	//关闭数据中
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
	
	
	//关闭数据中
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
