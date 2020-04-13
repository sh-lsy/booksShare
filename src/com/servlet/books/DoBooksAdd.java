package com.servlet.books;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.books;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.service.booksDao;

/**
 * Servlet implementation class DoBooksAdd
 */
@WebServlet("/manage/admin_dobooksadd")
public class DoBooksAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建SmartUpload对象
		SmartUpload su= new SmartUpload();
		
		//初使化
		su.initialize(this.getServletConfig(), request, response);
		
		//上传过程
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取上传的文件对象
		Files fs= su.getFiles();
		File f = fs.getFile(0);
		//获取上传的文件名称
		String fname = f.getFileName();
		
		try {
			su.save("img//books");
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Request req1 = su.getRequest();
		
		String bname = req1.getParameter("booksName");
		String id = req1.getParameter("parentId");
		String buser = req1.getParameter("booksUser");
		String desc = req1.getParameter("booksDesc");
		String stock = req1.getParameter("booksStock");
		
		books b = new books(
						0,
						bname,
						desc,
						Integer.parseInt(stock),
						buser,
						Integer.parseInt(id.split("-")[0]),
						Integer.parseInt(id.split("-")[1]),
						fname
				);
				
		int count = booksDao.insert(b);
		
		//成功或失败重定向到哪里
		
				if(count >0 ) {
					
					response.sendRedirect("admin_booksselect");
				} else {
					PrintWriter out = response.getWriter();
					
					out.write("<script>");
					out.write("alert('图书添加失败');");
					out.write("location.href='manage/admin_tobooksadd';");
					out.write("</script>");
					
				}

	}
}
