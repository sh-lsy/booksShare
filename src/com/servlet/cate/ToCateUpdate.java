package com.servlet.cate;

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
 * Servlet implementation class ToCateUpdate
 */
@WebServlet("/manage/admin_tocateupdate")
public class ToCateUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		booksShare_category cate = books_categoryDao.selectById(id);
		ArrayList<booksShare_category> catelist=books_categoryDao.selectAll();
		request.setAttribute("catelist", catelist);
		request.setAttribute("cate1", cate);
		request.getRequestDispatcher("admin_catemodify.jsp").forward(request, response);
	}


}
