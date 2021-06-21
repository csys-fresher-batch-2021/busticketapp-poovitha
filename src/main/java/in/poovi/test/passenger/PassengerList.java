package in.poovi.test.passenger;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.PassengerListDao;
import in.poovi.model.PassengerModel;

public class PassengerList {

	/**
	 * This main method is used to list the all passenger list
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		PassengerListDao passengerlistdao = new PassengerListDao();
		List<PassengerModel> passenger = new ArrayList<>();
		passenger=passengerlistdao.allPassengerList();
		System.out.println(passenger);

	}

}
