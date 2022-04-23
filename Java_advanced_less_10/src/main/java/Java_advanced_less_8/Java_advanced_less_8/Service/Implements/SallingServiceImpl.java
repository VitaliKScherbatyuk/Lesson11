package Java_advanced_less_8.Java_advanced_less_8.Service.Implements;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import Java_advanced_less_8.Java_advanced_less_8.Dao.SallingDao;
import Java_advanced_less_8.Java_advanced_less_8.Dao.Implements.SallingDaoImpl;
import Java_advanced_less_8.Java_advanced_less_8.Service.SallingService;
import Java_advanced_less_8.Java_advanced_less_8.Shop.Salling;

public class SallingServiceImpl implements SallingService{
	
	private static Logger LOG = Logger.getLogger(SallingServiceImpl.class);
	private static SallingService sallingServiceImpl;
	private SallingDao sallingDao;

	private SallingServiceImpl() {

		try {
			sallingDao = new SallingDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOG.error(e);
		}
	}
	
	public static SallingService getSallingService() {

		if (sallingServiceImpl == null) {
			sallingServiceImpl = new SallingServiceImpl();
		}
		return sallingServiceImpl;
	}

	@Override
	public Salling create(Salling t) {
		
		return sallingDao.create(t);
	}

	@Override
	public Salling read(Integer id) {
	
		return sallingDao.read(id);
	}

	@Override
	public Salling update(Salling t) {
		
		return sallingDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		
		sallingDao.delete(id);
	}

	@Override
	public List<Salling> readAll() {

		return sallingDao.readAll();
	}

}
