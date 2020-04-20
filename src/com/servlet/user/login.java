package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.booksShare_user;
import com.service.userDao;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {

   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("password");
		
		int count = userDao.selectByNM(userName, passWord);
		
		if(count > 0) {
			HttpSession session = request.getSession();
			booksShare_user user=userDao.selectAdmin(userName,passWord);
			
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");
			response.sendRedirect("indexselect");
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户登录失败！');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
		}
	}

}
