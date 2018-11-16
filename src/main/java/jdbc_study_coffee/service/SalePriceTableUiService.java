package jdbc_study_coffee.service;

import java.sql.SQLException;
import java.util.List;

import jdbc_study_coffee.dao.SaleDao;
import jdbc_study_coffee.dao.SaleDaoImpl;
import jdbc_study_coffee.dto.Sale;

public class SalePriceTableUiService {
	private SaleDao dao;

	public SalePriceTableUiService() {
		dao = new SaleDaoImpl();
	}
	
	public List<Sale> outputOrder(boolean isSale) throws SQLException{
		return dao.selectProductRank(isSale);
	}
}
