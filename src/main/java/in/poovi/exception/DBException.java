package in.poovi.exception;

public class DBException extends Exception {

	private static final long serialVersionUID = 1L;

	public DBException(Exception e, String message) {
		System.out.println(message);
	}

}
