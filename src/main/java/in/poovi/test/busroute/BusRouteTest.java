package in.poovi.test.busroute;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BusRouteDao;
import in.poovi.exception.DBException;
import in.poovi.model.BusRoute;

public class BusRouteTest {

	/**
	 * This main method is used to list the route details.....
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {
		BusRouteDao busroutedao=new BusRouteDao();
		List<BusRoute> busroute =new ArrayList<>();
		busroute=busroutedao.findAllBusRoute();
		System.out.println(busroute);

		
	}

}
