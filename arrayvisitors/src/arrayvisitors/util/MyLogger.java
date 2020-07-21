package arrayvisitors.util;

public class MyLogger {

	public enum DebugLevel {
		MY_ARRAY, MY_ARRAYLIST, EXCEPTION, RESULTS, NONE
	};

	private static volatile MyLogger myLoggerInstance;

	private static DebugLevel debugLevel;

	private MyLogger() {
	}

	public static MyLogger getMyLoggerInstance() {
		if (myLoggerInstance == null) {
			synchronized (MyLogger.class) {
				if (myLoggerInstance == null) {
					myLoggerInstance = new MyLogger();
				}
			}
		}

		return myLoggerInstance;
	}

	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 3:
			debugLevel = DebugLevel.RESULTS;
			break;
		case 2:
			debugLevel = DebugLevel.EXCEPTION;
			break;
		case 1:
			debugLevel = DebugLevel.MY_ARRAY;
			break;
		case 0:
			debugLevel = DebugLevel.MY_ARRAYLIST;
			break;
		default:
			debugLevel = DebugLevel.NONE;
			break;
		}
	}

	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	public void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	public String toString() {
		return "The debug level has been set to the following " + debugLevel;
	}
}