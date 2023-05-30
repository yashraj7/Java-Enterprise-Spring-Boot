package in.jdbcProject.util;

import java.io.FileInputStream;  
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	private JdbcUtil() {
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {
		//Physical Loading and getting Connection
//		FileInputStream fis = new FileInputStream("src\\in\\jdbcProject\\properties\\application.properties");
//		Properties properties = new Properties();
//		properties.load(fis);
//		Connection con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
//				properties.getProperty("password"));
		
		HikariConfig config = new HikariConfig("src\\in\\jdbcProject\\properties\\application.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource.getConnection();
		
	}

//	public static void cleanUp(Connection con, Statement st, ResultSet rs) throws SQLException {
//		if (con != null)
//			con.close();
//		if (st != null)
//			st.close();
//		if (rs != null)
//			rs.close();
//	}
}
