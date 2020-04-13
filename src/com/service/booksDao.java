package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.Basedao;
import com.entity.books;

public class booksDao {
	
	public static int insert(books b) {
		String sql = "insert into books values(null, ?, ?,?,?,?,?,?)";
		
		
		Object[] params = {
					b.getBooks_name(),
					b.getBooks_description(),
					b.getBooks_stock(),
					b.getBooks_user(),
					b.getBooks_fid(),
					b.getBooks_cid(),
					b.getBooks_filename()
					};
		
		return Basedao.exectuIUD(sql, params);
	}
	public static ArrayList<books> selectAll() {
		ArrayList<books> list = new ArrayList<books>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from books";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 books b = new books(
						 rs.getInt("books_id"),
						 rs.getString("books_name"),
						 rs.getString("books_description"),
						 rs.getInt("books_stock"),
						 rs.getString("books_user"),
						 rs.getInt("books_fid"),
						 rs.getInt("books_cid"),
						 rs.getString("books_filename")
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
