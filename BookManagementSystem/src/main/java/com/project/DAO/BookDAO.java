package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.beans.BookBean;
import com.project.dbs.DbConnection;

public class BookDAO {
	public int addBook(BookBean bb) {
		int k=0;
		try {
			Connection con=DbConnection.getCon();
			PreparedStatement pstmt=con.prepareStatement("Insert into book values(BOOK_SEQ.NEXTVAL,?,?,?,?)");
			pstmt.setString(1, bb.getBookName());
			pstmt.setString(2,bb.getAuthor());
			pstmt.setDouble(3, bb.getPrice());
			pstmt.setInt(4, bb.getQty());
			
			k=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
	public int deleteBook(int id) {
		int k=0;
		try {
			Connection con=DbConnection.getCon();
			PreparedStatement pstmt=con.prepareStatement("Delete from book where id=?");
			pstmt.setInt(1, id);
			
			k=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
	public int updateBook(BookBean bb) {
		int k=0;
		try {
			Connection con=DbConnection.getCon();
			PreparedStatement pstmt=con.prepareStatement("Update book set name=?, author=?, price=?, quantity=? where id=?");
			pstmt.setString(1, bb.getBookName());
			pstmt.setString(2,bb.getAuthor());
			pstmt.setDouble(3, bb.getPrice());
			pstmt.setInt(4, bb.getQty());
			pstmt.setInt(5, bb.getBookId());
			
			k=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
	public List<BookBean> viewAllBooks(){
		List<BookBean> list=new ArrayList<>();
		
		try {
			Connection con=DbConnection.getCon();
			PreparedStatement pstmt=con.prepareStatement("Select * from book");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				BookBean bb=new BookBean();
				bb.setBookId(rs.getInt("id"));
				bb.setBookName(rs.getString("name"));
				bb.setAuthor(rs.getString("author"));
				bb.setPrice(rs.getDouble("price"));
				bb.setQty(rs.getInt("quantity"));
				list.add(bb);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
}
