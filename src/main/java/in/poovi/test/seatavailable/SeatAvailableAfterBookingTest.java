package in.poovi.test.seatavailable;

import in.poovi.dao.SeatAvailableDAO;
import in.poovi.dao.impl.SeatAvailableDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.model.SeatAvailable;

public class SeatAvailableAfterBookingTest {
	/**
	 * main method is used to diplay seats after the booking
	 * 
	 * @param args
	 * @throws DBException
	 */
	public static void main(String[] args) throws DBException {
		SeatAvailable seatavailable = new SeatAvailable();
		seatavailable.setBusnumber(1000);
		SeatAvailableDAO seatavailableDAO = new SeatAvailableDAOImpl();
		seatavailableDAO.updateSeatAvailable1(seatavailable.getBusnumber());

	}

}
