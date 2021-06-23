package in.poovi.test.seatavailable;

import in.poovi.dao.SeatAvailableDAO;
import in.poovi.model.SeatAvailable;

public class SeatAvailableTest {

	/**
	 * This main method is used to get the seat available by busnumber
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		SeatAvailableDAO seatavailableDAO = new SeatAvailableDAO();
		SeatAvailable seat = new SeatAvailable();
		seat.setBusnumber(103);
		int seats = seatavailableDAO.findSeatDetailByBusnumber(seat.getBusnumber());
		System.out.println(seats);
	}

}
