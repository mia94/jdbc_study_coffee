package jdbc_study_coffee;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java_swing_coffee.dao.ProductDao;
import java_swing_coffee.dao.ProductDaoImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {
	static ProductDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start ConnectionProviderTest");
		dao = new ProductDaoImpl();
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
	public void test01SelectProductByAll() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test02InsertProduct() {
		
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

















