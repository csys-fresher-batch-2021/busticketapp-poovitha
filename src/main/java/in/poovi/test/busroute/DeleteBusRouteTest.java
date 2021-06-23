package in.poovi.test.busroute;

import in.poovi.dao.BusRouteDAO;
import in.poovi.exception.DBException;

public class DeleteBusRouteTest {

	/**
	 * This main method is used to delete the busroute....
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {
     BusRouteDAO busrouteDAO=new BusRouteDAO();
     int routeno=1;
     busrouteDAO.deleteRoute(routeno);
     System.out.println("deleted" + routeno);
		
	}

}
