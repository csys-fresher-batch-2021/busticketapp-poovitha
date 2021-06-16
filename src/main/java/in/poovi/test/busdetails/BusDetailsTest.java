package in.poovi.test.busdetails;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BusDetailsDao;
import in.poovi.model.BusDetails;

public class BusDetailsTest {

	/**
	 * This main method is used list the all bus details.....
	 * @param args
	 */
	public static void main(String[] args) {

		BusDetailsDao busdetailsdao=new BusDetailsDao();
		List<BusDetails> busdetails =new ArrayList<>();
		busdetails=busdetailsdao.allBusDetails();
		System.out.println(busdetails);
	}

}
