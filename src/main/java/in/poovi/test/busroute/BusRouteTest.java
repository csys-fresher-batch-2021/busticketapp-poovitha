package in.poovi.test.busroute;

import in.poovi.model.BusRoute;
import in.poovi.model.service.BusRouteService;

public class BusRouteTest {

	public static void main(String[] args) {
		int routeno = 2;
		String source = "chennai";
		String destination = "madurai";
		BusRoute route = new BusRoute(routeno, source, destination);
		BusRouteService busrouteservice = new BusRouteService();
		busrouteservice.addRouteList(route);

	}

}
