package com.project.dbs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static Connection con;
	
	public static Connection getCon() {
		try {
			if(con==null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","advjava","practice");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
