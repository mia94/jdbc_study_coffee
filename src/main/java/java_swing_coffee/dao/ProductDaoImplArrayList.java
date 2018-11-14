package java_swing_coffee.dao;

import java.util.ArrayList;
import java.util.List;

import java_swing_coffee.dto.Product;

public class ProductDaoImplArrayList implements ProductDao {
	
	private List<Product> datas;
	
	
	public ProductDaoImplArrayList() {
		datas = new ArrayList<>();
	}

	@Override
	public void prnProductList() {
		for(Product p : datas) {
			System.out.println(p);
		}
	}

	@Override
	public boolean addProduct(Product p) {
		if(datas.contains(p)) {
			return false;
		}
		return datas.add(p);
	}

	@Override
	public boolean delProduct(Product p) {
		if(!datas.contains(p)) {
			return false;
		}
		return datas.remove(p);
	}

	@Override
	public boolean updateProduct(Product p) {
		if(!datas.contains(p)) {
			return false;
		}
		return datas.set(datas.indexOf(p), p)==null?false:true;
	}

	@Override
	public Product searchProduct(Product p) {
		return datas.get(datas.indexOf(p));
	}

	@Override
	public List<Product> getListProducts() {
		// TODO Auto-generated method stub
		return datas;
	}

}
