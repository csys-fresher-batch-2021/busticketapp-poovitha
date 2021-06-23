package in.poovi.test.seatavailable;

import in.poovi.dao.SeatAvailableDao;
import in.poovi.model.SeatAvailable;

public class UpdateSeatAvailableTest {

	public static void main(String[] args) {
		SeatAvailable seatavailable = new SeatAvailable();
		seatavailable.setBusnumber(104);
		SeatAvailableDao seatAvailabledao = new SeatAvailableDao();
		seatAvailabledao.updateSeatAvailable(seatavailable.getBusnumber());

	}

}
