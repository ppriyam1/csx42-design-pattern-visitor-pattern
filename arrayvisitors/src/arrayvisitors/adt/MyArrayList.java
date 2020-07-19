package arrayvisitors.adt;

import java.util.Arrays;

import arrayvisitors.visitors.VisitorI;

public class MyArrayList<T extends MyArrayI<Integer>> implements MyArrayListI<MyArrayI<Integer>> {

	private static int INITIAL_CAPACITY = 2;

	private int size;

	private Object[] myArrayList;

	/**
	 * @param initialCapacity
	 */
	public MyArrayList(int initialCapacity) {
		this.size = 0;
		this.myArrayList = new Object[initialCapacity];
	}

	public MyArrayList() {
		this(INITIAL_CAPACITY);
	}

	private int getSize() {
		return this.size;
	}

	@Override
	public Object[] getMyArrayList() {
		return this.myArrayList;
	}

	public void increaseCapacity() {
		this.myArrayList = Arrays.copyOf(this.myArrayList, this.myArrayList.length + (this.myArrayList.length / 2));
	}

	@Override
	public void add(final MyArrayI<Integer> myArrayObject) {
		if (this.myArrayList != null && (myArrayList.length - this.size <= 0))
			this.increaseCapacity();

		this.myArrayList[this.size++] = myArrayObject;
	}

	@Override
	public int size() {
		return getSize();
	}

	@Override
	public void accept(VisitorI visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "MyArrayList [size=" + size + ", myArrayList=" + Arrays.toString(myArrayList) + "]";
	}
}
