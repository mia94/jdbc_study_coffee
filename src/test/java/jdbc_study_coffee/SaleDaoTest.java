package jdbc_study_coffee;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jdbc_study_coffee.dao.SaleDao;
import jdbc_study_coffee.dao.SaleDaoImpl;
import jdbc_study_coffee.dto.Product;
import jdbc_study_coffee.dto.Sale;
import jdbc_study_coffee.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleDaoTest {
	static SaleDao dao;//dao선언 후 new 해줘야 함
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start ConnectionProviderTest");
		dao = new SaleDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("End ConnectionProviderTest");
		dao = null;
	}

	@Before
	public void setUp() throws Exception { 
		System.out.println();
	}
	
	@Test
	public void test01SelectSaleByAll() throws SQLException {
		List<Sale> list = dao.selectProductByAll();
		LogUtil.prnLog(list.toString());
		Assert.assertNotNull(list);//assert는 테스트에서만 이용
	}
	
	/*@Test
	public void test02InsertSale() {
		Product product = new Product("A004");
		Sale newSale = new Sale(5,product,4300,110,11);
		try {
			int row = dao.insertSale(newSale);
			LogUtil.prnLog(String.format("row %d", row));
			Assert.assertEquals(1, row);
		} catch (SQLException e) {
				LogUtil.prnLog(e);
		}
	}*/
	
	@Test
	public void test03selectProductRank() throws SQLException {
		dao.selectProductRank(true);
	}
	
	@Test
	public void test04selectProductRank() throws SQLException {
		dao.selectProductRank(false);
	}
}
