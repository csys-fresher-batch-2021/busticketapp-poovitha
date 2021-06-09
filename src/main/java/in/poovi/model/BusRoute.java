package in.poovi.model;

public class BusRoute {

	private int routeNo;
	private String source;
	private String destination;

	public BusRoute(int routeNo, String source, String destination) {
		super();
		this.routeNo = routeNo;
		this.source = source;
		this.destination = destination;
	}

	public BusRoute() {
		super();
	}

	public int getRouteNo() {
		return routeNo;
	}

	public void setRouteNo(int routeNo) {
		this.routeNo = routeNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "BusRoute [routeNo=" + routeNo + ", source=" + source + ", destination=" + destination + "]";
	}

}
