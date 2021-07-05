package in.poovi.test.seatavailable;

import in.poovi.dao.SeatAvailableDAO;
import in.poovi.dao.impl.SeatAvailableDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;

public class DeleteSeatTest {

	/**
	 * This main method used to test the seat deleted......
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {

		SeatAvailableDAO seatavailableDAO = new SeatAvailableDAOImpl();
		int busnumber = 1006;
		seatavailableDAO.deleteSeat(busnumber);
		Logger.log("seat deleted" + busnumber);
	}

}
