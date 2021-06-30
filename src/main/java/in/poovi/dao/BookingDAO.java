package in.poovi.dao;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import in.poovi.exception.DBException;
import in.poovi.model.Booking;

public interface BookingDAO {

	/**
	 * This method is used to list the all booking details
	 * 
	 * @return booking
	 * @throws Exception
	 */

	List<Booking> findAll() throws Exception;

	/**
	 * This method is used to add the booking details in database
	 * 
	 * @param booking
	 * @throws Exception
	 */
	void addReservation(Booking booking) throws Exception;

	/**
	 * This method is used to cancel booking from the user....
	 * 
	 * @param agency
	 * @throws DBException
	 */
	void cancelReserve(int bookingno) throws DBException;

	List<Booking> findMyTicket(int pid) throws DBException;

	/**
	 * This method is used to find the total ticket cost
	 * 
	 * @param busnumber
	 * @return amount
	 * @throws DBException
	 */
	double findTicketCost(int b_no) throws DBException;

	/**
	 * This method is used to display the filled seats
	 * 
	 * @return filledSeat
	 * @throws DBException
	 */
	HashMap<Integer, Integer> findFilledSeats() throws DBException;

	LocalDateTime findAvailableDate(int busnumber) throws DBException;

}