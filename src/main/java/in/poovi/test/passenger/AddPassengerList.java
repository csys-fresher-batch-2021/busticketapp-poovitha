package in.poovi.test.passenger;

import in.poovi.dao.PassengerListDao;
import in.poovi.model.PassengerModel;

public class AddPassengerList {

	/**
	 * This main method is used to add the passenger details in the list....
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int pid=104;
		String pname="pavi";
		int page=20;
		String pgender="Female";
		long pmobileno=9999980000L;
		PassengerModel passenger=new PassengerModel(pname,pid,page,pgender,pmobileno);
		PassengerListDao passengerlistdao=new PassengerListDao();
		passengerlistdao.savePassenger(passenger);
		System.out.println(passenger);
	}

}
