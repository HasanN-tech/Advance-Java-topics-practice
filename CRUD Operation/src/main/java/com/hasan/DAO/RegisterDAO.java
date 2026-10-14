package com.hasan.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.hasan.DB.DbConnection;
import com.hasan.bean.Register;

public class RegisterDAO {
	public int registration(Register r) {
		try {
	        Connection con = DbConnection.getConnection();

	        PreparedStatement pstmt = con.prepareStatement(
	            "INSERT INTO register (id, name, email, password) VALUES (?, ?, ?, ?)"
	        );

	        pstmt.setInt(1, r.getId());
	        pstmt.setString(2, r.getName());
	        pstmt.setString(3, r.getEmail());
	        pstmt.setString(4, r.getPassword());

	        int status = pstmt.executeUpdate();

	        return status;

	    } catch (Exception e) {
	        System.out.println("ERROR: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return 0;
	}
}
