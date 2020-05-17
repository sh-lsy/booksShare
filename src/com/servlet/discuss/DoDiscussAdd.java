package com.servlet.discuss;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.books_discuss;
import com.service.books_discussDao;



/**
 * Servlet implementation class ToDiscussAdd
 */
@WebServlet("/manage/admin_dodiscussadd")
public class DoDiscussAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String time= request.getParameter("time");
		String uid= request.getParameter("u_id");
		String uname= request.getParameter("u_name");
		String cvalue= request.getParameter("cvalue");
		int fid=0;
		books_discuss discuss=new books_discuss(0,cvalue,fid,uid,uname,time);
		
		books_discussDao.insert(discuss);
		response.sendRedirect("admin_discuss.jsp");
	}



}
