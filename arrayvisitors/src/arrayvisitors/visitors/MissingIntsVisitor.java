package arrayvisitors.visitors;

import java.util.Set;
import java.util.TreeSet;

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
public class MissingIntsVisitor implements VisitorI {
	
	MyLogger LOGGER = MyLogger.getMyLoggerInstance();

	private Results results;

	public MissingIntsVisitor(Results resultsI) {
		this.results = resultsI;
	}

	@Override
	public void visit(MyArrayI myArrayVisitI) {
		Set<Integer> missingInt = new TreeSet<Integer>();
		Integer[] myArrays = ((MyArray) myArrayVisitI).getMyArray();
		for (int i = 0; i <= 99; i++) {
			missingInt.add(i);
		}
		for (Integer myArray : myArrays) {
			if (myArray != null) {
				missingInt.remove(myArray);
			}
		}
		results.addMissingInts(missingInt);

	}

	@Override
	public void visit(MyArrayListI myArrayVisit) throws VisitorException{
		String message = ErrorCode.EMPTY_METHOD + ": " + "Behaviour is undefined";
		LOGGER.writeMessage(message, DebugLevel.EXCEPTION);
		throw new VisitorException(message);
	}
	
	@Override
	public String toString() {
		return "MissingIntsVisitor [results=" + results + "]";
	}

}
