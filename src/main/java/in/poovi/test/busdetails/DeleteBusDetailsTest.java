package in.poovi.test.busdetails;

import in.poovi.dao.BusDetailsDAO;
import in.poovi.dao.impl.BusDetailsDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;

public class DeleteBusDetailsTest {
	/**
	 * This main method is used to delete the bus details...
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {
		Logger.log("Delete Bus:");
		int busnumber =1007;
		BusDetailsDAO busdetailsDAO = new BusDetailsDAOImpl();
		busdetailsDAO.deleteBus(busnumber);

	}

}
