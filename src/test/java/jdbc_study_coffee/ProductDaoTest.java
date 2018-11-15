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


import com.mysql.jdbc.Connection;

import jdbc_study_coffee.dao.ProductDao;
import jdbc_study_coffee.dao.ProductDaoImpl;
import jdbc_study_coffee.dao.SaleDao;
import jdbc_study_coffee.dto.Product;
import jdbc_study_coffee.dto.Sale;
import jdbc_study_coffee.jdbc.ConnectionProvider;
import jdbc_study_coffee.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {
	static ProductDao pdtDao;
	static SaleDao saleDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start ConnectionProviderTest");
		pdtDao = new ProductDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("End ConnectionProviderTest");
		pdtDao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectProductByAll() {
		List<Product> list = pdtDao.selectProductByAll();
		LogUtil.prnLog(list.toString());
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test02InsertProduct() {
		try {
			Sale newSale = new Sale(5,"B002",4300,110,11);
			int row = saleDao.insertSale(newSale);
			LogUtil.prnLog(String.format("row %d", row));
			Assert.assertEquals(1, row);
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				LogUtil.prnLog("해당 번호 존재");
			} else {
				LogUtil.prnLog(e);
			}
		}
	}
	
	@Test
	public void test03UpdateProduct() {
		
	}
	
	@Test
	public void test03DeleteProduct() {
		
	}
	
	@Test
	public void test05SelectProductByNo() {
		
	}
}

















