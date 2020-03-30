package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.booksShare_user;
import com.service.userDao;

/**
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String userStatus  = request.getParameter("userStatus");
		
		int status = 1;
		if(userStatus != null) {
			status = Integer.parseInt(userStatus);
		}
		
		booksShare_user user=new booksShare_user(username, name, pwd, sex, birthday, null, email, mobile, address, status);
			
		//加入到数据库中
		int count=userDao.update(user);
			//		判断是否添加成功
			if(count>0) {
			response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
		} else {
	PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户修改失败');");
			out.write("location.href='manage/admin_touserupdate?id="+username+"';");
			out.write("</script>");
			
			
		}
		
	
	}

}
