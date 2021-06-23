package in.poovi.test.seatavailable;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.SeatAvailableDao;
import in.poovi.model.SeatAvailable;

public class TotalSeatAvailableTest {

	/**
	 * This main method is used for display the available seats.....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SeatAvailableDao seatavailabledao = new SeatAvailableDao();
		List<SeatAvailable> seat = new ArrayList<>();
		seat = seatavailabledao.findAllAvailableSeat();
		System.out.println(seat);

	}

}
