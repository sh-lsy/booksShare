package com.servlet.books;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.books;
import com.service.booksDao;

/**
 * Servlet implementation class booksSelect
 */
@WebServlet("/manage/admin_booksselect")
public class booksSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booksSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<books>  blist = booksDao.selectAll();
		request.setAttribute("blist", blist);
		request.getRequestDispatcher("admin_books.jsp").forward(request, response);
	}

	

}
