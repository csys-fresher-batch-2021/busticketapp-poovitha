package in.poovi.exception;

import in.poovi.logger.Logger;

public class ValidationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
		Logger.log(message);
	}

}
