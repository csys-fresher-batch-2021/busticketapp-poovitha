package in.poovi.test.passenger;

import in.poovi.dao.PassengerListDAO;
import in.poovi.dao.impl.PassengerListDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.model.PassengerModel;

public class AddPassengerList {

	/**
	 * This main method is used to add the passenger details in the list....
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {

		int pid=105;
		String pname="keerthi";
		int page=20;
		String pgender="Female";
		long pmobileno=6666666666L;
		PassengerModel passenger=new PassengerModel(pname,pid,page,pgender,pmobileno);
		PassengerListDAO passengerlistDAO=new PassengerListDAOImpl();
		passengerlistDAO.savePassenger(passenger);
		System.out.println(passenger);
	}

}
