package in.poovi.test.busdetails;

import in.poovi.dao.BusDetailsDAO;
import in.poovi.dao.impl.BusDetailsDAOImpl;
import in.poovi.logger.Logger;

public class CountBusdetailsTest {

	/**
	 * This method is used to count the busdetails....
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		BusDetailsDAO busdetailsDAO=new BusDetailsDAOImpl();
		int buscount=busdetailsDAO.noOfBuses();
        Logger.info(buscount);
	}

}
