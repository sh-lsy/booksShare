package com.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.books;
import com.entity.booksShare_category;
import com.service.booksDao;
import com.service.books_categoryDao;

/**
 * Servlet implementation class SelectBooksView
 */
@WebServlet("/selectbooksview")
public class SelectBooksView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<booksShare_category> flist =  books_categoryDao.selectCate("father");
		request.setAttribute("flist", flist);
		
		ArrayList<booksShare_category> clist =  books_categoryDao.selectCate("child");
		request.setAttribute("clist", clist);
		String id = request.getParameter("id");
		//获取最近访问
		
		HttpSession session = request.getSession();		
	   //从SSESSIOn获取一下 ids
		
		ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
		if(ids == null){
			ids = new ArrayList<Integer>();
		}
		//最多放5， 如果多出10个将第一个删除
		if(ids.size() >= 10) {
			ids.remove(0);
		}		
		// 添加列表里，不重复
		if(id!=null && (!ids.contains(Integer.parseInt(id)))) {
			ids.add(Integer.parseInt(id));
				
		}		
		session.setAttribute("ids", ids);
				
		ids= (ArrayList<Integer>)session.getAttribute("ids");
		if(ids!=null) {
			ArrayList<books> lastlylist = booksDao.selectAllById(ids);
			request.setAttribute("lastlylist", lastlylist);
		}
		
		books b = null;
		if(id !=null) {
			b = booksDao.selectById(Integer.parseInt(id));
			request.setAttribute("b", b);
		}
		
		
		if(b !=null) {
			int cid = b.getBooks_cid();
			ArrayList<books> classlist = booksDao.selectByCid(cid);
			request.setAttribute("classlist", classlist);
			
			booksShare_category cate = books_categoryDao.selectById(cid);
			
			request.setAttribute("cate", cate);
		}
		
		request.getRequestDispatcher("booksView.jsp").forward(request, response);
	}


}
