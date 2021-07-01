package in.poovi.test.busdetails;

import in.poovi.dao.BusDetailsDAO;
import in.poovi.dao.impl.BusDetailsDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.model.BusDetails;

public class AddBusDetailsTest {

	/**
	 * This main method is used to add bus details.....
	 * 
	 * @param args
	 * @throws DBException
	 */
	public static void main(String[] args) throws DBException {

		String agency = "pvs travels";
		int busnumber = 1006;
		String bustype = "AcSeater";
		String destination = "vilupuram";
		String source = "chennai";
		double amount = 400;
		BusDetails busdetails = new BusDetails(agency, busnumber, bustype, source, destination, amount);
		BusDetailsDAO busdetailsDAO = new BusDetailsDAOImpl();
		busdetailsDAO.save(busdetails);
		System.out.println(busdetails);

	}

}
