package in.poovi.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		System.out.println(message);
	}

}
