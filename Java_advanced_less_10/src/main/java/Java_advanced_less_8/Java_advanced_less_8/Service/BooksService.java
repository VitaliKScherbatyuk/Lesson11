package Java_advanced_less_8.Java_advanced_less_8.Service;

import java.util.Map;

import Java_advanced_less_8.Java_advanced_less_8.AbstractCRUD.AbstractCRUD;
import Java_advanced_less_8.Java_advanced_less_8.Shop.Books;

public interface BooksService extends AbstractCRUD<Books> {
	public Map<Integer, Books> readAllMap();
}
