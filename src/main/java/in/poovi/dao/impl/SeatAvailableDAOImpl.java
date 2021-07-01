package in.poovi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.SeatAvailableDAO;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;
import in.poovi.message.MessageConstants;
import in.poovi.model.SeatAvailable;
import in.poovi.util.ConnectionUtil;

public class SeatAvailableDAOImpl implements SeatAvailableDAO {
	/**
	 * This method is used to list the total available seat.....
	 * 
	 * @return booking
	 * @throws Exception
	 */

	@Override
	public List<SeatAvailable> findAll() throws Exception {
		List<SeatAvailable> seatavailable = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select busnumber,availableseat,totalseat,availableDate from seatavailable";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			seatavailable = new ArrayList<>();

			while (rs.next()) {
				int busnumber = rs.getInt("busnumber");
				int availableseat = rs.getInt("availableseat");
				int totalseat = rs.getInt("totalseat");
				SeatAvailable seat = new SeatAvailable();
				seat.setBusnumber(busnumber);
				seat.setAvailableSeat(availableseat);
				seat.setTotalSeat(totalseat);
				seat.setAvailableDate(rs.getTimestamp("availableDate").toLocalDateTime());
				seatavailable.add(seat);
			}
		} catch (Exception e) {
			Logger.error(e);
			throw new DBException(e,"no data found");
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return seatavailable;

	}

	/**
	 * used to add the seatavailable in bus......
	 * 
	 * @param busRoute
	 * @throws DBException
	 */
	@Override
	public void saveSeat(SeatAvailable seatavailable) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "insert into seatavailable(busnumber,availableseat,totalseat,availableDate) values ( ?,?,?,? )";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, seatavailable.getBusnumber());
			pst.setInt(2, seatavailable.getAvailableSeat());
			pst.setInt(3, seatavailable.getTotalSeat());
			pst.setTimestamp(4, Timestamp.valueOf(seatavailable.getAvailableDate()));
			pst.executeUpdate();

		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e,MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * delete the seat available......
	 * 
	 * @param routeno
	 * @throws DBException
	 */
	@Override
	public void deleteSeat(int busnumber) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;

		String sql = "DELETE FROM seatavailable where busnumber = ? ";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, busnumber);
			int rows = pst.executeUpdate();
			System.out.println("no of rows deleted " + rows + busnumber);
		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e,"no data found");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to update the seat available in available bus......
	 * 
	 * @param busnumber
	 * @param availableseat
	 * @throws DBException
	 */
	@Override
	public void updateSeat(int busnumber, int availableseat) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "update seatavailable set availableseat=? where busnumber=?";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(2, busnumber);
			pst.setInt(1, availableseat);
			int rows = pst.executeUpdate();
			System.out.println("update seatavailable " + rows + busnumber + availableseat);
		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e,"unable to execute query");
		} finally {
			ConnectionUtil.close(pst, connection);

		}

	}

	/**
	 * This method is used to available seat details along with busnumber.....
	 * 
	 * @param busnumber
	 * @return availableSeats
	 * @throws Exception
	 */
	@Override
	public int findSeatDetailByBusnumber(int busnumber) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select availableseat from seatavailable where busnumber=?";
		int availableSeats = 0;
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, busnumber);
			rs = pst.executeQuery();
			System.out.println("seat available " + busnumber);
			while (rs.next()) {
				availableSeats = rs.getInt("availableseat");
			}
		} catch (Exception e) {
			Logger.error(e);
			throw new DBException(e,MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return availableSeats;
	}

	/**
	 * This method is used to update the seatavailable when the pasenger is booked
	 * the tickets
	 * 
	 * @param busnumber
	 * @throws DBException
	 */
	@Override
	public void updateSeatAvailable(int busnumber,LocalDateTime availableDate,LocalDateTime bookingDate) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "update seatavailable s set availableseat  = (select availableseat from seatavailable where busnumber=? and availableDate=?)-(select sum(nooftickets) from booking where busnumber=? and bookingDate=?) from busdetails,booking  where s.busnumber=busdetails.b_no and s.availableDate=booking.journeyDate and s.busnumber=?";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, busnumber);
			pst.setInt(2, busnumber);
			pst.setInt(3, busnumber);
			pst.setTimestamp(4, Timestamp.valueOf(availableDate));
			pst.setTimestamp(5, Timestamp.valueOf(bookingDate));
			int rows = pst.executeUpdate();
			System.out.println("update seatavailable " + rows + busnumber);
		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e,MessageConstants.UNABLE_TO_EXECUTE_QUERY); 
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}
	@Override
	public void updateSeatAvailable1(int busnumber) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "update seatavailable s set availableseat  = (select availableseat from seatavailable where busnumber=?)-(select sum(nooftickets) from booking where busnumber=? group by busnumber) from busdetails,booking  where s.busnumber=busdetails.b_no and s.busnumber=?";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, busnumber);
			pst.setInt(2, busnumber);
			pst.setInt(3, busnumber);
			int rows = pst.executeUpdate();
			System.out.println("update seatavailable " + rows + busnumber);
		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e,MessageConstants.UNABLE_TO_EXECUTE_QUERY); 
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	@Override
	public void updateDate(int busnumber,LocalDateTime availableDate) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "update seatavailable set availableDate=? where busnumber=?";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(2, busnumber);
			pst.setTimestamp(1, Timestamp.valueOf(availableDate));
			int rows = pst.executeUpdate();
			System.out.println("update Date " + rows + busnumber);
		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e,MessageConstants.UNABLE_TO_EXECUTE_QUERY); 
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

}
