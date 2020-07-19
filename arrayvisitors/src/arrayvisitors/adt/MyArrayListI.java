package arrayvisitors.adt;

import arrayvisitors.visitors.ElementI;

public interface MyArrayListI<T extends MyArrayI<Integer>> extends ElementI {

	/**
	 * Method to add objects of myArray to MyArrayList.
	 * 
	 * @param myArray
	 */
	public void add(MyArrayI<Integer> myArray);

	public int size();

	public Object[] getMyArrayList();

}
