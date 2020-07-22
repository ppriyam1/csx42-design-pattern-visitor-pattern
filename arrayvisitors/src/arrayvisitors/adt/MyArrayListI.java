package arrayvisitors.adt;

import arrayvisitors.visitors.ElementI;

public interface MyArrayListI extends ElementI {

	/**
	 * Method to add objects of myArray to MyArrayList.
	 * 
	 * @param myArray
	 */
	public void add(MyArrayI myArray);

	/**
	 * Method to return the elements present in array.
	 * 
	 * @return
	 */
	public int size();

	/**
	 * Method to return objects of MyArray.
	 * 
	 * @return
	 */
	public Object[] getMyArrayList();

}
