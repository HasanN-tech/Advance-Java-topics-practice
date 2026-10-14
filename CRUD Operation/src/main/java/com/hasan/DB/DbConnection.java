package com.hasan.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection implements DbConfig{
	public static Connection conn;
	
	public static Connection getConnection() {
		try {
			if(conn==null || conn.isClosed()) {
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
