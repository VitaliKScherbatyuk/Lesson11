package Java_advanced_less_8.Java_advanced_less_8.Dao.Implements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import Java_advanced_less_8.Java_advanced_less_8.Dao.BooksDao;
import Java_advanced_less_8.Java_advanced_less_8.Shop.Books;
import Java_advanced_less_8.Java_advanced_less_8.Utills.ConnectionUtils;

public class BooksDaoImpl implements BooksDao {
	
	private static String READ_ALL = "select * from books";
	private static String CREATE = "insert into books(`book`, `author`, `ganre`, `price`, `cod`) values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from books where id =?";
	private static String UPDATE_BY_ID = "update books set name=?, author = ?, ganre = ?, price = ?, cod = ? where id = ?";
	private static String DELETE_BY_ID = "delete from books where id=?";

	private static Logger LOG = Logger.getLogger(BooksDaoImpl.class);
	private Connection connection;
	private PreparedStatement preparedStatement;

	public BooksDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Books create(Books books) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, books.getBook());
			preparedStatement.setString(2, books.getAuthor());
			preparedStatement.setString(3, books.getGanre());
			preparedStatement.setDouble(4, books.getPrice());
			preparedStatement.setInt(5, books.getCod());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			books.setId(rs.getInt(1));
		} catch (SQLException e) {
			LOG.error(e);
		}

		return books;
	}

	@Override
	public Books read(Integer id) {
		
		Books books = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer book_id = result.getInt("id");
			String book = result.getString("book");
			String author = result.getString("author");
			String ganre = result.getString("ganre");
			Double price = result.getDouble("price");
			Integer cod = result.getInt("cod");
			
			books = new Books(book_id, book, author, ganre, price, cod);

		} catch (SQLException e) {
			LOG.error(e);
		}

		return books;
	}

	@Override
	public Books update(Books books) {
		
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, books.getBook());
			preparedStatement.setString(2, books.getAuthor());
			preparedStatement.setString(3, books.getGanre());
			preparedStatement.setDouble(4, books.getPrice());
			preparedStatement.setInt(5, books.getCod());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.error(e);
		}

		return books;
	}

	@Override
	public void delete(Integer id) {
	
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.error(e);
		}
		
	}

	@Override
	public List<Books> readAll() {
		
		List<Books> booksRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {	
				
				Integer book_id = result.getInt("id");
				String book = result.getString("book");
				String author = result.getString("author");
				String ganre = result.getString("ganre");
				Double price = result.getDouble("price");
				Integer cod = result.getInt("cod");

				booksRecords.add(new Books(book_id, book, author, ganre, price, cod));
			}
		} catch (SQLException e) {
			LOG.error(e);
		}

		return booksRecords;
	}

}
