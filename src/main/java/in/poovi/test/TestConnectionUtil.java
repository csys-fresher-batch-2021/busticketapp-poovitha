package in.poovi.test;

import java.sql.SQLException;

import in.poovi.exception.DBException;
import in.poovi.util.ConnectionUtil;

public class TestConnectionUtil {
	/**
	 * This main method is used to test the connection
	 * 
	 * @param args
	 * @throws DBException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws DBException, SQLException {
		ConnectionUtil.getConnection();
		}
}