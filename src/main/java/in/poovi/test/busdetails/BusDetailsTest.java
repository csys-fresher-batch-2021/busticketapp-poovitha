package in.poovi.test.busdetails;

import java.util.List;


import in.poovi.dao.BusDetailsDAO;
import in.poovi.dao.impl.BusDetailsDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;
import in.poovi.model.BusDetails;

public class BusDetailsTest {

	/**
	 * This main method is used list the all bus details.....
	 * 
	 * @param args
	 * @throws DBException
	 */
	public static void main(String[] args) throws DBException {

		BusDetailsDAO busdetailsDAO=new BusDetailsDAOImpl();
		List<BusDetails> busdetails =busdetailsDAO.findAll();
		Logger.info(busdetails);
	}

}
