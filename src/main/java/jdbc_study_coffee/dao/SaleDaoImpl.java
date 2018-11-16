package jdbc_study_coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_study_coffee.dto.Sale;
import jdbc_study_coffee.jdbc.ConnectionProvider;
import jdbc_study_coffee.jdbc.LogUtil;

public class SaleDaoImpl implements SaleDao {
	
	@Override
	public List<Sale> selectProductByAll() throws SQLException {
		List<Sale> list = new ArrayList<>();
		LogUtil.prnLog(list.toString());
//		Assert.assertNotNull(list); 테스트 외에는 assert이용 X
		String sql = "select num, code, price, saleCnt, marginRate from sale";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
			while(rs.next()) {
				list.add(getSale(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	private Sale getSale(ResultSet rs) throws SQLException {
		int num = rs.getInt("num");
		String code = rs.getString("code");
		int price = rs.getInt("price");
		int saleCnt = rs.getInt("saleCnt");
		int marginRate = rs.getInt("marginRate");
		return new Sale(num,code,price,saleCnt,marginRate);
	}

	@Override
	public int insertSale(Sale sale) throws SQLException {
		LogUtil.prnLog("insertSale()");
		String sql = "insert into sale values(?,?,?,?,?)";
		int row = 0;
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, sale.getNo());
			pstmt.setString(2, sale.getCode());
			pstmt.setInt(3, sale.getPrice());
			pstmt.setInt(4, sale.getSaleCnt());
			pstmt.setInt(5,sale.getMarginRate());
			LogUtil.prnLog(pstmt);
			row = pstmt.executeUpdate();
		}
		return row;
	}

}
