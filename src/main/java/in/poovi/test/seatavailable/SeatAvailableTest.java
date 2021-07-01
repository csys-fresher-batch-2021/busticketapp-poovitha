package in.poovi.test.seatavailable;

import in.poovi.dao.SeatAvailableDAO;
import in.poovi.dao.impl.SeatAvailableDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.model.SeatAvailable;

public class SeatAvailableTest {

	/**
	 * This main method is used to get the seat available by busnumber
	 * 
	 * @param args
	 * @throws DBException
	 */
	public static void main(String[] args) throws DBException {

		SeatAvailableDAO seatavailableDAO = new SeatAvailableDAOImpl();
		SeatAvailable seat = new SeatAvailable();
		seat.setBusnumber(1003);
		int seats = seatavailableDAO.findSeatDetailByBusnumber(seat.getBusnumber());
		System.out.println(seats);
	}

}
