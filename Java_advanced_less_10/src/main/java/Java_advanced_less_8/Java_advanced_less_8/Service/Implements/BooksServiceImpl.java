package Java_advanced_less_8.Java_advanced_less_8.Service.Implements;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import Java_advanced_less_8.Java_advanced_less_8.Dao.BooksDao;
import Java_advanced_less_8.Java_advanced_less_8.Dao.Implements.BooksDaoImpl;
import Java_advanced_less_8.Java_advanced_less_8.Service.BooksService;
import Java_advanced_less_8.Java_advanced_less_8.Shop.Books;
import Java_advanced_less_8.Java_advanced_less_8.projectServlet.Products;

public class BooksServiceImpl implements BooksService {

	private static Logger LOG = Logger.getLogger(BooksServiceImpl.class);
	private static BooksService booksServiceImpl;
	private BooksDao booksDao;

	private BooksServiceImpl() {

		try {
			booksDao = new BooksDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOG.error(e);
		}

	}

	public static BooksService getBooksService() {

		if (booksServiceImpl == null) {
			booksServiceImpl = new BooksServiceImpl();
		}
		return booksServiceImpl;
	}

	@Override
	public Books create(Books t) {

		return booksDao.create(t);
	}

	@Override
	public Books read(Integer id) {

		return booksDao.read(id);
	}

	@Override
	public Books update(Books t) {

		return booksDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		booksDao.delete(id);

	}

	@Override
	public List<Books> readAll() {

		return booksDao.readAll();
	}
	
	@Override
	public Map<Integer, Books> readAllMap() {
		return  readAll().stream().collect(Collectors.toMap(Books::getId, Function.identity()));
	}

}
