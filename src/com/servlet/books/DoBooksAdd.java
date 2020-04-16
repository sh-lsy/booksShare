package com.servlet.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.catalina.tribes.UniqueId;

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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//创建SmartUpload对象
		SmartUpload su= new SmartUpload();
		
		//初使化
		su.initialize(this.getServletConfig(), request, response);
		su.setMaxFileSize(1024*1024*10);
		su.setTotalMaxFileSize(1024*1024*100);
		su.setAllowedFilesList("jpg,gif,jpeg,png");
		//上传过程
		try {
			su.upload();
		} catch (ServletException | IOException | SmartUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//获取上传的文件对象
		Files fs= su.getFiles();
		File f = fs.getFile(0);
		File f1 = fs.getFile(1);
		File f2 = fs.getFile(2);
		//获取上传的文件名称
		String fname = f.getFileName();
		String fname1 = f1.getFileName();
		String fname2 = f2.getFileName();
		fname=UUID.randomUUID().toString()+"."+f.getFileExt();
		fname1=UUID.randomUUID().toString()+"."+f1.getFileExt();
		fname2=UUID.randomUUID().toString()+"."+f2.getFileExt();
		try {  
			f.saveAs("E:\\MyJava\\apache-tomcat-9.0.11\\webapps\\img\\"+fname);
			f1.saveAs("E:\\MyJava\\apache-tomcat-9.0.11\\webapps\\img\\"+fname1);
			f2.saveAs("E:\\MyJava\\apache-tomcat-9.0.11\\webapps\\img\\"+fname2);
		} catch (IOException | SmartUploadException e) {
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
						fname,
						fname1,
						fname2
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
