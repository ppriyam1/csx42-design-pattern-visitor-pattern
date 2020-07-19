package arrayvisitors.adt;

import java.util.Arrays;
import arrayvisitors.visitors.Visitor;

public class MyArray<T> implements MyArrayI<Integer> {

	private int size;
	private static int INITIAL_CAPACITY = 10;
	private Integer[] myArray;

	public MyArray() {
		this(INITIAL_CAPACITY);
	}

	public MyArray(int initialCapacity) {
		this.size = 0;
		this.myArray = new Integer[initialCapacity];
	}

	@Override
	public void add(Integer dataI) {
		// System.out.println("++++" + dataI);
		if (myArray.length - this.size <= 0) {
			increaseCapacity();
		}
		myArray[size] = dataI;
		size++;
	}

	public void increaseCapacity() {
		myArray = Arrays.copyOf(myArray, myArray.length + (myArray.length / 2));
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

	public int getSize() {
		return size;
	}

	public Integer[] getMyArray() {
		return myArray;
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
