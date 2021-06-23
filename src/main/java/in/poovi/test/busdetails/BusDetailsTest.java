package in.poovi.test.busdetails;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BusDetailsDAO;
import in.poovi.exception.DBException;
import in.poovi.model.BusDetails;

public class BusDetailsTest {

	/**
	 * This main method is used list the all bus details.....
	 * 
	 * @param args
	 * @throws DBException
	 */
	public static void main(String[] args) throws DBException {

		BusDetailsDAO busdetailsDAO=new BusDetailsDAO();
		List<BusDetails> busdetails =new ArrayList<>();
		busdetails=busdetailsDAO.findAll();
		System.out.println(busdetails);
	}

}
