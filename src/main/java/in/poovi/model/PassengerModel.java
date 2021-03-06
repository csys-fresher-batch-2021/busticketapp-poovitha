package in.poovi.model;

public class PassengerModel {
	private int pid;
	private String pname;
	private int page;
	private String pgender;
	private long pmobileno;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getPgender() {
		return pgender;
	}


	public void setPgender(String pgender) {
		this.pgender = pgender;
	}

	public long getPmobileno() {
		return pmobileno;
	}

	public void setPmobileno(long pmobileno) {
		this.pmobileno = pmobileno;
	}
	
	public PassengerModel(String pname, int pid, int page, String pgender, long pmobileno) {
		super();
		this.pname = pname;
		this.pid = pid;
		this.page = page;
		this.pgender = pgender;
		this.pmobileno = pmobileno;
	}

	public PassengerModel() {
		super();
	}

	

}