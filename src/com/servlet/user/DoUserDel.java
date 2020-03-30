package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.service.userDao;

/**
 * Servlet implementation class DoUserDel
 */
@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id= request.getParameter("id");
	
		//加入到数据库的用户表中
		int count = userDao.del(id);
		

		//成功或失败重定向到哪里
		
		if(count >0 ) {
			
			response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户删除失败');");
			out.write("location.href='manage/admin_douserselect?cp="+request.getParameter("cpage")+"';");
			out.write("</script>");
			
		}
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String ids[]= request.getParameterValues("id[]");
	
		//加入到数据库的用户表中
		for(int i=0;i<ids.length;i++) {
		userDao.del(ids[i]);
		}
		response.sendRedirect("/booksShare/manage/admin_douserselect");
	
	}
}
