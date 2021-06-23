package in.poovi.test.passenger;

import in.poovi.dao.PassengerListDao;
import in.poovi.exception.DBException;

public class DeletePassengerList {
	/**
	 * Thi main method is used to delete the passenger list
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {

		PassengerListDao passengerlistdao = new PassengerListDao();
        int pid=100;
        passengerlistdao.deletePassenger(pid);
        System.out.println("passenger number :" +pid+" deleted");
	}

}
