package java_swing_coffee.dao;

import java.util.List;

import java_swing_coffee.dto.Product;

public interface ProductDao {
	List<Product> selectProductByAll();
	
	
}
