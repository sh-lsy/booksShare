package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.dao.Basedao;

import com.entity.books_order;
import com.entity.order;


public class books_orderDao {
	
	public static int insert(books_order order){
		String sql = "insert into books_order values(null,?,?,?,?,?,?,?,?,?,1)";
		
		Object[] params = {
				order.getOrder_time(),
				order.getOrder_no(),
				order.getOrder_b_filename(),
				order.getOrder_b_name(),
				order.getOrder_b_user(),
				order.getOrder_quantity(),
				order.getOrder_b_id(),
				order.getOrder_way(),
				order.getOrder_u_id(),

		};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	public static ArrayList<books_order> selectByUid(String id){
		ArrayList<books_order> list = new ArrayList<books_order>();

		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
			
			String sql = "select * from books_order where order_u_id=? order by order_id desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 books_order o =new books_order(
						 rs.getInt("order_id"),
						 rs.getString("order_time"),
						 rs.getString("order_no"),
						 rs.getString("order_b_filename"),
						 rs.getString("order_b_name"),
						 rs.getString("order_b_user"),
						 rs.getInt("order_quantity"),
						 rs.getInt("order_b_id"),
						 rs.getString("orde_way"),
						 rs.getString("order_u_id"),
						 rs.getInt("order_valid")
						 );
				 list.add(o);
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
	 * 通过订单号查询订单详细信息
	 */
	public static ArrayList<books_order> selectByNo(String no){
		ArrayList<books_order> list = new ArrayList<books_order>();

		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
			
			String sql = "select * from books_order where order_no=? order by order_id desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, no);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 books_order o =new books_order(
						 rs.getInt("order_id"),
						 rs.getString("order_time"),
						 rs.getString("order_no"),
						 rs.getString("order_b_filename"),
						 rs.getString("order_b_name"),
						 rs.getString("order_b_user"),
						 rs.getInt("order_quantity"),
						 rs.getInt("order_b_id"),
						 rs.getString("orde_way"),
						 rs.getString("order_u_id"),
						 rs.getInt("order_valid")
						 );
				 list.add(o);
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
	 * 获取订单基本信息
	 */
	public static ArrayList<order> selectNo(String id){
		
		ArrayList<order> list = new ArrayList<order>();
		ArrayList<order> list1 = new ArrayList<order>();
		ArrayList<String> no = new ArrayList<String>();

		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
			String sql = "";
			if(id.length()<10) {
				sql = "select * from books_order where order_u_id=? order by order_id desc";
			}else {
				sql = "select * from books_order where order_no=? order by order_id desc";
			}
			 
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 books_order o =new books_order(
						 rs.getInt("order_id"),
						 rs.getString("order_time"),
						 rs.getString("order_no"),
						 rs.getString("order_b_filename"),
						 rs.getString("order_b_name"),
						 rs.getString("order_b_user"),
						 rs.getInt("order_quantity"),
						 rs.getInt("order_b_id"),
						 rs.getString("orde_way"),
						 rs.getString("order_u_id"),
						 rs.getInt("order_valid")
						 );
				 	list.add(new order(
				 			o.getOrder_time(),
				 			o.getOrder_no(),
				 			o.getOrder_way(),
				 			o.getOrder_valid()
				 			));
//				 	no.add(o.getOrder_no());
			 }
			 Set<String> set = new HashSet<String>();
			 set.addAll(no);     // 将list所有元素添加到set中    set集合特性会自动去重复
			 no.clear();
			 no.addAll(set);
			 
			 Set<order> userSet = new HashSet<>(list);
			 list1 = new ArrayList<>(userSet);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list1;
	}
	
		public static int updatevalid(int valid, String no){
		
		String sql = "update books_order set order_valid=? where order_no=? ";
		
		Object[] params = {valid,no};
		
		return Basedao.exectuIUD(sql, params);
		
	  }
	
}
