package com.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.books;
import com.entity.booksShare_category;
import com.service.booksDao;
import com.service.books_categoryDao;



/**
 * Servlet implementation class IndexSelect
 */
@WebServlet("/indexselect")
public class IndexSelect extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<booksShare_category> flist =  books_categoryDao.selectCate("father");
		request.setAttribute("flist", flist);
		
		ArrayList<booksShare_category> clist =  books_categoryDao.selectCate("child");
		request.setAttribute("clist", clist);
		
		int id1=39;
		ArrayList<books> list1 = null;
		
		list1=booksDao.selectByCid(id1);
		
		request.setAttribute("list1", list1);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}



}
