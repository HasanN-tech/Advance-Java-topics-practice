package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.beans.AdminBean;
import com.project.beans.OrderBean;
import com.project.dbs.DbConnection;

public class OrderDao {
	Connection con=DbConnection.getCon();
	public int add(OrderBean bb) {
		int r=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(
				    "insert into Product_Order values(?,?,?,?)");
			pstmt.setInt(1, bb.getId());
			pstmt.setString(2, bb.getProduct());
			pstmt.setInt(3, bb.getQuantity());
			pstmt.setString(4, bb.getStatus());
			r=pstmt.executeUpdate();
			return r;
	}catch (Exception e) {
		e.printStackTrace();
	}
		return 0;
	}

	public int update(OrderBean bb) {
		try {
			PreparedStatement pstmt=con.prepareStatement("update product_order set product=?, quantity=?, status=? where id=?");
			pstmt.setString(1, bb.getProduct());
			pstmt.setInt(2, bb.getQuantity());
			pstmt.setString(3, bb.getStatus());
			pstmt.setInt(4, bb.getId());
			
			int r=pstmt.executeUpdate();
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
