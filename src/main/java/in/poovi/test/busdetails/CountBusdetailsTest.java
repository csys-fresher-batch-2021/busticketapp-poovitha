package in.poovi.test.busdetails;

import in.poovi.dao.BusDetailsDAO;

public class CountBusdetailsTest {

	/**
	 * This method is used to count the busdetails....
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		BusDetailsDAO busdetailsDAO=new BusDetailsDAO();
		int buscount=busdetailsDAO.noOfBuses();
        System.out.println(buscount);
	}

}
