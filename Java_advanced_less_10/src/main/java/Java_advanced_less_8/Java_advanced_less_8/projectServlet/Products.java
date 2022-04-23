package Java_advanced_less_8.Java_advanced_less_8.projectServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Java_advanced_less_8.Java_advanced_less_8.Service.BooksService;
import Java_advanced_less_8.Java_advanced_less_8.Service.Implements.BooksServiceImpl;
import Java_advanced_less_8.Java_advanced_less_8.Shop.Books;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private BooksService booksService = BooksServiceImpl.getBooksService();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Books> books = booksService.readAll();
		String json = new Gson().toJson(books);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	

}
