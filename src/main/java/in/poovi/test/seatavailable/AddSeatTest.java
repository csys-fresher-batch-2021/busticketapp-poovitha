package in.poovi.test.seatavailable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import in.poovi.model.SeatAvailable;
import in.poovi.service.SeatAvailableService;

public class AddSeatTest {
	static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	/**
	 * This main method is used to add the available seat.....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		int busnumber = 1006;
		int availableseat = 40;
		int totalseat = 40;
		final LocalDateTime availableDate = LocalDateTime.parse("2021-06-30 20:10", formatter);
		// DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		// String strDatewithTime = "2015-08-04T10:11:30";
		// LocalDateTime bookedDate =LocalDateTime.parse(strDatewithTime);
        SeatAvailable seatavailable = new SeatAvailable(busnumber, availableseat, totalseat,availableDate);
		SeatAvailableService seatavailableservice = new SeatAvailableService();
		seatavailableservice.saveSeat(seatavailable);
		System.out.println(seatavailable);

	}

}
