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
	 * Method to return the element at specified index.
	 * 
	 * @param position
	 * @return
	 */
	Integer get(int position);
	
	/**
	 * Method to verify if the element is in array.
	 * 
	 * @param position
	 * @return
	 */
	boolean contains(int position);
	
	/**
	 * Method to return the elements present in array.
	 * 
	 * @return
	 */
	int size();

}
