package jdbc_study_coffee.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

import java.util.Properties;

public class MyDataSource {
	//singleton pattern적용
	private static final MyDataSource instance = new MyDataSource();//private으로 바꾸기
	//get set가도 get밖에 없음
	public static MyDataSource getInstance() {
		return instance;
	}
	//superclass생성
	private DataSource dataSource;
	
	//get set
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void close() {
		try {
			DataSources.destroy(dataSource);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private MyDataSource() {//꼭 private으로 수정해야 함!
		Properties prop = loadProperties();//import, create
		
		//값을 불러왔는지 확인
		/*for(Entry<Object,Object> e : prop.entrySet()) {//java.util.map으로 Entry import
			System.out.printf("%s -> %s%n",e.getKey(),e.getValue());
		}*/
		
		try {
			DataSource ds_unpooled = DataSources.unpooledDataSource(prop.getProperty("url"), prop);//import주의! javax.sql,
			Map<String, Object> overries = new HashMap<>();//Properties가 이타입을 씀, import java.util
			overries.put("maxStatements","200");
			overries.put("maxPoolSize",new Integer(50));
			
			dataSource = DataSources.pooledDataSource(ds_unpooled, overries);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	private Properties loadProperties() {
		Properties properties = new Properties();
		try(InputStream is = ClassLoader.getSystemResourceAsStream("db.properties")){//파일명만 제시하면 읽어들임
			properties.load(is);//is를 넣어주면 내용을 넣어줌
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;//return된 값을 prop이 참조할수 있음
	}
	
	
	
	
}









