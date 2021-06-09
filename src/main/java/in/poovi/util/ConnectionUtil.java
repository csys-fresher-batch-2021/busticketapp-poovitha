package in.poovi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	private ConnectionUtil() {
		
	}

	public static Connection getConnection() throws SQLException {
		Connection connection = null;

		String driverClass = System.getenv("spring.datasource.driver-class-name");
		String url = System.getenv("spring.datasource.url");
		String username = System.getenv("spring.datasource.username");
		String password = System.getenv("spring.datasource.password");
		try {
			Class.forName(driverClass);
			// getting connection from db
		connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	
        System.out.println("connected");
		return connection;
	}
	
	public static void close(PreparedStatement pst, Connection con)  {
		try {
			// Null Check - to avoid Null Pointer Exception
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			
		}
	}

	public static void close(Connection con, Statement st, ResultSet rs) {

		// Null Check - to avoid Null Pointer Exception
		try {
			if(con != null) { 
				con.close();
			}
					if (st != null) {
						st.close();
					}
					if (rs != null) {
						rs.close();
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
