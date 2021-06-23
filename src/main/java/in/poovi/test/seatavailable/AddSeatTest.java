package in.poovi.test.seatavailable;

import in.poovi.model.SeatAvailable;
import in.poovi.model.service.SeatAvailableService;

public class AddSeatTest {

	/**
	 * This main method is used to add the available seat.....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		int busnumber = 103;
		int availableseat = 40;
		int totalseat = 40;
		SeatAvailable seatavailable = new SeatAvailable(busnumber, availableseat, totalseat);
		SeatAvailableService seatavailableservice = new SeatAvailableService();
		seatavailableservice.saveSeat(seatavailable);
		System.out.println(seatavailable);

	}

}
