package arrayvisitors.visitors;

import java.util.Set;
import java.util.TreeSet;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.Results;

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
	public void visit(MyArrayListI myArrayVisit) {
		// TODO throw an exception indicating that the the behavior is undefined
	}
	
	@Override
	public String toString() {
		return "MissingIntsVisitor [results=" + results + "]";
	}

}
