package in.poovi.test.seatavailable;

import in.poovi.dao.SeatAvailableDAO;
import in.poovi.dao.impl.SeatAvailableDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.model.SeatAvailable;

public class Test {

	public static void main(String[] args) throws DBException {
		// TODO Auto-generated method stub
		SeatAvailable seatavailable = new SeatAvailable();
		seatavailable.setBusnumber(1003);
		SeatAvailableDAO seatavailableDAO = new SeatAvailableDAOImpl();
		seatavailableDAO.updateSeatAvailable1(seatavailable.getBusnumber());

	}

}
