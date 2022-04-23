package Java_advanced_less_8.Java_advanced_less_8.projectServlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Java_advanced_less_8.Java_advanced_less_8.Service.SallingService;
import Java_advanced_less_8.Java_advanced_less_8.Service.Implements.SallingServiceImpl;
import Java_advanced_less_8.Java_advanced_less_8.Shop.Salling;

/**
 * Servlet implementation class SallingController
 */
@WebServlet("/salling")
public class BucketController extends HttpServlet {
	
	private SallingService sallingService = SallingServiceImpl.getSallingService();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String book_id = request.getParameter("book_id");
		HttpSession session = request.getSession();
		Integer user_id = (Integer)session.getAttribute("user_id");
		
		Salling salling = new Salling (user_id, Integer.parseInt(book_id), true, new Date(), 5);
		sallingService.create(salling);
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
   
	@Override
		protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bucketId = request.getParameter("bucketId");
		sallingService.delete(Integer.parseInt(bucketId));
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
		}
}
