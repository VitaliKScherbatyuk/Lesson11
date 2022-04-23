package Java_advanced_less_8.Java_advanced_less_8.Dao.Implements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import Java_advanced_less_8.Java_advanced_less_8.Dao.UserDao;
import Java_advanced_less_8.Java_advanced_less_8.Shop.User;
import Java_advanced_less_8.Java_advanced_less_8.Utills.ConnectionUtils;

public class UserDaoImpl implements UserDao{
	
	private static String READ_ALL = "select * from user";
	private static String CREATE = "insert into user(`email`,`firstName`, `surName`, `password`, `status` ) values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from user where id =?";
	private static String READ_BY_EMAIL = "select * from user where email =?";
	private static String UPDATE_BY_ID = "update user set email=?, firstName = ?, surName = ?, password=?, status=?  where id = ?";
	private static String DELETE_BY_ID = "delete from user where id=?";
	
	private static Logger LOG = Logger.getLogger(UserDaoImpl.class);
	private Connection connection;
	private PreparedStatement preparedStatement;

	public UserDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public User create(User user) {
		
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getSurName());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getStatus());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			user.setId(rs.getInt(1));
		} catch (SQLException e) {
			LOG.error(e);
		}

		return user;
		
	}

	@Override
	public User read(Integer id) {
		
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer userId = result.getInt("id");
			String email = result.getString("email");
			String firstName = result.getString("firstName");
			String surName = result.getString("surName");
			String password = result.getString("password");
			String status = result.getString("status");
			
			user = new User(userId, email, firstName, surName, password, status);

		} catch (SQLException e) {
			LOG.error(e);
		}

		return user;

	}

	@Override
	public User update(User user) {
		
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1,user.getEmail() );
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getSurName());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getStatus());
			preparedStatement.setInt(6, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.error(e);
		}

		return user;
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
	public List<User> readAll() {
		
		List<User> userRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer userId = result.getInt("id");
				String email = result.getString("email");
				String firstName = result.getString("firstName");
				String surName = result.getString("surName");
				String password = result.getString("password");
				String status = result.getString("status");			
				
				userRecords.add(new User(userId, email, firstName, surName, password, status));
			}
		} catch (SQLException e) {
			LOG.error(e);
		}

		return userRecords;
	}

	@Override
	public User getUserByEmail(String email) {

		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
			preparedStatement.setString(1, email);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer userId = result.getInt("id");
			String firstName = result.getString("firstName");
			String surName = result.getString("surName");
			String password = result.getString("password");
			String status = result.getString("status");
			
			user = new User(userId, email, firstName, surName, password, status);

		} catch (SQLException e) {
			LOG.error(e);
		}

		return user;
	}

}
