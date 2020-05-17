package com.servlet.userDo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.booksShare_user;

/**
 * Servlet implementation class tomygrxx
 */
@WebServlet("/tomygrxx")
public class tomygrxx extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session =  request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		booksShare_user user = (booksShare_user)session.getAttribute("name");
		
		if(user!=null && isLogin.equals("1")) {
			request.getRequestDispatcher("mygrxx.jsp").forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('请登录后，在查看');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
		}
	}



}
