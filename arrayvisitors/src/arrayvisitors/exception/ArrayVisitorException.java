package arrayvisitors.exception;

import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;

/**
 * @author preetipriyam
 *
 */
public class ArrayVisitorException extends Exception {

	private static final long serialVersionUID = -7813963686940323569L;

	private ErrorCode code;

	/**
	 * @param message
	 */
	public ArrayVisitorException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param errorCode
	 */
	public ArrayVisitorException(ErrorCode code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * @return String: errorCode
	 */
	public String getErrorCode() {
		return this.code.toString();
	}

	/**
	 * @param exception
	 */
	public static void processException(ArrayVisitorException exception) {

		String exceptionMessage = exception.getErrorCode() + ": " + exception.getMessage().getClass().getName();

		MyLogger.getMyLoggerInstance().writeMessage(exceptionMessage, DebugLevel.EXCEPTION);
	}

}
