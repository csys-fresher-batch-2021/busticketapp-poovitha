package in.poovi.test.busdetails;

import in.poovi.dao.BusDetailsDAO;
import in.poovi.dao.impl.BusDetailsDAOImpl;

public class DeleteBusDetailsTest {
	/**
	 * This main method is used to delete the bus details...
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Delete Bus:");
		int busnumber =1006;
		BusDetailsDAO busdetailsDAO = new BusDetailsDAOImpl();
		busdetailsDAO.deleteBus(busnumber);

	}

}
