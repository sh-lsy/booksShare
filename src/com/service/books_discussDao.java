package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.Basedao;
import com.entity.books_discuss;

public class books_discussDao {
	/*
	 * 添加话题或讨论
	 */
	public static int insert(books_discuss discuss) {
		String sql = "insert into books_discuss values(null, ?, ?,?,?,?)";
		
		Object[] params = {
				discuss.getDiscuss_content(),
				discuss.getDiscuss_p_id(),
				discuss.getDiscuss_u_id(),
				discuss.getDiscuss_u_name(),
				discuss.getDiscuss_time()
				};

		return Basedao.exectuIUD(sql, params);
	}
	/*
	 * 查询话题
	 */
	public static ArrayList<books_discuss> selectBypid (int pid){
		
		ArrayList<books_discuss> list = new ArrayList<books_discuss>();
			
			ResultSet rs = null;
			Connection conn = Basedao.getconn();
			
			PreparedStatement ps = null;
			
			try {
				String sql="select * from books_discuss  where discuss_p_id=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1,pid);		
				
				rs=ps.executeQuery();
				
				while(rs.next()) {
					books_discuss discuss= new books_discuss(
						 rs.getInt("discuss_id"),
						 rs.getString("discuss_content"),
						 rs.getInt("discuss_p_id"),
						 rs.getString("discuss_u_id"),
						 rs.getString("discuss_u_name"),
						 rs.getString("discuss_time")
							);	
					list.add(discuss);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				Basedao.closeall(rs, ps, conn);
			}
			return list;	
		}
	/*
	 * 删除
	 */
	public static int del(int id) {
		String sql = "delete from books_discuss where discuss_id=?";
		
		Object[] params = {id};
		
		return Basedao.exectuIUD(sql, params);
		
	}
}
