package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;

public interface VisitorI {

	/**
	 * @param myArrayVisit
	 */
	public void visit(MyArrayI<Integer> myArrayVisit);

	/**
	 * @param myArrayListVisit
	 */
	public void visit(MyArrayListI<MyArrayI<Integer>> myArrayListVisit);
}
