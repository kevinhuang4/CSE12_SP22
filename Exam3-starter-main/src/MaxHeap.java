
import java.util.*;

public class MaxHeap<K, V> {

List<HeapEntry<K,V>> entries;
int capacity;
int heapSize = 0;
Comparator comparator;

    public MaxHeap(int capacity, Comparator comparator){
		this.entries = new ArrayList<>();
		this.capacity = capacity;
		this.comparator = comparator;
    }

	public void add(K key, V value){
		if (key == null) {
			return;
		}
		HeapEntry<K,V> hEntry = new HeapEntry<>(key, value);
		entries.add(hEntry);
		this.heapSize += 1;
		bubbleUp(entries.size() - 1);
	}

	public HeapEntry<K,V> peek() {
		if (entries.size() == 0) {
            return null;
        }
        return entries.get(0);
	}
	
	public HeapEntry<K,V> remove() {
		if (entries.size() == 0) {
            return null;
        }
        HeapEntry<K,V> root = entries.get(0);
        swap(0, entries.size() - 1);
        entries.remove(entries.size() - 1);
        bubbleDown(0);
        heapSize -= 1;
        return root;
	}
	
	@SuppressWarnings("unchecked")
	private void bubbleUp(int index) {
		if (index <= 0) {
            return;
        }
        HeapEntry<K,V> hEntry = entries.get(index);
        HeapEntry<K,V> parent = entries.get(parent(index));
        int comp = comparator.compare(hEntry.getValue(), parent.getValue());
        if (comp > 0) {
            swap(index, parent(index));
            bubbleUp(parent(index));
        } else {
            return;
        }
	}

	private void bubbleDown(int index) {
        if (index >= entries.size()) {
            return;
        }
        int leftIndex = left(index);
        if (leftIndex >= entries.size()) {
            return;
        }
        int rightIndex = right(index);
        int largerChildIndex = leftIndex;
        if (existsAndGreater(rightIndex, leftIndex)) {
            largerChildIndex = rightIndex;
        }
        if (existsAndGreater(largerChildIndex, index)) {
            swap(largerChildIndex, index);
            bubbleDown(largerChildIndex);
        }
    }

	private void swap(int i1, int i2) {
        HeapEntry<K,V> temp = entries.get(i1);
        entries.set(i1, entries.get(i2));
        entries.set(i2, temp);
        temp = null;
    }

	private int parent(int index) {
		return (index - 1) / 2;
	}

	private int left(int index) {
        return index * 2 + 1;
    }

	private int right(int index) {
        return index * 2 + 2;
    }

	@SuppressWarnings("unchecked")
	private boolean existsAndGreater(int index1, int index2) {
        if (index1 < entries.size() && index2 < entries.size()) {
            V val1 = entries.get(index1).value;
            V val2 = entries.get(index2).value;
            if (comparator.compare(val1, val2) > 0) {
                return true;
            }
        }
        return false;
    }

    public List<HeapEntry<K,V>> getEntries() {
        return entries;
    }
}

class HeapEntry<K, V> implements DefaultMap.Entry<K,V>{
	K key;
	V value;

	HeapEntry(K key, V value){
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}

	public void setValue(V value){
		this.value = value;
	}
}