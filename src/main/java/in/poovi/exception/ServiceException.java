package in.poovi.exception;

import in.poovi.logger.Logger;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		Logger.log(message);
	}

}
