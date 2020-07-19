package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArray;

public class CommonIntsVisitor implements Visitor {

	private Results results;

	public CommonIntsVisitor(Results resultsI) {
		this.results = resultsI;
	}

	@Override
	public void visit(MyArrayI<Integer> myArrayVisit) {
		// TODO throw an exception indicating that the the behavior is undefined
	}

	@Override
	public void visit(MyArrayListI<Object> myArrayListVisitI) {

		Object[] myArrayListVisit = ((MyArrayList<Object>) myArrayListVisitI).getMyArrayList();

		@SuppressWarnings("unchecked")
		Integer[] arrayList1 = ((MyArray<Integer>) myArrayListVisit[0]).getMyArray();
		@SuppressWarnings("unchecked")
		Integer[] arrayList2 = ((MyArray<Integer>) myArrayListVisit[1]).getMyArray();

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

}
