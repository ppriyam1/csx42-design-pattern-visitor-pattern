package arrayvisitors.adt;

import arrayvisitors.visitors.Element;

public interface MyArrayListI<T> extends Element {

	/**
	 * Method to add objects of myArray to MyArrayList.
	 * 
	 * @param type
	 */
	void add(T type);
	
}
