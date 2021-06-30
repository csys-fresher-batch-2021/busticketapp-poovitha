package in.poovi.test.passenger;

import in.poovi.dao.PassengerListDAO;
import in.poovi.dao.impl.PassengerListDAOImpl;
import in.poovi.exception.DBException;

public class UpdatePassengerList {
	/**
	 * This main method is used to update the passenger details....
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {

		String pname="puvi";
		long pmobileno=9898989898L;
		PassengerListDAO passengerlistDAO=new PassengerListDAOImpl();
		passengerlistDAO.updateMobileno(pmobileno, pname);
		
	}

}
