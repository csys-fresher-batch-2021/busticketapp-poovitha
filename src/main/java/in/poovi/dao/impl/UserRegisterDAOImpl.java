package in.poovi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.UserRegisterDAO;
import in.poovi.exception.DBException;
import in.poovi.message.MessageConstants;
import in.poovi.model.UserRegister;
import in.poovi.util.ConnectionUtil;

public class UserRegisterDAOImpl implements UserRegisterDAO {

	/**
	 * This method is used to list the user.....
	 * 
	 * @return userregister
	 * @throws Exception
	 */

	@Override
	public List<UserRegister> findAll() throws Exception {
		List<UserRegister> userregister = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select username,age,email,mobileno,userId,password from userregister";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			userregister = new ArrayList<>();

			while (rs.next()) {
				String username = rs.getString("username");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				long mobileno = rs.getLong("mobileno");
				int userid = rs.getInt("userid");
				String password = rs.getString("password");
				UserRegister user = new UserRegister();
				user.setUserName(username);
				user.setAge(age);
				user.setEmail(email);
				user.setMobileno(mobileno);
				user.setUserId(userid);
				user.setPassword(password);
				userregister.add(user);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("no data found");
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return userregister;

	}

	/**
	 * used to add the user......
	 * 
	 * @param busRoute
	 * @throws DBException 
	 */
	@Override
	public void saveUser(UserRegister userregister) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "insert into userregister(username,age,email,mobileno,userId,password) values ( ?,?,?,?,?,? )";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, userregister.getUserName());
			pst.setInt(2, userregister.getAge());
			pst.setString(3, userregister.getEmail());
			pst.setLong(4, userregister.getMobileno());
			pst.setInt(5, userregister.getUserId());
			pst.setString(6, userregister.getPassword());
			int row = pst.executeUpdate();
			System.out.println(row);

		} catch (SQLException e) {
			e.printStackTrace();
		throw new DBException(MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to update the mobileno ......
	 * 
	 * @param mobileno
	 * @param username
	 * @throws DBException 
	 */
	@Override
	public void updateMobileno(long mobileno, String username) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "update userregister set mobileno=? where username=?";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(2, username);
			pst.setLong(1, mobileno);
			int rows = pst.executeUpdate();
			System.out.println("update user " + rows + username + mobileno);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);

		}

	}

	/**
	 * This method is used to get user details .....
	 * 
	 * @param userid
	 * @throws Exception
	 */
	@Override
	public List<UserRegister> findUserById(int userid) throws Exception {
		List<UserRegister> userregister = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select username,age,email,mobileno,userId,password from userregister where userid=?";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userid);
			rs = pst.executeQuery();
			userregister = new ArrayList<>();
			while (rs.next()) {
				String username = rs.getString("username");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				long mobileno = rs.getLong("mobileno");
				int userid1 = rs.getInt("userid");
				String password = rs.getString("password");
				UserRegister user = new UserRegister();
				user.setUserName(username);
				user.setAge(age);
				user.setEmail(email);
				user.setMobileno(mobileno);
				user.setUserId(userid1);
				user.setPassword(password);
				userregister.add(user);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return userregister;
	}

	/**
	 * This method is used to count the Number of users.....
	 * 
	 * @return usercount
	 * @throws Exception
	 */
	@Override
	public int findNoOfUsers() throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int usercount = 0;
		String sql = "select count(*) as usercount from userregister";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				usercount = rs.getInt("usercount");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("no data found");
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return usercount;
	}
}
