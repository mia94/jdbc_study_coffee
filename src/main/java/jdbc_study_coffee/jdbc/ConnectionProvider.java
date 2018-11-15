package jdbc_study_coffee.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider {
	//커넥션을 제공해주는 역할
	public static Connection getConnection() throws SQLException {
		return MyDataSource.getInstance().getDataSource().getConnection();//여기서 예외처리하지 X
	}
}
