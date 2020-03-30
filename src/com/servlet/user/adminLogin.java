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
 * Servlet implementation class adminLogin
 */
@WebServlet("/manage/adminLogin")
public class adminLogin extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("password");
		
		int count = userDao.selectByNM(userName, passWord);
		
		if(count > 0) {
			booksShare_user user=userDao.selectAdmin(userName,passWord);
			
			HttpSession session = request.getSession();
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");
			if(user.getUser_status()==2) {
				session.setAttribute("isAdminLogin", "1");
				response.sendRedirect("/booksShare/manage/admin_index.jsp");
			}else {
				response.sendRedirect("/booksShare/index.jsp");
			}
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
