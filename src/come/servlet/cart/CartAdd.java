package come.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.books;
import com.entity.booksShare_user;
import com.entity.books_cart;
import com.service.booksDao;
import com.service.books_cartDao;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/cartadd")
public class CartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		books b= null;
		String bid = request.getParameter("id");
		String des = request.getParameter("des");
		String count = request.getParameter("count");
		String url = request.getParameter("url");
		
		HttpSession session =  request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		booksShare_user user = (booksShare_user)session.getAttribute("name");
		
			if(user!=null && isLogin.equals("1")) {
				
				String uid = (String)user.getUser_id();
				
				//通过用户ID和购物车中的商品ID 查看有没有这条记录
				
				books_cart srcbooks = books_cartDao.getCartShop(uid, bid);
				
				if(srcbooks != null) {
					int srccount = srcbooks.getCart_quantity();
					
					int newcount = srccount + Integer.parseInt(count);
					
					if(newcount >=5) {
						newcount =5;
					}
					
					books_cartDao.updatenum(srcbooks.getCart_id(), newcount);
				}else {
				if(bid !=null) {
					b = booksDao.selectById(Integer.parseInt(bid));
				}
				books_cart cart =new books_cart(
						0,
						b.getBooks_filename(),
						b.getBooks_name(),
						b.getBooks_description(),
						b.getBooks_user(),
						Integer.parseInt(count),
						b.getBooks_stock(),
						b.getBooks_id(),
						uid,
						1
						);
				books_cartDao.insert(cart);
				}
			   }else {
				PrintWriter out = response.getWriter();
				
				out.write("<script>");
				out.write("alert('请登录后，在享用');");
				out.write("location.href='login.jsp';");
				out.write("</script>");
				out.close();
				return;
			}
			if(url.equals("z")) {
				response.sendRedirect("showcart");
			}else{
				response.sendRedirect("selectbooksview?id="+bid);
			}
	}
	
	

}
