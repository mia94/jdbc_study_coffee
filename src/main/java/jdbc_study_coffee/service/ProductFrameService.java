package jdbc_study_coffee.service;

import java.sql.SQLException;
import java.util.List;

import jdbc_study_coffee.dao.ProductDao;
import jdbc_study_coffee.dao.ProductDaoImpl;
import jdbc_study_coffee.dao.SaleDao;
import jdbc_study_coffee.dao.SaleDaoImpl;
import jdbc_study_coffee.dto.Product;
import jdbc_study_coffee.dto.Sale;

public class ProductFrameService {
	private SaleDao saleDao;
	private ProductDao productDao;
	
	public ProductFrameService() {
		saleDao = new SaleDaoImpl();
		productDao = new ProductDaoImpl(); 
	} 
	
	public List<Sale> selectSaleByAll() throws SQLException {
		return saleDao.selectProductByAll();
	}
	
	public int registerSale(Sale s) throws SQLException {
		return saleDao.insertSale(s);
	}
	
	public Product searchProduct(Product product) throws SQLException {
		return productDao.selectProductByNo(product);
	}
}
