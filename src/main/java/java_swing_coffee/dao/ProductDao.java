package java_swing_coffee.dao;

import java.util.List;

import java_swing_coffee.dto.Product;

public interface ProductDao {
	void prnProductList();
	
	boolean addProduct(Product p);
	
	boolean delProduct(Product p);
	
	boolean updateProduct(Product p);
	
	Product searchProduct(Product p);
	
	List<Product> getListProducts();
}
