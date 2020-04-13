package com.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.booksShare_category;
import com.service.books_categoryDao;



/**
 * Servlet implementation class IndexSelect
 */
@WebServlet("/indexselect")
public class IndexSelect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<booksShare_category> flist =  books_categoryDao.selectCate("father");
		request.setAttribute("flist", flist);
		
		ArrayList<booksShare_category> clist =  books_categoryDao.selectCate("child");
		request.setAttribute("clist", clist);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}



}
