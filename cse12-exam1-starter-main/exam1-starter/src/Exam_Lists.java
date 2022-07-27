import java.util.NoSuchElementException;
import java.util.Arrays; // Strictly for Debugging purposes

interface Exam_List<E> {
    void add(E element);
    E[] toArray();
    void flipAround(E element);
}

//TODO: Implement Exam_AList generic class

class Exam_AList<E> implements Exam_List<E> {
	E[] contents;
	int size;
	
	@SuppressWarnings("unchecked")
	public Exam_AList() {
		this.contents = (E[]) new Object[2];
		this.size = 0;
	}
	
	public void add(E element) {
		// double array size if out of range
		if (this.size + 1 > this.contents.length) {
			this.doubleArraySize();
		}
		this.contents[size] = element;
		size ++;
	}
	
	@SuppressWarnings("unchecked")
	public E[] toArray() {
		E[] result = (E[]) new Object[this.size];
		for (int i = 0; i < this.size; i ++) {
			result[i] = this.contents[i];
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public void flipAround(E element) {
		int index = -1;
		for (int i = 0; i < this.size; i ++) {
			if ((element == null || this.contents[i] == null) && (element != this.contents[i])) {
				continue;
			}
			if ((element == null && this.contents[i] == null) || element.equals(this.contents[i])) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			throw new NoSuchElementException();
		}
		if (index == 0 && this.size == 1) {
			return;
		}
		int leftStart = 0;
		int rightStart = index + 1;
		int numElementsAfter = this.size - index - 1;
		E[] newArray = (E[]) new Object[this.contents.length];
		for (int i = 0; i < this.size; i++) {
			if (i < numElementsAfter) {
				newArray[i] = this.contents[rightStart];
				rightStart ++;
			} else if (i == numElementsAfter) {
				newArray[i] = this.contents[index];
			} else {
				newArray[i] = this.contents[leftStart];
				leftStart ++;
			}
		}
		this.contents = newArray;
	}
	
	@SuppressWarnings("unchecked")
	public void doubleArraySize() {
		E[] newArray = (E[]) new Object[this.contents.length * 2];
		for (int i = 0; i < this.size; i ++) {
			newArray[i] = this.contents[i];
		}
		this.contents = newArray;
	}
}

//TODO: Implement Exam_Llist generic class

class Exam_LList<E> implements Exam_List<E> {
	class Exam_Node<E> {
		E value;
		Exam_Node<E> next;
		public Exam_Node(E value) {
			this.value = value;
			this.next = null;
		}
	}
	
	Exam_Node<E> head;
	
	int size;
	
	public Exam_LList() {
		this.head = new Exam_Node<E>(null);
		this.size = 0;
	}
	
	public void add(E element) {
		Exam_Node<E> current = this.head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = new Exam_Node<E>(element);
		size ++;
	}
	
	@SuppressWarnings("unchecked")
	public E[] toArray() {
		E[] result = (E[]) new Object[this.size];
		int index = 0;
		Exam_Node<E> current = this.head;
		while(current.next != null) {
			current = current.next;
			result[index] = current.value;
			index ++;
		}
		return result;
	}
	
	public void flipAround(E element) {
		// find the target
		boolean found = false;
		Exam_Node<E> target = this.head;
		while(target.next != null) {
			target = target.next;
			if ((element == null || target.value == null) && (element != target.value)) {
				continue;
			}
			if ((element == null && target.value == null) || target.value.equals(element)) {
				found = true;
				break;
			}
 		}
		if (!found) {
			throw new NoSuchElementException();
		}
		// return if the target is the only element in the list
		if (this.head.next.equals(target) && target.next == null) {
			return;
		}
		// find the tail
		Exam_Node<E> tail = this.head;
		while(tail.next != null) {
			tail = tail.next;
		}
		// copy the first element
		Exam_Node<E> first = this.head.next;
		// connect the head to the element after the target or the target
		if (target.next != null) {
			this.head.next = target.next;
		} else {
			this.head.next = target;
		}
		// connect the tail to the target
		tail.next = target;
		// connect the target to the first element
		target.next = first;
		// find the element before the target and make it point to null
		Exam_Node<E> current = first;
		while(!current.next.equals(target)) {
			current = current.next;
		}
		current.next = null;
	}
}
