package java_swing_coffee.dao;

import java.sql.SQLException;
import java.util.List;

import java_swing_coffee.dto.Product;

public interface ProductDao {
	List<Product> selectProductByAll();
	
	int insertProduct(Product product) throws SQLException;
	int updateProduct(Product product) throws SQLException;
	int deleteProduct(Product product) throws SQLException;
	Product selectProductByNo(Product product) throws SQLException;
	
	
}
