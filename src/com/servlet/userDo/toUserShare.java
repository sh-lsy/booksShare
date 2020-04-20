package com.servlet.userDo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.booksShare_category;
import com.entity.booksShare_user;
import com.service.books_categoryDao;

/**
 * Servlet implementation class toUserShare
 */
@WebServlet("/tobooksShare")
public class toUserShare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session =  request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		booksShare_user user = (booksShare_user)session.getAttribute("name");

			if(user!=null && isLogin.equals("1")) {
				ArrayList<booksShare_category> flist =  books_categoryDao.selectCate("father");
				request.setAttribute("flist", flist);
				
				ArrayList<booksShare_category> clist =  books_categoryDao.selectCate("child");
				request.setAttribute("clist", clist);
				request.getRequestDispatcher("sharebooks.jsp").forward(request, response);
			}else {
				PrintWriter out = response.getWriter();
				
				out.write("<script>");
				out.write("alert('请登录后，在共享');");
				out.write("location.href='login.jsp';");
				out.write("</script>");
				out.close();
			}
		
		
	}


}
