package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.Basedao;
import com.entity.books;
import com.entity.user_books;

public class userbooksDao {
	public static int insert(books b) {
		String sql = "insert into user_books values(null, ?, ?,?,?,?,?,?,?,?)";
		
		
		Object[] params = {
					b.getBooks_name(),
					b.getBooks_description(),
					b.getBooks_stock(),
					b.getBooks_user(),
					b.getBooks_fid(),
					b.getBooks_cid(),
					b.getBooks_filename(),
					b.getBooks_filename1(),
					b.getBooks_filename2()
					};
		
		return Basedao.exectuIUD(sql, params);
	}
	public static ArrayList<user_books> selectByUid(String uid) {
		ArrayList<user_books> list = new ArrayList<user_books>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from user_books where books_user=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,uid);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 user_books b = new user_books(
						 rs.getInt("books_id"),
						 rs.getString("books_name"),
						 rs.getString("books_description"),
						 rs.getInt("books_stock"),
						 rs.getString("books_user"),
						 rs.getInt("books_fid"),
						 rs.getInt("books_cid"),
						 rs.getString("books_filename"),
						 rs.getString("books_filename1"),
						 rs.getString("books_filename2")
						 );

				 list.add(b);
				 
			 }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
}
