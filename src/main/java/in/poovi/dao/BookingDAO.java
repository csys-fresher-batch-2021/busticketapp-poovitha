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

	List<Booking> findAll() throws DBException;

	/**
	 * This method is used to add the booking details in database
	 * 
	 * @param booking
	 * @throws Exception
	 */
	void addReservation(Booking booking) throws DBException;

	/**
	 * This method is used to cancel booking from the user....
	 * 
	 * @param agency
	 * @throws DBException
	 */
	void cancelReserve(int bookingno) throws DBException;

	/**
	 * This method is used update date .....
	 * 
	 * @param busnumber
	 * @param availableDate
	 * @throws DBException
	 */
	List<Booking> findMyTicket(int pid) throws DBException;

	/**
	 * This method is used to find the total ticket cost
	 * 
	 * @param busnumber
	 * @return amount
	 * @throws DBException
	 */
	double findTicketCost(int bno) throws DBException;

	/**
	 * This method is used to display the filled seats
	 * 
	 * @return filledSeat
	 * @throws DBException
	 */
	HashMap<Integer, Integer> findFilledSeats() throws DBException;

	/**
	 * Used to update the date..
	 * 
	 * @param busnumber
	 * @return availabledate
	 * @throws DBException
	 */
	LocalDateTime findAvailableDate(int busnumber) throws DBException;

}