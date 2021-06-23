package in.poovi.test.busdetails;

import java.util.HashMap;
import java.util.Set;

import in.poovi.dao.BusDetailsDAO;

public class NoOfBuslistTest {
	/**
	 * This main method is used to display the buslist where busnumber and agency....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		BusDetailsDAO busdetailDAO = new BusDetailsDAO();
		HashMap<String, Integer> buslist = busdetailDAO.noOfBuslist();
		Set<String> keyset = buslist.keySet();
		System.out.println("Bus No | Agency");
		int number = 0;
		for (String agency : keyset) {
			number = buslist.get(agency);
			System.out.println(number + "\t" + agency);

		}
	}

}
