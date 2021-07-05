package in.poovi.test.busroute;

import in.poovi.exception.DBException;
import in.poovi.exception.ServiceException;
import in.poovi.logger.Logger;
import in.poovi.model.BusRoute;
import in.poovi.service.BusRouteService;

public class AddBusRouteTest {
	/**
	 * Main method is used for add the busroute..
	 * 
	 * @param args
	 * @throws ServiceException 
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException, ServiceException {

		int routeno=6;
		String source="chennai";
		String destination="kovai";
		BusRoute busroute=new BusRoute(routeno,source,destination);
		BusRouteService busrouteservice=new BusRouteService();
		busrouteservice.addRouteList(busroute);
		Logger.info(busroute);
		
	}

}
