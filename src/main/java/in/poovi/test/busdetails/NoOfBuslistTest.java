package in.poovi.test.busdetails;

import java.util.HashMap;
import java.util.Set;

import in.poovi.dao.BusDetailsDAO;
import in.poovi.dao.impl.BusDetailsDAOImpl;

public class NoOfBuslistTest {
	/**
	 * This main method is used to display the buslist where busnumber and agency....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		BusDetailsDAO busdetailDAO = new BusDetailsDAOImpl();
		HashMap<String, Integer> buslist = busdetailDAO.noOfBuslist();
		Set<String> keyset = buslist.keySet();
		System.out.println("Agency | Count");
		int count = 0;
		for (String agency : keyset) {
			count = buslist.get(agency);
			System.out.println( agency + "\t\t" + count);

		}
	}

}
