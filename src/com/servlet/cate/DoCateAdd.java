package com.servlet.cate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.booksShare_category;
import com.service.books_categoryDao;

/**
 * Servlet implementation class DoCateAdd
 */
@WebServlet("/manage/admin_docateadd")
public class DoCateAdd extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int fid = Integer.parseInt(request.getParameter("parentId"));
		String name = request.getParameter("className");
		booksShare_category cate=new booksShare_category(0,name,fid);
		books_categoryDao.insert(cate);
		response.sendRedirect("admin_cateselect");
	}

}
