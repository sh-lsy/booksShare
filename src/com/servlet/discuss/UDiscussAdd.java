package com.servlet.discuss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.booksShare_user;
import com.entity.books_discuss;
import com.service.books_discussDao;


/**
 * Servlet implementation class UDiscussAdd
 */
@WebServlet("/udiscussadd")
public class UDiscussAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session =  request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		booksShare_user user = (booksShare_user)session.getAttribute("name");
		
		if(user!=null && isLogin.equals("1")) {
			String pid= request.getParameter("pid");
			int fid= Integer.parseInt(request.getParameter("pid"));
			String time= request.getParameter("time");
			String uid= request.getParameter("u_id");
			String uname= request.getParameter("u_name");
			String cvalue= request.getParameter("cvalue");
		
			books_discuss discuss=new books_discuss(0,cvalue,fid,uid,uname,time);
			
			books_discussDao.insert(discuss);
			if(fid == 0) {
				response.sendRedirect("userdiscussselect");
			}else {
				
				response.sendRedirect("utocdisscuss?pid="+pid+"");
			}
			
		}else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('请登录后，在享用');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
		}
	}
	

}
