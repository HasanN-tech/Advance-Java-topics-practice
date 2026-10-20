package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.beans.AdminBean;
import com.project.dbs.DbConnection;

public class LoginDAO {
	public AdminBean login(String name, String pass) {
		AdminBean ab=null;
		try {
			Connection con=DbConnection.getCon();
			PreparedStatement pstmt = con.prepareStatement(
				    "SELECT * FROM ADMIN WHERE NAME=? AND Password=?"
				);pstmt.setString(1, name);
			pstmt.setString(2, pass);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				ab=new AdminBean();
				ab.setFname(rs.getString("first_name"));
				ab.setLname(rs.getString("last_name"));
				ab.setLname(rs.getString("name"));
				ab.setPass(rs.getString("password"));
				ab.setEmail(rs.getString("email"));
				ab.setPhone(rs.getLong("phone"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
}
