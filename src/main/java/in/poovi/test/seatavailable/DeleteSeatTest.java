package in.poovi.test.seatavailable;

import in.poovi.dao.SeatAvailableDao;
import in.poovi.exception.DBException;

public class DeleteSeatTest {

	/**
	 * This main method used to test the seat deleted......
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {

		SeatAvailableDao seatavailabledao = new SeatAvailableDao();
		int busnumber = 102;
		seatavailabledao.deleteSeat(busnumber);
		System.out.println("seat deleted" + busnumber);
	}

}
