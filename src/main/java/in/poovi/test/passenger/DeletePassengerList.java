package in.poovi.test.passenger;

import in.poovi.dao.PassengerListDao;

public class DeletePassengerList {
	/**
	 * Thi main method is used to delete the passenger list
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		PassengerListDao passengerlistdao = new PassengerListDao();
        int pid=100;
        passengerlistdao.deletePassenger(pid);
        System.out.println("passenger number :" +pid+" deleted");
	}

}
