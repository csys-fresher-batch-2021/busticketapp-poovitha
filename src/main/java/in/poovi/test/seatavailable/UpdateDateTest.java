package in.poovi.test.seatavailable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import in.poovi.dao.SeatAvailableDAO;
import in.poovi.dao.impl.SeatAvailableDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.model.SeatAvailable;

public class UpdateDateTest {
	final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	public static void main(String[] args) throws DBException {
		SeatAvailable seatavailable = new SeatAvailable();
		seatavailable.setBusnumber(1002);
		final LocalDateTime availabledate = LocalDateTime.parse("2021-06-30 19:30", formatter);

		seatavailable.setAvailableDate(availabledate);
		SeatAvailableDAO seatavailableDAO = new SeatAvailableDAOImpl();
		seatavailableDAO.updateDate(seatavailable.getBusnumber(), seatavailable.getAvailableDate());

	}

}
