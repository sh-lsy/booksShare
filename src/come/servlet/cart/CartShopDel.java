package come.servlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.books_cartDao;

/**
 * Servlet implementation class CartShopDel
 */
@WebServlet("/cartshopdel")
public class CartShopDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String esid = request.getParameter("esid");
		books_cartDao.getDeleteDD(Integer.parseInt(esid));
	}

}
