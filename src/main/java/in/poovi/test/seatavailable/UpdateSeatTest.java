package in.poovi.test.seatavailable;

import in.poovi.dao.SeatAvailableDAO;
import in.poovi.exception.DBException;
import in.poovi.model.SeatAvailable;

public class UpdateSeatTest {
	/**
	 * This main is used to update the seat availablity......
	 * 
	 * @param args
	 * @throws DBException 
	 */

	public static void main(String[] args) throws DBException {
		SeatAvailable seatavailable = new SeatAvailable();
		seatavailable.setBusnumber(103);
		seatavailable.setAvailableSeat(30);
		SeatAvailableDAO seatavailableDAO = new SeatAvailableDAO();
		seatavailableDAO.updateSeat(seatavailable.getBusnumber(), seatavailable.getAvailableSeat());

	}

}
