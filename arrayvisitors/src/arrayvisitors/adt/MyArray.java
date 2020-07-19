package arrayvisitors.adt;

import java.util.Arrays;

import arrayvisitors.visitors.VisitorI;

/**
 * @author preetipriyam
 *
 * @param <T>
 */
public class MyArray<T extends Object> implements MyArrayI<Integer> {

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
		visitor.visit(this);
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
