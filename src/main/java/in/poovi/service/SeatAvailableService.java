package in.poovi.service;

import java.time.LocalDateTime;
import java.util.List;

import in.poovi.dao.SeatAvailableDAO;
import in.poovi.dao.impl.SeatAvailableDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.model.SeatAvailable;

public class SeatAvailableService {

	private static SeatAvailableDAO seatavailableDAO = new SeatAvailableDAOImpl();

	/**
	 * This method is used to display the all available seat.....
	 * 
	 * @return allAvailableSeat
	 * @throws Exception
	 */

	public List<SeatAvailable> getAllAvailableSeat() throws DBException {
		return seatavailableDAO.findAll();
	}

	/**
	 * This method is used to add the seat available in the available bus.......
	 * 
	 * @param seatavailable
	 * @throws Exception
	 */
	public void saveSeat(SeatAvailable seatavailable) throws Exception {
		seatavailableDAO.saveSeat(seatavailable);
	}

	/**
	 * This method is used to delete the seat if the bus is not available.....
	 * 
	 * @param busnumber
	 * @throws DBException 
	 */
	public void deleteSeat(int busnumber) throws DBException {
		seatavailableDAO.deleteSeat(busnumber);
	}

	/**
	 * This method is used to update seat available
	 * 
	 * @param busnumber
	 * @param availableseat
	 * @throws DBException 
	 */
	public void UpdateSeat(int busnumber, int availableseat) throws DBException {
		seatavailableDAO.updateSeat(busnumber, availableseat);
	}

	/**
	 * This method is used to get available seat
	 * 
	 * @param busnumber
	 * @return availableseat
	 */

	public int findSeatDetail(int busnumber) {
		int availableSeats = 0;
		try {
			availableSeats = seatavailableDAO.findSeatDetailByBusnumber(busnumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return availableSeats;
	}

	/**
	 * This method is used to update the available seat after the ticket
	 * booked......
	 * @param busnumber
	 * @param availableDate
	 * @param bookingDate
	 * @throws DBException
	 */
	public void updateSeatAvailable(int busnumber,LocalDateTime availableDate,LocalDateTime bookingDate) throws DBException {
		seatavailableDAO.updateSeatAvailable(busnumber, availableDate, bookingDate);
	}

}
