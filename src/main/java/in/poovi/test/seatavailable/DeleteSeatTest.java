package in.poovi.test.seatavailable;

import in.poovi.dao.SeatAvailableDao;

public class DeleteSeatTest {

	/**
	 * This main method used to test the seat deleted......
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		SeatAvailableDao seatavailabledao = new SeatAvailableDao();
		int busnumber = 102;
		seatavailabledao.deleteSeat(busnumber);
		System.out.println("seat deleted" + busnumber);
	}

}