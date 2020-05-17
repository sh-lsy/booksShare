package com.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.booksShare_user;
import com.service.userDao;

/**
 *查询
 */
@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置分页信息
		int cpage=1;
		int count=6;
		String cp=request.getParameter("cp");
		//接受用户搜索关键字
		String keyword=request.getParameter("keywords");
		if(cp !=null) {
			cpage=Integer.parseInt(cp);
		}
		int arr[]=userDao.totalPage(count,keyword);
		
		
		//获取所有用户信息
		
		ArrayList<booksShare_user> list=userDao.selectAll(cpage,count,keyword);
		
		
		
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		
		if(keyword!=null) {
			request.setAttribute("searchParms", "&keywords="+keyword);
		}
		
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
	}


}
