package in.poovi.test.busroute;

import java.util.List;

import in.poovi.dao.impl.BusRouteDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;
import in.poovi.model.BusRoute;

public class BusRouteTest {

	/**
	 * This main method is used to list the route details.....
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {
		BusRouteDAOImpl busrouteDAO=new BusRouteDAOImpl();
		List<BusRoute> busroute =busrouteDAO.findAll();
		Logger.info(busroute);

		
	}

}
