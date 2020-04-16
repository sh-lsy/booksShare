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
		String sql = "insert into books values(null, ?, ?,?,?,?,?,?,?,?)";
		
		
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
	/*
	 * 查询所有书
	 */
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
	/*
	 * 通过id查询
	 */
	public static ArrayList<books> selectByFid(int fid) {
		ArrayList<books> list = new ArrayList<books>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from books where books_fid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,fid);
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
	public static ArrayList<books> selectByCid(int cid) {
		ArrayList<books> list = new ArrayList<books>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from books where books_cid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,cid);
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
	
	public static ArrayList<books> selectAllById(ArrayList<Integer> ids) {
		ArrayList<books> lastlylist = new ArrayList<books>();
		books b = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		try {
			for(int i=0;i<ids.size();i++) {
				
			
			String sql = "select * from books where books_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,ids.get(i));
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				  b = new books(
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

				 lastlylist.add(b);
			 }
			 }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return lastlylist;
	}
	
	public static books selectById(int id) {
		books book = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		try {
			String sql = "select * from books where books_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 book = new books(
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
		 
			 }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return book;
	}
}
