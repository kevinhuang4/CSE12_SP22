
public class CircularArrayList<T> implements ArrayListADT<T>{
	
	int capacity;
	int size;
	int front;
	int rear;
	T[] arrayList;
	
	// @SuppressWarnings("unchecked")
	public CircularArrayList() {
		this.arrayList = (T[])new Object[100];
		this.size = 0;
		this.front = 0;
		this.rear = size;
	}

	// @SuppressWarnings("unchecked")
	public CircularArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("initial capacity must not be negative");
		}
		this.capacity = initialCapacity;
		this.arrayList = (T[]) new Object[initialCapacity];
		this.size = 0;
		this.front = 0;
		this.rear = size;
	}

	@Override
	public void addRear(T element) {
		expandCapacity();
		arrayList[rear] = element;
		size += 1;
		rear += 1;
	}

	@Override
	public void addFront(T element) {
		expandCapacity();
		front -= 1;
		if (front == -1) {
			front = capacity - 1;
		}
		arrayList[front] = element;
		size += 1;
	}

	public T get(int index) throws Exception {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return arrayList[indexFor(index)];
	}
	
	@Override
	public T remove() {
		if (size == 0) {
			return null;
		}
		T e = arrayList[front];
		arrayList[front] = null;
		front += 1;
		if (front == capacity) {
			front = 0;
		}
		size -= 1;
		return e;
	}
	
	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public int getRear() {
		return this.rear;
	}

	@Override
	public int getFront() {
		return this.front;
	}

	@Override
	public int getCapacity() {
		return this.capacity;
	}

	// @SuppressWarnings("unchecked")
	private void expandCapacity() {
		if (capacity == 0) {
			T[] newAL = (T[])new Object[1];
			arrayList = null;
			arrayList = newAL;
			front = 0;
			capacity = 1;
		}
		if (size == capacity) {
			T[] newAL = (T[])new Object[capacity * 2];
			for (int i = 0; i < size; i++) {
				newAL[i] = arrayList[indexFor(i)];
			}
			capacity *= 2;
			arrayList = null;
			arrayList = newAL;
			front = 0;
			rear = size;
		}
	}

	private int indexFor(int i) {
		return (front + i) % capacity;
	}
	
}
