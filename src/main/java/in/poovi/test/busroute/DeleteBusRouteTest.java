package in.poovi.test.busroute;

import in.poovi.dao.BusRouteDao;

public class DeleteBusRouteTest {

	/**
	 * This main method is used to delete the busroute....
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
     BusRouteDao busroutedao=new BusRouteDao();
     int routeno=1;
     busroutedao.deleteRoute(routeno);
     System.out.println("deleted" + routeno);
		
	}

}
