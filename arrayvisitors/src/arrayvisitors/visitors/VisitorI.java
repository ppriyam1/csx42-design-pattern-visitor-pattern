package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.exception.VisitorException;

public interface VisitorI {

	/**
	 * Method to visit MyArray class.
	 * 
	 * @param myArrayVisit
	 * @throws VisitorException 
	 */
	public void visit(MyArrayI myArrayVisit) throws VisitorException;

	/**
	 * Method to visit MyArrayList class.
	 * 
	 * @param myArrayListVisit
	 * @throws VisitorException 
	 */
	public void visit(MyArrayListI myArrayListVisit) throws VisitorException;
}
