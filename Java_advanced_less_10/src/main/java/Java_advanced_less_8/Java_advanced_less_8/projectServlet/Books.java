package Java_advanced_less_8.Java_advanced_less_8.projectServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Java_advanced_less_8.Java_advanced_less_8.Service.BooksService;
import Java_advanced_less_8.Java_advanced_less_8.Service.Implements.BooksServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private BooksService booksService = BooksServiceImpl.getBooksService();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}
