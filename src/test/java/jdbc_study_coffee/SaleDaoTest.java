package jdbc_study_coffee;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jdbc_study_coffee.dao.SaleDao;
import jdbc_study_coffee.dto.Sale;
import jdbc_study_coffee.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleDaoTest {
	static SaleDao dao;
	
	public void test01SelectSaleByAll() {
		List<Sale> list = dao.selectProductByAll();
		LogUtil.prnLog(list.toString());
		Assert.assertNotNull(list);//assert는 테스트에서만 이용
	}
	
	@Test
	public void test02InsertSale() {
		Sale newSale = new Sale(5,"A004",4300,110,11);
		try {
			int row = dao.insertSale(newSale);//null포인트
//			LogUtil.prnLog(String.format("row %d", row));
			Assert.assertEquals(1, row);
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				LogUtil.prnLog("해당 번호 존재");
			} else {
				LogUtil.prnLog(e);
			}
		}
	}
}
