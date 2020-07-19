package arrayvisitors.adt;

import arrayvisitors.visitors.ElementI;

public interface MyArrayI<T extends Object> extends ElementI {

	/**
	 * Method to add element to an array.
	 * 
	 * @param integer
	 */
	void add(Integer integer);

	/**
	 * Method to return the elements present in array.
	 * 
	 * @return
	 */
	int size();

}
