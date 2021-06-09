package in.poovi.exception;

public class ValidationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
		System.out.println(message);
	}

}
