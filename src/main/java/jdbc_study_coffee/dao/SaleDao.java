package jdbc_study_coffee.dao;

import java.sql.SQLException;
import java.util.List;

import jdbc_study_coffee.dto.Sale;

public interface SaleDao {
	List<Sale> selectProductByAll();
	
	int insertSale(Sale sale) throws SQLException;
}
