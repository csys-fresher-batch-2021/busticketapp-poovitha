package in.poovi.logger;

public class Logger {
	public static Logger getInstance() {
		Logger logger = new Logger();
		return logger;
	}

	public void debug(Object message) {
		System.out.println(message);
	}

	public static void info(Object message) {
		System.out.println(message);
	}

	public static void error(Exception e) {
		e.printStackTrace();
	}

	public void input(Object message) {
		System.out.println(message);
	}

	public static void log(String message) {
		System.out.println(message);
	}
}
