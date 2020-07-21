package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.exception.PopulateMyArrayVisitorException;

public interface VisitorI {

	/**
	 * @param myArrayVisit
	 * @throws PopulateMyArrayVisitorException 
	 */
	public void visit(MyArrayI myArrayVisit) throws PopulateMyArrayVisitorException;

	/**
	 * @param myArrayListVisit
	 */
	public void visit(MyArrayListI myArrayListVisit);
}
