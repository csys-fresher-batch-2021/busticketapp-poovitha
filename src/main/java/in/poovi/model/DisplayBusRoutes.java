package in.poovi.model;

public class DisplayBusRoutes {
	
	private String from;
	private String to;
	  
	public String from()
	{
		return from;
	}
	public String to()
	{
		return to;
	}
	public  DisplayBusRoutes(String from, String to) 
	{
		this.from=from;
		this.to=to;
		
	}

	@Override
	public String toString() {
		return "BusRoute [ From=" +from +  ", To="+ to + "]";
	}


	

}
