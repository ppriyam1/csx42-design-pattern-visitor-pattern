package arrayvisitors.exception;

import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;

/**
 * @author preetipriyam
 *
 */
public class VisitorException extends ArrayVisitorException {
	
	private static final long serialVersionUID = 6125400767045125984L;
	
	private ErrorCode code;

	/**
	 * @param message
	 */
	public VisitorException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param errorCode
	 */
	public VisitorException(ErrorCode code, String message) {
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
	public static void processException(VisitorException exception) throws Exception {
		MyLogger.getMyLoggerInstance().writeMessage("Something went wrong while performing Visitor actions", DebugLevel.EXCEPTION);
		throw new ArrayVisitorException(exception.getErrorCode() + ": " + exception.getMessage().getClass().getName());
	}

}
