package arrayvisitors.adt;

import arrayvisitors.visitors.ElementI;

public interface MyArrayListI extends ElementI {

	/**
	 * Method to add objects of myArray to MyArrayList.
	 * 
	 * @param myArray
	 */
	public void add(MyArrayI myArray);

	public int size();

	public Object[] getMyArrayList();

}
