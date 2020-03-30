package com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.booksShare_user;
import com.service.userDao;

/**
 * Servlet implementation class UserNameCheck
 */
@WebServlet("/servletJqAjax")
public class UserNameCheck extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("userName");
		
		int count=userDao.selectByusername(username);
		 String msg="";
		if(count>0) {
			msg="用户名已被注册";
		}else {
			msg="此用户可用";
		}
		 response.getWriter().print(msg);
	}

}
