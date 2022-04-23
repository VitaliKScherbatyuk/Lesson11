package Java_advanced_less_8.Java_advanced_less_8.Dao.Implements;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import Java_advanced_less_8.Java_advanced_less_8.Dao.SallingDao;
import Java_advanced_less_8.Java_advanced_less_8.Shop.Salling;
import Java_advanced_less_8.Java_advanced_less_8.Utills.ConnectionUtils;

public class SallingDaoImpl implements SallingDao{
	
	private static String READ_ALL = "select * from salling";
	private static String CREATE = "insert into salling(`user_id`, `book_id`, `salling_status`, `salling_date`, `salling_period`) "
			+ "values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from salling where id =?";
	private static String DELETE_BY_ID = "delete from salling where id=?";

	private static Logger LOG = Logger.getLogger(SallingDaoImpl.class);
	private Connection connection;
	private PreparedStatement preparedStatement;

	public SallingDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Salling create(Salling salling) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, salling.getUser_id());
			preparedStatement.setInt(2, salling.getBook_id());
			preparedStatement.setBoolean(3, salling.isSalling_status());
			preparedStatement.setDate(4, new Date(salling.getSalling_date().getTime()));
			preparedStatement.setInt(5, salling.getSalling_period());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			salling.setId(rs.getInt(1));
		} catch (SQLException e) {
			LOG.error(e);
		}

		return salling;
	}


	@Override
	public Salling read(Integer id) {
		
		Salling salling = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			
			Integer sallingId = result.getInt("id");
			Integer userId = result.getInt("user_id");
			Integer bookId = result.getInt("book_id");
			Boolean sallingStatus = result.getBoolean("salling_status");
			java.util.Date sallingDate = result.getDate("salling_date");
			Integer sallingPeriod = result.getInt("salling_period");
			salling = new Salling(sallingId, userId, bookId, sallingStatus, sallingDate, sallingPeriod);

		} catch (SQLException e) {
			LOG.error(e);
		}

		return salling;
	}

	@Override
	public Salling update(Salling t) {
		throw new IllegalStateException("Оновлення для продажі не передбачувано!");
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
	public List<Salling> readAll() {

		List<Salling> sallingsRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				
				Integer sallingId = result.getInt("id");
				Integer userId = result.getInt("user_id");
				Integer bookId = result.getInt("book_id");
				Boolean sallingStatus = result.getBoolean("salling_status");
				java.util.Date sallingDate = result.getDate("salling_date");
				Integer sallingPeriod = result.getInt("salling_period");
				sallingsRecords.add(new Salling(sallingId, userId, bookId, sallingStatus, sallingDate, sallingPeriod));
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		
		return sallingsRecords;
	}



}
