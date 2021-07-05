package in.poovi.test.seatavailable;

import java.util.List;

import in.poovi.dao.SeatAvailableDAO;
import in.poovi.dao.impl.SeatAvailableDAOImpl;
import in.poovi.logger.Logger;
import in.poovi.model.SeatAvailable;

public class TotalSeatAvailableTest {

	/**
	 * This main method is used for display the available seats.....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SeatAvailableDAO seatavailableDAO = new SeatAvailableDAOImpl();
		List<SeatAvailable> seat = seatavailableDAO.findAll();
		Logger.info(seat);

	}

}
