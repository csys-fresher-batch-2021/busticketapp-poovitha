package in.poovi.test.busroute;

import in.poovi.dao.BusRouteDao;
import in.poovi.exception.DBException;

public class DeleteBusRouteTest {

	/**
	 * This main method is used to delete the busroute....
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {
     BusRouteDao busroutedao=new BusRouteDao();
     int routeno=1;
     busroutedao.deleteRoute(routeno);
     System.out.println("deleted" + routeno);
		
	}

}
