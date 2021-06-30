package in.poovi.test.passenger;

import in.poovi.dao.PassengerListDAO;
import in.poovi.dao.impl.PassengerListDAOImpl;
import in.poovi.exception.DBException;

public class DeletePassengerList {
	/**
	 * Thi main method is used to delete the passenger list
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {

		PassengerListDAO passengerlistDAO = new PassengerListDAOImpl();
        int pid=100;
        passengerlistDAO.deletePassenger(pid);
        System.out.println("passenger number :" +pid+" deleted");
	}

}
