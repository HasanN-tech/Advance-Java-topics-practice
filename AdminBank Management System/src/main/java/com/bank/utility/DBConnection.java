package com.bank.utility;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection implements DBConfig{
	public static Connection conn;
	public static Connection getConnection() {
		try {
			if(conn==null || conn.isClosed()) {
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
				System.out.println("databse Connected Successfully!.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
