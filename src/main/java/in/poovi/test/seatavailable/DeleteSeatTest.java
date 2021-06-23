package in.poovi.test.seatavailable;

import in.poovi.dao.SeatAvailableDAO;
import in.poovi.exception.DBException;

public class DeleteSeatTest {

	/**
	 * This main method used to test the seat deleted......
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {

		SeatAvailableDAO seatavailableDAO = new SeatAvailableDAO();
		int busnumber = 102;
		seatavailableDAO.deleteSeat(busnumber);
		System.out.println("seat deleted" + busnumber);
	}

}
