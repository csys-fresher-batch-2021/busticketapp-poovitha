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
public PassengerModel(int pid, String pname, int page, String pgender, long pmobileno) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.page = page;
	this.pgender = pgender;
	this.pmobileno = pmobileno;
}
public PassengerModel() {
	
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
	
	
}