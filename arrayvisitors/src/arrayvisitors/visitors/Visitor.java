package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;

public interface Visitor {

	public void visit(MyArrayI<Integer> myArrayVisit);
	
	public void visit(MyArrayListI<Object> myArrayVisit);
}
