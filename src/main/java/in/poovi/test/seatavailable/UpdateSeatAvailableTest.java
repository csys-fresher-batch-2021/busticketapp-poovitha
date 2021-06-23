package in.poovi.test.seatavailable;

import in.poovi.dao.SeatAvailableDAO;
import in.poovi.exception.DBException;
import in.poovi.model.SeatAvailable;

public class UpdateSeatAvailableTest {

	/**
	 * This main method is used to update the seat after booking....
	 * 
	 * @param args
	 * @throws DBException
	 */
	public static void main(String[] args) throws DBException {
		SeatAvailable seatavailable = new SeatAvailable();
		seatavailable.setBusnumber(104);
		SeatAvailableDAO seatAvailableDAO = new SeatAvailableDAO();
		seatAvailableDAO.updateSeatAvailable(seatavailable.getBusnumber());

	}

}
