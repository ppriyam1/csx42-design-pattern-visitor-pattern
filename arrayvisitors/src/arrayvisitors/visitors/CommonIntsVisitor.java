package arrayvisitors.visitors;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.exception.ErrorCode;
import arrayvisitors.exception.VisitorException;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.Results;
import arrayvisitors.util.MyLogger.DebugLevel;

/**
 * @author preetipriyam
 *
 */
public class CommonIntsVisitor implements VisitorI {

	private Results results;
	MyLogger LOGGER = MyLogger.getMyLoggerInstance();

	public CommonIntsVisitor(Results resultsI) {
		this.results = resultsI;
	}

	@Override
	public void visit(MyArrayI myArrayVisit) throws VisitorException {
		String message = ErrorCode.EMPTY_METHOD + ": " + "Behaviour is undefined";
		LOGGER.writeMessage(message, DebugLevel.EXCEPTION);
		throw new VisitorException(message);
	}

	@Override
	public void visit(MyArrayListI myArrayListVisitI) {

		Object[] myArrayListVisit = myArrayListVisitI.getMyArrayList();

		Integer[] arrayList1 = ((MyArray) myArrayListVisit[0]).getMyArray();

		Integer[] arrayList2 = ((MyArray) myArrayListVisit[1]).getMyArray();

		for (int i = 0; i < arrayList1.length; i++) {
			for (int j = 0; j < arrayList2.length; j++) {

				if (arrayList1[i] != null && arrayList2[j] != null) {
					if (arrayList1[i] == arrayList2[j]) {
						results.addCommonInt(arrayList1[i]);
					}
				}
			}
		}

	}

	@Override
	public String toString() {
		return "CommonIntsVisitor [results=" + results + "]";
	}

}
