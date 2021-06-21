package in.poovi.test.passenger;

import in.poovi.dao.PassengerListDao;

public class UpdatePassengerList {
	/**
	 * This main method is used to update the passenger details....
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String pname="puvi";
		long pmobileno=9898989898L;
		PassengerListDao passengerlistdao=new PassengerListDao();
		passengerlistdao.updateMobileno(pmobileno, pname);
		
	}

}
