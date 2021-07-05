package in.poovi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.poovi.dao.BusDetailsDAO;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;
import in.poovi.message.MessageConstants;
import in.poovi.model.BusDetails;
import in.poovi.model.SeatAvailable;
import in.poovi.util.ConnectionUtil;

public class BusDetailsDAOImpl implements BusDetailsDAO {
	private static final String AGENCY = "agency";

	/**
	 * This method is used to list the all busdetails
	 * 
	 * @return busdetails
	 * @throws DBException
	 */

	@Override
	public List<BusDetails> findAll() throws DBException {
		List<BusDetails> busDetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select agency,b_no,bustype,source,destination,amount from busdetails";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			busDetails = new ArrayList<>();

			while (rs.next()) {
				String agency = rs.getString(AGENCY);
				int busnumber = rs.getInt("b_no");
				String bustype = rs.getString("bustype");
				String source = rs.getString("source");
				String destination = rs.getString("destination");
				double amount = rs.getDouble("amount");
				BusDetails bus = new BusDetails();
				bus.setAgency(agency);
				bus.setAmount(amount);
				bus.setBusnumber(busnumber);
				bus.setSource(source);
				bus.setDestination(destination);
				bus.setBusType(bustype);
				busDetails.add(bus);

			}
		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e, "unable to execute query");
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return busDetails;

	}

	/**
	 * This method is used to add the busdetails in database
	 * 
	 * @param busdetails
	 * @throws DBException
	 */
	@Override
	public void save(BusDetails busdetails) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "insert into busdetails(agency,b_no,bustype,source,destination,amount) values ( ?,?,?,?,?,? )";
		try {
			connection = ConnectionUtil.getConnection();

			pst = connection.prepareStatement(sql);
			pst.setString(1, busdetails.getAgency().trim());
			pst.setInt(2, busdetails.getBusnumber());
			pst.setString(3, busdetails.getBusType());
			pst.setString(4, busdetails.getSource());
			pst.setString(5, busdetails.getDestination());
			pst.setDouble(6, busdetails.getAmount());
			pst.executeUpdate();

		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e, MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to delete the busdetails in database
	 * 
	 * @param agency
	 */
	@Override
	public void deleteBus(int bno) throws DBException{
		Connection connection = null;
		PreparedStatement pst = null;

		String sql = "DELETE FROM busdetails where b_no = ? ";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, bno);
			int rows = pst.executeUpdate();
			Logger.log("no of rows deleted" + rows + bno);

		} catch (SQLException e) {
			Logger.error(e);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to count the Number of buses.....
	 * 
	 * @return usercount
	 * @throws Exception
	 */
	@Override
	public int noOfBuses() throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int buscount = 0;
		String sql = "select count(*) as buscount from busdetails";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				buscount = rs.getInt("buscount");
			}
		} catch (Exception e) {
			Logger.error(e);
			throw new DBException(e, "no data found");
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return buscount;
	}

	/**
	 * This method is used to list the number of buslist......
	 * 
	 * @return obj
	 * @throws Exception
	 */
	@Override
	public Map<String, Integer> noOfBuslist() throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Map<String, Integer> obj = new HashMap<>();

		String sql = "select agency,count(*) as cnt from  busdetails group by agency";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String agency = rs.getString(AGENCY);
				int count = rs.getInt("cnt");
				obj.put(agency, count);
			}

		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e, MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return obj;

	}

	/**
	 * This method is used to display the stationlist.....
	 * 
	 * @param source
	 * @param destination
	 * @return stationlist
	 * @throws DBException
	 */
	@Override
	public List<BusDetails> findStationList(String source, String destination) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select agency,b_no,bustype,source,destination,amount,totalseat,availableseat,availableDate from view_busdetails where source=? and destination=?";
		List<BusDetails> stationlist = new ArrayList<>();

		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, source);
			pst.setString(2, destination);
			rs = pst.executeQuery();
			while (rs.next()) {
				BusDetails busdetails = new BusDetails();
				busdetails.setAgency(rs.getString(AGENCY));
				busdetails.setBusnumber(rs.getInt("b_no"));
				busdetails.setBusType(rs.getString("bustype"));
				busdetails.setSource(rs.getString("source"));
				busdetails.setDestination(rs.getString("destination"));
				busdetails.setAmount(rs.getDouble("amount"));
				SeatAvailable s = new SeatAvailable();
				s.setTotalSeat(rs.getInt("totalseat"));
				s.setAvailableSeat(rs.getInt("availableseat"));
				s.setAvailableDate(rs.getTimestamp("availableDate").toLocalDateTime());
				busdetails.setSeatavailable(s);
				stationlist.add(busdetails);

			}
		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e,MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return stationlist;
	}
}