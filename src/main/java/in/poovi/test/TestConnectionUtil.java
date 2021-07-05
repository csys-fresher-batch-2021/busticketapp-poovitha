package in.poovi.test;

import java.sql.SQLException;

import in.poovi.util.ConnectionUtil;

public class TestConnectionUtil {
	/**
	 * This main method is used to test the connection
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		ConnectionUtil.getConnection();
		}
}