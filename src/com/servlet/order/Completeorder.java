package com.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.books_orderDao;

/**
 * Servlet implementation class Completeorder
 */
@WebServlet("/manage/admin_completeorder")
public class Completeorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String no = request.getParameter("id");
		
		int v=books_orderDao.selectByno(no);
		
		if(v == 1) {
			int valid = 2;
			books_orderDao.updatevalid(valid, no);
		}else {
			int valid = 3;
			books_orderDao.updatevalid(valid, no);
			
		}
		
		
		
		request.getRequestDispatcher("admin_doorderselect?cp="+request.getParameter("cpage")).forward(request, response);
	}



}
