package com.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.userDao;

/**
 * Servlet implementation class UserNumCheck
 */
@WebServlet("/servletnum")
public class UserNumCheck extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String veryCode=request.getParameter("veryCode");

		HttpSession session = request.getSession();

		String mcode=(String)session.getAttribute("code");

		 String msg="";
		if(mcode.equals(veryCode)) {
			msg="验证成功";
		}else {
			msg="验证码错误";
		}
		 response.getWriter().print(msg);
	}

}


