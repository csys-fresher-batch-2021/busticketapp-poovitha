package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;


import in.poovi.dao.BusRouteDao;
import in.poovi.model.BusRoute;

public class BusRouteService {

	public static final List<BusRoute> busroute = new ArrayList<>();
	static BusRouteDao busroutedao = new BusRouteDao();

	public static List<BusRoute> getBusRoute() {
		return busroutedao.allBusRoute();
	}

	public void addRouteList(BusRoute busRoute) {
		busroutedao.save(busRoute);
	}

	public static void deleteRoute(int routeno) {

		busroutedao.deleteRoute(routeno);

	}
	

}
