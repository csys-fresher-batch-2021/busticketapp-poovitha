package in.poovi.model;

public class BusRoute {

	private String from;
	private String to;

	public String from() {
		return from;
	}

	public String to() {
		return to;
	}

	public BusRoute(String from, String to) {
		this.from = from;
		this.to = to;

	}

	public BusRoute() {
		super();
	}

	@Override
	public String toString() {
		return "BusRoute [ From=" + from + ", To=" + to + "]";
	}

}
