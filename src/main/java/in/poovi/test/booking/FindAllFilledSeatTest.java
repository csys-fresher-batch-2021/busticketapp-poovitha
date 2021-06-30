package in.poovi.test.booking;

import java.util.HashMap;
import java.util.Set;

import in.poovi.dao.BookingDAO;
import in.poovi.dao.impl.BookingDAOImpl;
import in.poovi.exception.DBException;

public class FindAllFilledSeatTest {

	public static void main(String[] args) throws DBException {
		BookingDAO bookingDAO = new BookingDAOImpl();
		HashMap<Integer, Integer> total = bookingDAO.findFilledSeats();
		Set<Integer> keyset = total.keySet();
		System.out.println("busnumber | filledSeat");
		Integer filledSeat;
		for (Integer busnumber : keyset) {
			filledSeat = total.get(busnumber);
			System.out.println(busnumber + "\t\t" + filledSeat);

		}
	}

}
