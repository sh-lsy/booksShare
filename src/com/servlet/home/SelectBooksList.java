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
 * Servlet implementation class SelectProductList
 */
@WebServlet("/selectproductlist")
public class SelectBooksList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<booksShare_category> flist =  books_categoryDao.selectCate("father");
		request.setAttribute("flist", flist);
		
		ArrayList<booksShare_category> clist =  books_categoryDao.selectCate("child");
		request.setAttribute("clist", clist);
		String fid = request.getParameter("fid");
		String cid = request.getParameter("cid");
		
		int id=0;
		ArrayList<books> list = null;
		if(fid!=null) {
			id=Integer.parseInt(fid);
			list=booksDao.selectByFid(id);
		}
		
		if(cid!=null) {
			id=Integer.parseInt(cid);
			list=booksDao.selectByCid(id);
		}
		
		request.setAttribute("title", books_categoryDao.selectById(id).getCate_name());
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("bookslist.jsp").forward(request, response);
	}

}
