package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.Basedao;
import com.entity.books_cart;


public class books_cartDao {
	public static int insert(books_cart cart){
		String sql = "insert into books_cart values(null,?,?,?,?,?,?,?,?,1)";
		
		Object[] params = {
				cart.getCart_b_filename(),
				cart.getCart_b_name(),
				cart.getCart_b_description(),
				cart.getCart_b_user(),
				cart.getCart_quantity(),
				cart.getCart_b_stock(),
				cart.getCart_b_id(),
				cart.getCart_u_id()
				
		};
		
		return Basedao.exectuIUD(sql, params);
	}
	public static ArrayList<books_cart> getCart(String id){
		ArrayList<books_cart> list = new ArrayList<books_cart>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
			String sql = "select * from books_cart where cart_u_id=? and cart_valid=1 order by cart_id desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 books_cart c = new books_cart(
						 	rs.getInt("cart_id"),
						 	rs.getString("cart_b_filename"),
						 	rs.getString("cart_b_name"),
						 	rs.getString("cart_b_description"),
						 	rs.getString("cart_b_user"),
						 	rs.getInt("cart_quantity"),
						 	rs.getInt("cart_b_stock"),
						 	rs.getInt("cart_b_id"),
						 	rs.getString("cart_u_id"),
						 	rs.getInt("cart_valid")
						 );
		 
				 list.add(c);
				 
			 }
 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}
	
	public static books_cart getCartShop(String id) {
		books_cart es =null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from books_cart where cart_id=? and cart_valid =1 order by cart_id desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 es = new books_cart(
						 	rs.getInt("cart_id"),
						 	rs.getString("cart_b_filename"),
						 	rs.getString("cart_b_name"),
						 	rs.getString("cart_b_description"),
						 	rs.getString("cart_b_user"),
						 	rs.getInt("cart_quantity"),
						 	rs.getInt("cart_b_stock"),
						 	rs.getInt("cart_b_id"),
						 	rs.getString("cart_u_id"),
						 	rs.getInt("cart_valid")
						 ); 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return es;	
	}
	
	public static books_cart getCartShop(String uid, String bid) {
		books_cart es =null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from books_cart where cart_u_id=? and cart_b_id=? and cart_valid =1 order by cart_id desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, Integer.parseInt(bid));
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 es = new books_cart(
						 	rs.getInt("cart_id"),
						 	rs.getString("cart_b_filename"),
						 	rs.getString("cart_b_name"),
						 	rs.getString("cart_b_description"),
						 	rs.getString("cart_b_user"),
						 	rs.getInt("cart_quantity"),
						 	rs.getInt("cart_b_stock"),
						 	rs.getInt("cart_b_id"),
						 	rs.getString("cart_u_id"),
						 	rs.getInt("cart_valid")
						 ); 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return es;	
	}
		public static int updatenum(int esid, int count){
		
		String sql = "update books_cart set cart_quantity=? where cart_id=? ";
		
		Object[] params = {count, esid};
		
		return Basedao.exectuIUD(sql, params);
		
	}
		public static int getDeleteDD(int id) {
			String sql="delete from books_cart where cart_id=?";
			
			Object[] params={id};
			
			return Basedao.exectuIUD(sql, params);
		}
}
