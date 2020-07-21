package arrayvisitors.exception;

public class PopulateMyArrayVisitorException extends ArrayVisitorException {
	
	private static final long serialVersionUID = 6125400767045125984L;
	
	private ErrorCode code;

	/**
	 * @param message
	 */
	public PopulateMyArrayVisitorException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param errorCode
	 */
	public PopulateMyArrayVisitorException(ErrorCode code, String message) {
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
	public static void processException(PopulateMyArrayVisitorException exception) throws Exception {
		throw new ArrayVisitorException(exception.getErrorCode() + ": " + exception.getMessage().getClass().getName());
	}

}
