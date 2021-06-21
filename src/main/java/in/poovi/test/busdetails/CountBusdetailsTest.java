package in.poovi.test.busdetails;

import in.poovi.dao.BusDetailsDao;

public class CountBusdetailsTest {

	/**
	 * This method is used to count the busdetails....
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		BusDetailsDao busdetailsdao=new BusDetailsDao();
		int buscount=busdetailsdao.noOfBuses();
        System.out.println(buscount);
	}

}
