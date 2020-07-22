package arrayvisitors.adt;

import arrayvisitors.visitors.ElementI;

public interface MyArrayI extends ElementI {

	/**
	 * Method to add element to an array.
	 * 
	 * @param integer
	 */
	void add(String integer);

	/**
	 * Method to return the elements present in array.
	 * 
	 * @return
	 */
	int size();

}
