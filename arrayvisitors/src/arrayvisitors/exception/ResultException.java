package arrayvisitors.exception;

import arrayvisitors.util.MyLogger;
import arrayvisitors.util.MyLogger.DebugLevel;

/**
 * @author preetipriyam
 *
 */
public class ResultException extends ArrayVisitorException {

	private static final long serialVersionUID = 7467057032129109149L;

	private ErrorCode code;

	/**
	 * @param message
	 */
	public ResultException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param errorCode
	 */
	public ResultException(ErrorCode code, String message) {
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
	public static void processException(ResultException exception) throws Exception {
		MyLogger.getMyLoggerInstance().writeMessage("Something went wrong in Results class", DebugLevel.EXCEPTION);
		throw new ArrayVisitorException(exception.getErrorCode() + ": " + exception.getMessage().getClass().getName());
	}

}
