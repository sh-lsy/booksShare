package com.servlet.discuss;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.books_discuss;
import com.service.books_discussDao;

/**
 * Servlet implementation class ToCdiscuss
 */
@WebServlet("/manage/admin_tocdiscuss")
public class ToCdiscuss extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int pid = Integer.parseInt(request.getParameter("pid"));
		ArrayList<books_discuss> cdiscusslist = books_discussDao.selectBypid(pid);
		if( cdiscusslist != null) {
		request.setAttribute("discusslist", cdiscusslist);
		
		request.getRequestDispatcher("admin_cdiscuss.jsp").forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户添加失败');");
			out.write("location.href='manage/admin_useradd.jsp';");
			out.write("</script>");
		}
	}


}
