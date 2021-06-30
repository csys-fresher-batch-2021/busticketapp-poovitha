package in.poovi.dao;

import java.time.LocalDateTime;
import java.util.List;

import in.poovi.exception.DBException;
import in.poovi.model.SeatAvailable;

public interface SeatAvailableDAO {

	/**
	 * This method is used to list the total available seat.....
	 * 
	 * @return booking
	 * @throws Exception
	 */

	List<SeatAvailable> findAll() throws Exception;

	/**
	 * used to add the seatavailable in bus......
	 * 
	 * @param busRoute
	 * @throws DBException
	 */
	void saveSeat(SeatAvailable seatavailable) throws DBException;

	/**
	 * delete the seat available......
	 * 
	 * @param routeno
	 * @throws DBException
	 */
	void deleteSeat(int busnumber) throws DBException;

	/**
	 * This method is used to update the seat available in available bus......
	 * 
	 * @param busnumber
	 * @param availableseat
	 * @throws DBException
	 */
	void updateSeat(int busnumber, int availableseat) throws DBException;

	/**
	 * This method is used to available seat details along with busnumber.....
	 * 
	 * @param busnumber
	 * @return availableSeats
	 * @throws Exception
	 */
	int findSeatDetailByBusnumber(int busnumber) throws Exception;

	/**
	 * This method is used to update the seatavailable when the pasenger is booked
	 * the tickets
	 * 
	 * @param busnumber
	 * @throws DBException
	 */
	void updateSeatAvailable(int busnumber, LocalDateTime availableDate, LocalDateTime bookingDate) throws DBException;

	void updateSeatAvailable1(int busnumber) throws DBException;

	void updateDate(int busnumber, LocalDateTime availableDate) throws DBException;

}