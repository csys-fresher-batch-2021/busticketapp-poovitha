package in.poovi.test.busroute;

import in.poovi.model.BusRoute;
import in.poovi.model.service.BusRouteService;

public class AddBusRouteTest {
	/**
	 * Main method is used for add the busroute..
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int routeno=1;
		String source="chennai";
		String destination="madurai";
		BusRoute busroute=new BusRoute(routeno,source,destination);
		BusRouteService busrouteservice=new BusRouteService();
		busrouteservice.addRouteList(busroute);
		System.out.println(busroute);
		
	}

}
