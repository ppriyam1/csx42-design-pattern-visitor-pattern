package arrayvisitors.adt;

import java.util.Arrays;

import arrayvisitors.exception.VisitorException;
import arrayvisitors.visitors.VisitorI;

/**
 * @author preetipriyam
 *
 */
public final class MyArrayList implements MyArrayListI {

	private static int INITIAL_CAPACITY = 2;

	private int size;

	private Object[] myArray;

	/**
	 * @param initialCapacity
	 */
	public MyArrayList(int initialCapacity) {
		this.size = 0;
		this.myArray = new Object[initialCapacity];
	}

	public MyArrayList() {
		this(INITIAL_CAPACITY);
	}

	private int getSize() {
		return this.size;
	}

	@Override
	public Object[] getMyArrayList() {
		return this.myArray;
	}

	/**
	 * Method to increase the capacity of an arrayList.
	 */
	public void increaseCapacity() {
		this.myArray = Arrays.copyOf(this.myArray, this.myArray.length + (this.myArray.length / 2));
	}

	@Override
	public void add(final MyArrayI myArrayObject) {
		if (this.myArray != null && (myArray.length - this.size <= 0))
			this.increaseCapacity();

		this.myArray[this.size++] = myArrayObject;
	}

	@Override
	public int size() {
		return getSize();
	}

	@Override
	public void accept(VisitorI visitor) throws VisitorException {
		visitor.visit(this);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		MyArrayList list = (MyArrayList) super.clone();
		list.myArray = (Object[]) myArray.clone();
		return list;
	}

	@Override
	protected void finalize() throws Throwable {
	}

	@Override
	public String toString() {
		return "MyArrayList [size=" + size + ", myArrayList=" + Arrays.toString(myArray) + "]";
	}
}
