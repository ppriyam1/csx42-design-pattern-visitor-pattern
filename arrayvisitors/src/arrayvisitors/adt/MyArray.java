package arrayvisitors.adt;

import java.util.Arrays;

import arrayvisitors.exception.VisitorException;
import arrayvisitors.visitors.VisitorI;

/**
 * @author preetipriyam
 *
 */
public final class MyArray implements MyArrayI {

	private static final int INITIAL_CAPACITY = 10;

	private Integer[] myArray;
	private int size;

	/**
	 * @param initialCapacity
	 */
	public MyArray(int initialCapacity) {
		this.size = 0;
		this.myArray = new Integer[initialCapacity];
	}

	public MyArray() {
		this(INITIAL_CAPACITY);
	}

	public int getSize() {
		return size;
	}

	public Integer[] getMyArray() {
		return myArray;
	}

	/**
	 * Method to increase the capacity of an array.
	 */
	protected void increaseCapacity() {
		this.myArray = Arrays.copyOf(myArray, myArray.length + (myArray.length / 2));
	}

	@Override
	public void add(final Integer dataI) {
		if (this.myArray != null && (this.myArray.length - this.size) <= 0)
			this.increaseCapacity();

		this.myArray[this.size++] = dataI;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void accept(VisitorI visitor) {
		try {
			visitor.visit(this);
		} catch (VisitorException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		MyArray array = (MyArray) super.clone();
		array.myArray = (Integer[]) myArray.clone();
		return array;
	}

	@Override
	protected void finalize() throws Throwable {
	}

	@Override
	public String toString() {
		String array = "";
		for (int i = 0; i < size; i++) {
			array += myArray[i] + " ";
		}
		return array;
	}

}
