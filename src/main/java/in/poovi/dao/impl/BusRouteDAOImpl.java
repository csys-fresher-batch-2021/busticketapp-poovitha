package in.poovi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BusRouteDAO;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;
import in.poovi.message.MessageConstants;
import in.poovi.model.BusRoute;
import in.poovi.util.ConnectionUtil;

public class BusRouteDAOImpl implements BusRouteDAO {

	/**
	 * This method is used to display the busroute.....
	 * 
	 * @return busRoute
	 * @throws DBException
	 */
	public List<BusRoute> findAll() throws DBException {
		List<BusRoute> busRoute = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select routeno,source,destination from busroute";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			busRoute = new ArrayList<>();

			while (rs.next()) {
				int routeno = rs.getInt("routeno");
				String source = rs.getString("source");
				String destination = rs.getString("destination");
				BusRoute route = new BusRoute();
				route.setRouteNo(routeno);
				route.setSource(source);
				route.setDestination(destination);
				busRoute.add(route);

			}
		} catch (Exception e) {
			Logger.error(e);
			throw new DBException(e,MessageConstants.UNABLE_TO_EXECUTE_QUERY);

		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return busRoute;

	}

	/**
	 * used to add the bus route......
	 * 
	 * @param busRoute
	 * @throws DBException
	 */
	public void save(BusRoute busRoute) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "insert into busroute(routeno,source,destination) values ( ?,?,? )";
		try {
			connection = ConnectionUtil.getConnection();

			pst = connection.prepareStatement(sql);
			pst.setInt(1, busRoute.getRouteNo());
			pst.setString(2, busRoute.getSource().trim());
			pst.setString(3, busRoute.getDestination().trim());
			pst.executeUpdate();

		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e,MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * delete the busroute......
	 * 
	 * @param routeno
	 * @throws DBException
	 */
	public void deleteRoute(int routeno) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
        String sql = "DELETE FROM busroute where routeno = ? ";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, routeno);
			int rows = pst.executeUpdate();
			Logger.log("no of rows deleted" + rows + routeno);
		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e,MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

}
