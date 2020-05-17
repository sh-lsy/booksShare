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
 * Servlet implementation class DiscussSelect
 */
@WebServlet("/manage/admin_discussselect")
public class DiscussSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=0;
		ArrayList<books_discuss> discusslist = books_discussDao.selectBypid(pid);
	
		request.setAttribute("discusslist", discusslist);
		request.getRequestDispatcher("admin_discuss.jsp").forward(request, response);
	}



}
