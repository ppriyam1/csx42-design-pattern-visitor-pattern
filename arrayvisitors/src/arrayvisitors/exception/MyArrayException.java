package arrayvisitors.exception;

public class MyArrayException extends ArrayVisitorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3698748491797615388L;

	private ErrorCode code;

	/**
	 * @param message
	 */
	public MyArrayException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param errorCode
	 */
	public MyArrayException(ErrorCode code, String message) {
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
	public static void processException(MyArrayException exception) throws Exception {
		throw new ArrayVisitorException(exception.getErrorCode() + ": " + exception.getMessage().getClass().getName());
	}

}
