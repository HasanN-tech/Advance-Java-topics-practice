package com.hasan.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hasan.DB.DbConnection;

public class LoginDAO {
	public boolean login(String name, String pass) {
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM register WHERE NAME=? AND Password=?");
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		}catch (Exception e) {
			 System.out.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
}
