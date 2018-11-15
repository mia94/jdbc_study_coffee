package jdbc_study_coffee.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import jdbc_study_coffee.dto.Product;
import jdbc_study_coffee.jdbc.ConnectionProvider;
import jdbc_study_coffee.jdbc.LogUtil;

public class ProductDaoImpl implements ProductDao {
//	static ProductDao dao;

	@Override
	public List<Product> selectProductByAll() {
		List<Product> list = new ArrayList<>();
		String sql = "select code, name from product";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
			while(rs.next()) {
				list.add(getProduct(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private Product getProduct(ResultSet rs) throws SQLException {
		String pdtCode = rs.getString("code");
		String pdtName = rs.getString("name");
		return new Product(pdtCode, pdtName);
	}

	@Override
	public Product selectProductByNo(Product product) throws SQLException {
		Product pdt = null;
		String sql = "select code, name from product where code = ?";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, product.getCode());
			LogUtil.prnLog(pstmt);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					pdt = getProduct(rs);
				}
			}
		}
		
		return pdt;
	}
	
	@Override
	public int insertProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int updateProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
