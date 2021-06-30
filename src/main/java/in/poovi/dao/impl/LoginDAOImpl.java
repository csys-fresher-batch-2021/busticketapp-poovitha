package in.poovi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.poovi.dao.LoginDAO;
import in.poovi.message.MessageConstants;
import in.poovi.util.ConnectionUtil;

public class LoginDAOImpl implements LoginDAO {
	/**
	 * This method is used to admin login
	 * 
	 * @param adminName
	 * @param adminPassword
	 * @return valid
	 * @throws Exception
	 */
	@Override
	public boolean adminLogin(String adminName, String adminPassword) throws Exception {
		boolean valid = false;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "Select adminname from adminregister where adminname=? and adminpassword=?";

		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, adminName);
			pst.setString(2, adminPassword);
			rs = pst.executeQuery();
			if (rs.next()) {
				valid = true;
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return valid;
	}

	/**
	 * This method is used for login user....
	 * 
	 * @param username
	 * @param password
	 * @return valid
	 * @throws Exception
	 */
	@Override
	public boolean userLogin(String username, String password) throws Exception {
		boolean valid = false;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "Select username from userregister where username=? and password=?";

		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {
				valid = true;
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return valid;
	}

}
