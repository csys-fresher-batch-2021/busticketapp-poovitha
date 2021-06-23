package in.poovi.test.busdetails;

import in.poovi.dao.BusDetailsDAO;
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

		String agency = "jai travels";
		int busnumber = 106;
		String bustype = "AcSleeper";
		String destination = "theni";
		String source = "trichy";
		double amount = 300;
		BusDetails busdetails = new BusDetails(agency, busnumber, bustype, source,destination, amount);
		BusDetailsDAO busdetailsDAO = new BusDetailsDAO();
		busdetailsDAO.save(busdetails);
		System.out.println(busdetails);

	}

}
