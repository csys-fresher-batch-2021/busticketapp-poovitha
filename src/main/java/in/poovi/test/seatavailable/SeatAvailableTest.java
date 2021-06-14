package in.poovi.test.seatavailable;

import in.poovi.dao.SeatAvailableDao;
import in.poovi.model.SeatAvailable;

public class SeatAvailableTest {

	public static void main(String[] args) throws Exception {

		SeatAvailableDao seatavailabledao=new SeatAvailableDao();
		SeatAvailable seat =new SeatAvailable();
		seat.setBusnumber(102);
		int seats=seatavailabledao.seatDetails(seat.getBusnumber());
		System.out.println(seats);
	}

}
