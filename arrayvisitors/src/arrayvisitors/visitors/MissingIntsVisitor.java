package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;

import java.util.Set;
import java.util.TreeSet;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;

public class MissingIntsVisitor implements Visitor {
	
	private Results results;

	public MissingIntsVisitor(Results resultsI) {
		this.results = resultsI;
	}

	@Override
	public void visit(MyArrayI<Integer> myArrayVisitI) {
		Set<Integer> missingInt = new TreeSet<Integer>();
		Integer[] myArray = ((MyArray<Integer>) myArrayVisitI).getMyArray();
		for(int i = 0; i <= 99; i++) {
			missingInt.add(i);
		}
		for(int i = 0; i < myArray.length; i ++) {
			if(myArray[i] != null) {
				missingInt.remove(myArray[i]);
			}
		}
		results.addMissingInts(missingInt);

		


	}

	@Override
	public void visit(MyArrayListI<Object> myArrayVisit) {
		// TODO throw an exception indicating that the the behavior is undefined

	}

}
