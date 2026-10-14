package com.hasan.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hasan.DB.DbConnection;
import com.hasan.bean.Order;

public class OrderDAO {
	public int add(Order o) {
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("insert into product_order values(?,?,?,?)");
			pstmt.setInt(1, o.getId());
			pstmt.setString(2, o.getProduct());
			pstmt.setInt(3, o.getQuantity());
			pstmt.setString(4, o.getStatus());
			int rs=pstmt.executeUpdate();
			return rs;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}
	
	public int update(Order o,int i) {
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("update product_order set product=?, quantity=?, status=? where id=?");
			
			pstmt.setString(1, o.getProduct());
			pstmt.setInt(2, o.getQuantity());
			pstmt.setString(3, o.getStatus());
			pstmt.setInt(4, i);
			int rs=pstmt.executeUpdate();
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int delete(int i) {
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("delete from product_order where id=?");
			pstmt.setInt(1, i);
			int rs=pstmt.executeUpdate();
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Order> getAllOrders() {

        List<Order> list = new ArrayList<>();

        try {
            Connection con = DbConnection.getConnection();

            String query = "SELECT * FROM product_order";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order o = new Order();

                o.setId(rs.getInt("id"));
                o.setProduct(rs.getString("product"));
                o.setQuantity(rs.getInt("quantity"));
                o.setStatus(rs.getString("status"));

                list.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
