package com.servlet.discuss;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.books_discuss;
import com.service.books_discussDao;

/**
 * Servlet implementation class UserDiscussSelect
 */
@WebServlet("/userdiscussselect")
public class UserDiscussSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=0;
		ArrayList<books_discuss> udiscusslist = books_discussDao.selectBypid(pid);
	
		request.setAttribute("udiscusslist", udiscusslist);
		request.getRequestDispatcher("discuss.jsp").forward(request, response);
	}


}
