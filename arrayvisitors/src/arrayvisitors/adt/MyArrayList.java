package arrayvisitors.adt;

import java.util.Arrays;

import arrayvisitors.visitors.Visitor;

public class MyArrayList<T> implements MyArrayListI<Object> {

	private int size;
	private static int INITIAL_CAPACITY = 2;
	private Object[] myArrayList;

	public MyArrayList() {
		this(INITIAL_CAPACITY);
	}

	public MyArrayList(int initialCapacity) {
		this.size = 0;
		this.myArrayList = new Object[initialCapacity];
	}

	@Override
	public void add(Object myArrayObject) {
		if (myArrayList.length - this.size <= 0) {
			increaseCapacity();
		}
		myArrayList[size] = myArrayObject;
		// System.out.println(myArrayList[size]);
		size++;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

	public void increaseCapacity() {
		myArrayList = Arrays.copyOf(myArrayList, myArrayList.length + (myArrayList.length / 2));
	}

	public Object[] getMyArrayList() {
		return myArrayList;
	}

}
