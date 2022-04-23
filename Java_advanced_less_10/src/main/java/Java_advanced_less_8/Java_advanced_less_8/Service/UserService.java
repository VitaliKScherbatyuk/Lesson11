package Java_advanced_less_8.Java_advanced_less_8.Service;

import Java_advanced_less_8.Java_advanced_less_8.AbstractCRUD.AbstractCRUD;
import Java_advanced_less_8.Java_advanced_less_8.Shop.User;

public interface UserService extends AbstractCRUD<User>{

	User getUserByEmail(String email);
}
