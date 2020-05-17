package com.servlet.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.booksShare_user;
import com.entity.books_order;
import com.entity.order;
import com.service.books_orderDao;
import com.service.userDao;

/**
 * Servlet implementation class Admin_OrderSelect
 */
@WebServlet("/manage/admin_doorderselect")
public class Admin_OrderSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//设置分页信息
				int cpage=1;
				int count=6;
				String cp=request.getParameter("cp");
				String vaild=request.getParameter("vaild");
				//接受用户搜索关键字
				String keyword=request.getParameter("keywords");
				if(cp !=null) {
					cpage=Integer.parseInt(cp);
				}
				int arr[]=books_orderDao.totalPage(count,keyword,vaild);
				
				
				//获取所有用户信息
				ArrayList<order> nolist = books_orderDao.selectNoAll(cpage,count,keyword,vaild);
				ArrayList<books_order> orderlist = books_orderDao.selectAll();
				request.setAttribute("nolist", nolist);
				request.setAttribute("orderlist", orderlist);
				request.setAttribute("tsum", arr[0]);
				request.setAttribute("tpage", arr[1]);
				request.setAttribute("cpage", cpage);
				
				if(keyword!=null) {
					request.setAttribute("searchParms", "&keywords="+keyword);
				}
				if(vaild!=null) {
					request.getRequestDispatcher("admin_order.jsp").forward(request, response);
				}else {
				request.getRequestDispatcher("admin_order.jsp").forward(request, response);
				}
			}
	
}
