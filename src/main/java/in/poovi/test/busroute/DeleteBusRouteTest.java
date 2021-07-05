package in.poovi.test.busroute;

import in.poovi.dao.impl.BusRouteDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;

public class DeleteBusRouteTest {

	/**
	 * This main method is used to delete the busroute....
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {
     BusRouteDAOImpl busrouteDAO=new BusRouteDAOImpl();
     int routeno=6;
     busrouteDAO.deleteRoute(routeno);
     Logger.log("deleted" + routeno);
		
	}

}
