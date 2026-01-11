package com.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DataSource {

	private static final String URL = "jdbc:mysql://localhost:3306/project";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "@Simran09";
	private static final String loadDriver = "com.mysql.cj.jdbc.Driver";
	
	
	static {
		try {
			Class.forName(loadDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection get() throws SQLException {
	Connection con=DriverManager.getConnection(URL,USER_NAME,PASSWORD);
		return con;
	}
}
