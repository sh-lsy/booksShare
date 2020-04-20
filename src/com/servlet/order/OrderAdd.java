package com.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.booksShare_user;
import com.entity.books_cart;
import com.entity.books_order;
import com.service.books_cartDao;
import com.service.books_orderDao;

/**
 * Servlet implementation class orderadd
 */
@WebServlet("/orderadd")
public class OrderAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session =  request.getSession();
		
		String way = request.getParameter("way");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		
		String isLogin = (String)session.getAttribute("isLogin");
		booksShare_user user = (booksShare_user)session.getAttribute("name");
		
		String rids = request.getParameter("rids");
		books_cart es = null;
			if(user!=null && isLogin.equals("1")) {

				String oids[] = rids.split(",");
				
//				ArrayList<books_order> list= new ArrayList<books_order>();
				
				for(int i=0; i<oids.length; i++) {
					 es = books_cartDao.getCartShop(oids[i]);
					books_order order =new books_order(
							0,
							time,
							date,
							es.getCart_b_filename(),
							es.getCart_b_name(),
					        es.getCart_b_user(),
							es.getCart_quantity(),
							es.getCart_b_id(),
							way,
							es.getCart_u_id(),
							1
							);
					books_orderDao.insert(order);
					books_cartDao.getDeleteDD(Integer.parseInt(oids[i]));
			}
				request.getRequestDispatcher("ok.jsp").forward(request, response);
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
