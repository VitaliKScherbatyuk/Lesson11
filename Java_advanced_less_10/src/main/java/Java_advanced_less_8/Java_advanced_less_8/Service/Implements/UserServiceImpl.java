package Java_advanced_less_8.Java_advanced_less_8.Service.Implements;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import Java_advanced_less_8.Java_advanced_less_8.Dao.UserDao;
import Java_advanced_less_8.Java_advanced_less_8.Dao.Implements.UserDaoImpl;
import Java_advanced_less_8.Java_advanced_less_8.Service.UserService;
import Java_advanced_less_8.Java_advanced_less_8.Shop.User;

public class UserServiceImpl implements UserService {

	private static Logger LOG = Logger.getLogger(UserServiceImpl.class);
	private static UserService userServiceImpl;
	private UserDao userDao;

	private UserServiceImpl() {
		try {
			userDao = new UserDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOG.error(e);
		}
	}
	
	public static UserService getUserService() {
		
		if(userServiceImpl==null) {
			userServiceImpl = new UserServiceImpl();
		}
		return userServiceImpl;
	}
	
	@Override
	public User create(User t) {
		
		return userDao.create(t);
	}

	@Override
	public User read(Integer id) {
	
		return userDao.read(id);
	}

	@Override
	public User update(User t) {
	
		return userDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		
		userDao.delete(id);
		
	}

	@Override
	public List<User> readAll() {
	
		return userDao.readAll();
	}

	@Override
	public User getUserByEmail(String email) {
		
		return userDao.getUserByEmail(email);
	}

}
