package com.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.books_orderDao;

/**
 * Servlet implementation class FinishOrder
 */
@WebServlet("/finishorder")
public class FinishOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		int valid = 2;
		books_orderDao.updatevalid(valid, no);	
		 request.getRequestDispatcher("/userorderselect").forward(request, response);
	}



}
