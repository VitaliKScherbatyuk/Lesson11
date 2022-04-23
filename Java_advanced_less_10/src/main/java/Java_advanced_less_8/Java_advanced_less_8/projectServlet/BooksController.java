package Java_advanced_less_8.Java_advanced_less_8.projectServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Java_advanced_less_8.Java_advanced_less_8.Dao.Implements.BooksDaoImpl;
import Java_advanced_less_8.Java_advanced_less_8.Service.BooksService;
import Java_advanced_less_8.Java_advanced_less_8.Service.Implements.BooksServiceImpl;
import Java_advanced_less_8.Java_advanced_less_8.Shop.Books;

@WebServlet("/books")
public class BooksController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BooksService booksService = BooksServiceImpl.getBooksService();

	// to create resource (product)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String book = request.getParameter("book");
		String author = request.getParameter("author");
		String ganre = request.getParameter("ganre");
		String price = request.getParameter("price");
		String cod = request.getParameter("cod");

		Books books = new Books(book, author, ganre, getValidatedPrice(price), getValidatedInt(cod));
		booksService.create(books);
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

	private double getValidatedPrice(String price) {
		if (price == null || price.isEmpty()) {
			return 0;
		}
		return Double.parseDouble(price);
	}

	private int getValidatedInt(String cod) {
		if (cod == null || cod.isEmpty()) {
			return 0;
		}
		return Integer.parseInt(cod);
	}

	// to get resource (product)
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookId = request.getParameter("id");

		Books book = booksService.read(Integer.parseInt(bookId));

		request.setAttribute("product", book);
		request.getRequestDispatcher("singleProduct.jsp").forward(request, response);
	}

	// to update resource (product)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPut(req, resp);
	}

	// to delete resource (product)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doDelete(req, resp);
	}

}
