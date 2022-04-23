package Java_advanced_less_8.Java_advanced_less_8.projectServlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Java_advanced_less_8.Java_advanced_less_8.Dto.BucketDto;
import Java_advanced_less_8.Java_advanced_less_8.Service.BooksService;
import Java_advanced_less_8.Java_advanced_less_8.Service.SallingService;
import Java_advanced_less_8.Java_advanced_less_8.Service.Implements.BooksServiceImpl;
import Java_advanced_less_8.Java_advanced_less_8.Service.Implements.SallingServiceImpl;
import Java_advanced_less_8.Java_advanced_less_8.Shop.Books;
import Java_advanced_less_8.Java_advanced_less_8.Shop.Salling;

/**
 * Servlet implementation class BucketsController
 */
@WebServlet("/buckets")
public class BucketsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SallingService sallingService = SallingServiceImpl.getSallingService();
    private BooksService booksService = BooksServiceImpl.getBooksService();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Salling> salling = sallingService.readAll();
		Map<Integer, Books> idToProduct = booksService.readAllMap();
		List<BucketDto> listOfBucketDtos = map(salling, idToProduct);
		
		String json = new Gson().toJson(listOfBucketDtos);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		
	}

	
	private List<BucketDto> map(List<Salling> salling, Map<Integer, Books> idToProduct) {

		return	salling.stream().map(sallings->{
			BucketDto bucketDto = new BucketDto();
			bucketDto.bucketId = sallings.getId();
			bucketDto.purchaseDate = sallings.getSalling_date();
		   
			Books books = idToProduct.get(sallings.getBook_id());
		    bucketDto.book = books.getBook();
		    bucketDto.author = books.getAuthor();
		    bucketDto.ganre = books.getGanre();
		    bucketDto.cod = books.getCod();
		    bucketDto.price = books.getPrice();
			
			return bucketDto;
		}).collect(Collectors.toList());

	}


}
