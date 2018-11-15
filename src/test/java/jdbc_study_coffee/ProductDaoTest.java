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

import jdbc_study_coffee.dao.ProductDao;
import jdbc_study_coffee.dao.ProductDaoImpl;
import jdbc_study_coffee.dto.Product;
import jdbc_study_coffee.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {
	static ProductDao pdtDao;
	
	
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
		Assert.assertNotNull(list);//assert는 테스트에서만 이용
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

















