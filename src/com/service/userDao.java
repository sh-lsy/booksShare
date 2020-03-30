package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.Basedao;
import com.entity.booksShare_user;

public class userDao {
	public static int insert(booksShare_user u) {
		String sql = "insert into books_user values(?, ?, ?, ?, DATE_FORMAT(?, '%Y-%m-%d'), ?, ?, ?, ?, ?)";
		
		Object[] params = {
				u.getUser_id(),
				u.getUser_name(),
				u.getUser_password(),
				u.getUser_sex(),
				u.getUser_birthday(),
				u.getUser_id_code(),
				u.getUser_email(),
				u.getUser_mobile(),
				u.getUser_address(),
				u.getUser_status()};
		
		return Basedao.exectuIUD(sql, params);
	}
	/*
	 * 删除用户
	 */
	public static int del(String id) {
		
		String sql = "delete from books_user where user_id=? and user_status!=2";
		
		Object[] params = {id};
		
		return Basedao.exectuIUD(sql, params);
	}
	/*
	 * 提交修改后信息
	 */
	public static int update(booksShare_user u) {
		String sql = "update books_user set user_name=?, "
				+ "user_password=?,user_sex=?,user_birthday=DATE_FORMAT(?, '%y-%m-%d'),"
				+ "user_id_code=?,user_email=?,user_mobile=?,user_address=?,user_status=? where user_id= ?";
		
		Object[] params = {
				u.getUser_name(),
				u.getUser_password(),
				u.getUser_sex(),
				u.getUser_birthday(),
				u.getUser_id_code(),
				u.getUser_email(),
				u.getUser_mobile(),
				u.getUser_address(),
				u.getUser_status(),
				u.getUser_id()};
		
		return Basedao.exectuIUD(sql, params);
	}
	/*
	 * 验证用户名
	 */
	
	public static int selectByusername(String id) {
		int count=0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			try {
				String sql="select count(*) from books_user where user_id=?";
						ps = conn.prepareStatement(sql);
						ps.setString(1,id);
						rs=ps.executeQuery();
				while(rs.next()) {
					 count= rs.getInt(1);
					 
					 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				Basedao.closeall(rs, ps, conn);
			}
	
		
		return count;
	}
	
	
	/*
	 *  查询所有用户信息，分页处理
	 */
	public static int[] totalPage(int count,String keyword) {
		int arr[]= {0,1};
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			try {
				String sql="";
				if(keyword!=null) {
					 sql = "select count(*) from books_user where user_name like ?";
						ps = conn.prepareStatement(sql);
						ps.setString(1,"%"+keyword+"%");
				}else {
				 sql = "select count(*) from books_user";
				ps=conn.prepareStatement(sql);
				}
				rs=ps.executeQuery();
				while(rs.next()) {
					 arr[0]= rs.getInt(1);
					 
					 if(arr[0]%count==0){
						 arr[1] = arr[0]/count;
					 }else{
						 arr[1] = arr[0]/count+1;
					 }
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				Basedao.closeall(rs, ps, conn);
			}
	
		
		return arr;
	}
	
	public static ArrayList<booksShare_user> selectAll(int cpage,int count,String keyword){
		ArrayList<booksShare_user> list = new ArrayList<booksShare_user>();
		
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		try {
			String sql="";
			if(keyword!=null) {
				sql = "select * from books_user where user_name like ? order by user_birthday desc limit ?,?";
				ps = conn.prepareStatement(sql);
				ps.setString(1,"%"+keyword+"%");
				ps.setInt(2, (cpage-1)*count);
				ps.setInt(3, count);
			}else {
				sql = "select * from books_user order by user_birthday desc limit ?,?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, (cpage-1)*count);
				ps.setInt(2, count);
			}
			
			rs=ps.executeQuery();
			while(rs.next()) {
				booksShare_user u= new booksShare_user(
						rs.getString("user_id"),
					 	rs.getString("user_name"),
					 	rs.getString("user_password"),
					 	rs.getString("user_sex"),
					 	rs.getString("user_birthday"),
					 	rs.getString("user_id_code"),
					 	rs.getString("user_email"),
					 	rs.getString("user_mobile"),
					 	rs.getString("user_address"),
					 	rs.getInt("user_status")
						);
				
				list.add(u);
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
	 * 通过id查找用户
	 */
	public static booksShare_user selectById (String id){
		
		booksShare_user u=null;
		
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		try {
			String sql="select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')birthday from books_user m where user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);		
			
			rs=ps.executeQuery();
			
			
			while(rs.next()) {
				u= new booksShare_user(
						rs.getString("user_id"),
					 	rs.getString("user_name"),
					 	rs.getString("user_password"),
					 	rs.getString("user_sex"),
					 	rs.getString("birthday"),
					 	rs.getString("user_id_code"),
					 	rs.getString("user_email"),
					 	rs.getString("user_mobile"),
					 	rs.getString("user_address"),
					 	rs.getInt("user_status")
						);			
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return u;	
	}
	/*
	 * 通过查找用户名和密码实现登录
	 */
	public static int selectByNM(String name, String pwd){
		int count =0; 
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(*) from books_user where user_id=? and user_password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
		    rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 count = rs.getInt(1);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return count;
	}
	/*
	 * 通过用户名，密码查询用户信息
	 */
	public static booksShare_user selectAdmin(String name,String pwd) {
		booksShare_user u=null;
		
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		try {
			String sql="select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')birthday  from books_user m where user_id=? and user_password=?";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, name);
			 ps.setString(2, pwd);
			 
			 rs = ps.executeQuery();
			
			while(rs.next()) {
				u= new booksShare_user(
						rs.getString("user_id"),
					 	rs.getString("user_name"),
					 	rs.getString("user_password"),
					 	rs.getString("user_sex"),
					 	rs.getString("birthday"),
					 	rs.getString("user_id_code"),
					 	rs.getString("user_email"),
					 	rs.getString("user_mobile"),
					 	rs.getString("user_address"),
					 	rs.getInt("user_status")
						);			
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return u;
	}
}
