package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.project.beans.AdminBean;
import com.project.dbs.DbConnection;

public class AdminDAO {
	public int register(AdminBean ab) {
		int k=0;
		try {
			Connection con=DbConnection.getCon();
			System.out.println("Connection created");
			PreparedStatement pstmt=con.prepareStatement("insert into register values(?,?,?,?)");
			System.out.println("Stmt created");
			pstmt.setString(1, ab.getName());
			pstmt.setString(2, ab.getPass());
			pstmt.setString(3, ab.getEmail());
			pstmt.setLong(4, ab.getPhone());
			
			k=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
