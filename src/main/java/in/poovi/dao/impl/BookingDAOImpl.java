package in.poovi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.poovi.dao.BookingDAO;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;
import in.poovi.message.MessageConstants;
import in.poovi.model.Booking;
import in.poovi.util.ConnectionUtil;

public class BookingDAOImpl implements BookingDAO {

	private static final String BUSNUMBER = "busnumber";
	private static final String AMOUNT = "amount";

	/**
	 * This method is used to list the all booking details
	 * 
	 * @return booking
	 * @throws Exception
	 */

	@Override
	public List<Booking> findAll() throws DBException {
		List<Booking> booking = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select bookingno,pid,source,destination,agency,busnumber,bustype,amount,nooftickets,totalamount,bookingDate,journeyDate,status from booking";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			booking = new ArrayList<>();

			while (rs.next()) {
				int bookingno = rs.getInt("bookingno");
				int pid = rs.getInt("pid");
				String source = rs.getString("source");
				String destination = rs.getString("destination");
				String agency = rs.getString("agency");
				int busnumber = rs.getInt(BUSNUMBER);
				String bustype = rs.getString("bustype");
				double amount = rs.getDouble(AMOUNT);
				int noofTickets = rs.getInt("nooftickets");
				double totalAmount = rs.getDouble("totalamount");
				String status = rs.getString("status");
				Booking book = new Booking();
				book.setBookingNo(bookingno);
				book.setPid(pid);
				book.setSource(source);
				book.setDestination(destination);
				book.setAgency(agency);
				book.setBusnumber(busnumber);
				book.setBusType(bustype);
				book.setAmount(amount);
				book.setNoOfTickets(noofTickets);
				book.setTotalAmount(totalAmount);
				book.setBookingDate(rs.getTimestamp("bookingDate").toLocalDateTime());
				book.setJourneyDate(rs.getTimestamp("journeyDate").toLocalDateTime());
				book.setStatus(status);
				booking.add(book);

			}
		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e, "no data found");
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return booking;

	}

	/**
	 * This method is used to add the booking details in database
	 * 
	 * @param booking
	 * @throws Exception
	 */
	@Override
	public void addReservation(Booking booking) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "insert into booking(bookingno,pid,source,destination,agency,busnumber,bustype,amount,nooftickets,totalamount,bookingDate,journeyDate,status) values ( ?,?,?,?,?,?,?,?,?,?,?,?,? )";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, booking.getBookingNo());
			pst.setInt(2, booking.getPid());
			pst.setString(3, booking.getSource());
			pst.setString(4, booking.getDestination());
			pst.setString(5, booking.getAgency().trim());
			pst.setInt(6, booking.getBusnumber());
			pst.setString(7, booking.getBusType());
			pst.setDouble(8, booking.getAmount());
			pst.setInt(9, booking.getNoOfTickets());
			pst.setDouble(10, booking.getTotalAmount());
			pst.setTimestamp(11, Timestamp.valueOf(booking.getBookingDate()));
			pst.setTimestamp(12, Timestamp.valueOf(booking.getJourneyDate()));
			pst.setString(13, booking.getStatus());
			pst.executeUpdate();

		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e, MessageConstants.UNABLE_TO_EXECUTE_QUERY);

		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to cancel booking from the user....
	 * 
	 * @param agency
	 * @throws DBException
	 */
	@Override
	public void cancelReserve(int bookingno) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;

		String sql = "DELETE FROM booking where bookingno = ? ";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, bookingno);
			int rows = pst.executeUpdate();
			Logger.log("no of rows deleted" + rows + bookingno);

		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e, MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}
	/**
	 * This method is used update date .....
	 * 
	 * @param busnumber
	 * @param availableDate
	 * @throws DBException
	 */

	public List<Booking> findMyTicket(int pid) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select bookingno,pid,source,destination,agency,busnumber,bustype,amount,nooftickets,totalamount,bookingDate,journeyDate,status from booking where pid=?";
		List<Booking> myTicket = new ArrayList<>();

		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, pid);
			rs = pst.executeQuery();
			while (rs.next()) {
				Booking booking = new Booking();
				booking.setBookingNo(rs.getInt("bookingno"));
				booking.setPid(rs.getInt("pid"));
				booking.setSource(rs.getString("source"));
				booking.setDestination(rs.getString("destination"));
				booking.setAgency(rs.getString("agency"));
				booking.setBusnumber(rs.getInt(BUSNUMBER));
				booking.setBusType(rs.getString("bustype"));
				booking.setAmount(rs.getDouble(AMOUNT));
				booking.setNoOfTickets(rs.getInt("nooftickets"));
				booking.setTotalAmount(rs.getDouble("totalamount"));
				booking.setBookingDate(rs.getTimestamp("bookingDate").toLocalDateTime());
				booking.setJourneyDate(rs.getTimestamp("journeyDate").toLocalDateTime());
				booking.setStatus(rs.getString("status"));
				myTicket.add(booking);
			}
		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e, MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return myTicket;

	}

	/**
	 * This method is used to find the total ticket cost
	 * 
	 * @param busnumber
	 * @return amount
	 * @throws DBException
	 */
	@Override
	public double findTicketCost(int bno) throws DBException {
		double amount = 0;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select amount from busdetails where b_no=?";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, bno);
			rs = pst.executeQuery();
			Logger.log("busnumber " + bno);
			if (rs.next()) {
				amount = rs.getDouble(AMOUNT);
				System.out.println(amount);
			} else {
				throw new SQLException("not found");
			}
		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e, MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(connection, pst, rs);

		}
		return amount;
	}

	/**
	 * This method is used to display the filled seats
	 * 
	 * @return filledSeat
	 * @throws DBException
	 */
	@Override
	public HashMap<Integer, Integer> findFilledSeats() throws DBException {
		Integer filledSeat = 0;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		HashMap<Integer, Integer> total = new HashMap<>();

		String sql = "select busnumber,sum(nooftickets) as filledSeat from booking group by busnumber";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				filledSeat = rs.getInt("filledSeat");
				int bookingno = rs.getInt(BUSNUMBER);
				total.put(bookingno, filledSeat);

			}
		} catch (Exception e) {
			Logger.error(e);
			throw new DBException(e, MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(connection, pst, rs);

		}
		return total;

	}
	/**
	 * Used to update the date..
	 * 
	 * @param busnumber
	 * @return availabledate
	 * @throws DBException
	 */
	public LocalDateTime findAvailableDate(int busnumber) throws DBException {
		LocalDateTime availableDate = null;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select availableDate from seatavailable where busnumber=?";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, busnumber);
			rs = pst.executeQuery();
			Logger.log("busnumber " + busnumber);
			if (rs.next()) {
				availableDate = rs.getTimestamp("availableDate").toLocalDateTime();
			} else {
				throw new SQLException("Date Expired");
			}
		} catch (SQLException e) {
			Logger.error(e);
			throw new DBException(e, MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(connection, pst, rs);

		}
		return availableDate;
	}

}
