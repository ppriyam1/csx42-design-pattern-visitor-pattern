package arrayvisitors.exception;

import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;

/**
 * @author preetipriyam
 *
 */
public class MyArrayListException extends ArrayVisitorException {

	private static final long serialVersionUID = 7691646239404602110L;

	private ErrorCode code;

	/**
	 * @param message
	 */
	public MyArrayListException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param errorCode
	 */
	public MyArrayListException(ErrorCode code, String message) {
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
	 * @throws Exception
	 */
	public static void processException(MyArrayListException exception) throws Exception {
		MyLogger.getMyLoggerInstance().writeMessage("Something went wrong in MyArrayList class", DebugLevel.EXCEPTION);
		throw new ArrayVisitorException(exception.getErrorCode() + ": " + exception.getMessage().getClass().getName());
	}

}
