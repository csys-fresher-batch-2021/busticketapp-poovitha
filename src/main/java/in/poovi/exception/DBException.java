package in.poovi.exception;

import in.poovi.logger.Logger;

public class DBException extends Exception {

	private static final long serialVersionUID = 1L;

	public DBException(Exception e, String message) {
		Logger.log(message);
	}

}
