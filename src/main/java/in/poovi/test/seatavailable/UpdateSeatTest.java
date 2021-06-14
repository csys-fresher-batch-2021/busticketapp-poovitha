package in.poovi.test.seatavailable;

import in.poovi.dao.SeatAvailableDao;
import in.poovi.model.SeatAvailable;

public class UpdateSeatTest {
	/**
	 * This main is used to update the seat availablity......
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		SeatAvailable seatavailable = new SeatAvailable();
		seatavailable.setBusnumber(102);
		seatavailable.setAvailableSeat(30);
		SeatAvailableDao seatAvailabledao = new SeatAvailableDao();
		seatAvailabledao.updateSeat(seatavailable.getBusnumber(), seatavailable.getAvailableSeat());

	}

}
