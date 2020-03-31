package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.Basedao;
import com.entity.booksShare_category;
import com.entity.booksShare_user;

public class books_categoryDao {
	/*
	 * 添加分类
	 */
	public static int insert(booksShare_category cate) {
		String sql = "insert into books_category values(null, ?, ?)";
		
		Object[] params = {
				cate.getCate_name(),
				cate.getCate_parent_id()
				};

		return Basedao.exectuIUD(sql, params);
	}
	/*
	 * 查询
	 */
	public static ArrayList<booksShare_category> selectAll(){
		ArrayList<booksShare_category> list = new ArrayList<booksShare_category>();
		
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		try {
			String sql="select * from books_category";
				ps = conn.prepareStatement(sql);
				rs=ps.executeQuery();
			while(rs.next()) {
				booksShare_category cate= new booksShare_category(
						rs.getInt("cate_id"),
					 	rs.getString("cate_name"),
					 	rs.getInt("cate_parent_id")
						);
				list.add(cate);
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
	 * 通过id查询
	 */
public static booksShare_category selectById (int id){
		
	booksShare_category cate=null;
		
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		try {
			String sql="select * from books_category  where cate_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);		
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				cate= new booksShare_category(
					 rs.getInt("cate_id"),
					 rs.getString("cate_name"),
					 rs.getInt("cate_parent_id")
						);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return cate;	
	}
		/*
		 * 提交修改后信息
		 */
		public static int update(booksShare_category cate) {
			String sql = "update books_category set cate_name=?,cate_parent_id=? where cate_id=?";
			Object[] params = {
					cate.getCate_name(),
					cate.getCate_parent_id(),
					cate.getCate_id()
			};
			return Basedao.exectuIUD(sql, params);
		}
}
