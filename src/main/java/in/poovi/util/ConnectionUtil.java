package in.poovi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private static final String DATABASE_NAME = "Busticket";
	private static final String DB_USERNAME = "postgres";
	private static final String DB_PASSWORD = "postgres";
	private static final String HOST = "localhost";
	private static final int PORT = 5432;
	private static final String DB_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE_NAME; // jdbc:postgres://localhost:5432/Busticket

	public static Connection getConnection() {

		Connection connection = null;
		try {
			// Step 1: Load the database driver into memory ( ClassNotFoundException )
			Class.forName(DRIVER_CLASS_NAME);

			// Step 2: Get the Database Connection (SQLException)
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.println(connection);
			System.out.println("connected");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to get the database connection");
		}

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

		public static void main(String[] args) throws Exception{
			//String driverClass = "org.postgresql.Driver";
			//String url = "jdbc:postgresql://localhost/Busticket";
			//String username = "postgres";
			//String password = "postgres";
			//Step 1: Load the jdbc driver in memory
			///Class.forName(driverClass);
			//Step 2: Get the connection
			//Connection connection = DriverManager.getConnection(url, username,password);
			//System.out.println(connection);
			//System.out.println("connected");
		ConnectionUtil.getConnection();
		}
	

}
