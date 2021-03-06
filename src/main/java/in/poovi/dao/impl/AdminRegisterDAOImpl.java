package in.poovi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.AdminRegisterDAO;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;
import in.poovi.message.MessageConstants;
import in.poovi.model.AdminRegister;
import in.poovi.util.ConnectionUtil;

public class AdminRegisterDAOImpl implements AdminRegisterDAO {
	/**
	 * This method is used to list the all admin details
	 * 
	 * @return adminregister
	 * @throws DBException
	 */

	@Override
	public List<AdminRegister> findAll() throws DBException {
		List<AdminRegister> adminregister = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select adminname,adminid,adminpassword from adminregister";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			adminregister = new ArrayList<>();

			while (rs.next()) {
				String adminName = rs.getString("adminname");
				int adminId = rs.getInt("adminid");
				String adminPassword = rs.getString("adminpassword");
				AdminRegister admin = new AdminRegister();
				admin.setAdminName(adminName);
				admin.setAdminId(adminId);
				admin.setPassword(adminPassword);
				adminregister.add(admin);

			}
		} catch (Exception e) {
			Logger.error(e);
			throw new DBException(e,MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return adminregister;

	}

	/**
	 * This method is used to add the admin
	 * 
	 * @param adminregister
	 * @throws DBException
	 */
	@Override
	public void saveAdmin(AdminRegister adminregister) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "insert into adminregister(adminname,adminid,adminpassword) values ( ?,?,? )";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, adminregister.getAdminName().trim());
			pst.setInt(2, adminregister.getAdminId());
			pst.setString(3, adminregister.getPassword());
			pst.executeUpdate();

		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e,MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to delete the admin registration......
	 * 
	 * @param adminName
	 * @throws DBException 
	 */
	@Override
	public void deleteAdmin(int adminId) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;

		String sql = "DELETE FROM adminregister where adminid = ? ";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, adminId);
			int rows = pst.executeUpdate();
			Logger.log("no of rows deleted" + rows + adminId);

		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e,MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to get the admindetails where using adminid.....
	 * 
	 * @param adminid
	 * @return adminregister
	 * @throws Exception
	 */
	@Override
	public List<AdminRegister> findByAdminId(int adminid) throws DBException {
		List<AdminRegister> adminregister = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select adminname,adminid,adminpassword from adminregister where adminid=?";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, adminid);
			rs = pst.executeQuery();
			adminregister = new ArrayList<>();
			while (rs.next()) {
				String adminName = rs.getString("adminname");
				int adminId = rs.getInt("adminid");
				String password = rs.getString("adminpassword");
				AdminRegister admin = new AdminRegister();
				admin.setAdminName(adminName);
				admin.setAdminId(adminId);
				admin.setPassword(password);
				adminregister.add(admin);

			}
		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e,MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);

		}
		return adminregister;
	}

}
