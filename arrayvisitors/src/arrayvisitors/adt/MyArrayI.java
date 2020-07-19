package arrayvisitors.adt;

import arrayvisitors.visitors.Element;

public interface MyArrayI<T> extends Element {

	/**
	 * Method to add element to an array.
	 * 
	 * @param type
	 */
	void add(T type);
	
	/**
	 * Method to return the elements present in array.
	 * 
	 * @return
	 */
	int size();

}
