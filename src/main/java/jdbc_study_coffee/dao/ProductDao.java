package jdbc_study_coffee.dao;

import java.sql.SQLException;
import java.util.List;

import jdbc_study_coffee.dto.Product;

public interface ProductDao {
	
	List<Product> selectProductByAll();
	
	int insertProduct(Product product) throws SQLException;
	int updateProduct(Product product) throws SQLException;
	int deleteProduct(Product product) throws SQLException;
	Product selectProductByNo(Product product) throws SQLException;
	
	
}
