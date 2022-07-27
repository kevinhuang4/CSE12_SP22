/**
 * Heap.java is an implementation of heap.
 * It implements all the methods in the PriorityQueue interface and additional methods.
 */

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;

class Entry<K, V> {
    K key; // aka the _priority_
    V value;
    public Entry(K k, V v) { key = k; value = v; }
    public String toString() {
        return key + ": " + value;
    }
}

public class Heap<K, V> implements PriorityQueue<K,V> {
    public List<Entry<K, V>> entries;
    public Comparator<K> comparator;

    /**
     * Heap constructor
     * initializes instance variables
     * @param comparator used to determine which entry objects have more priority 
     * based on their keys
     */
    public Heap(Comparator<K> comparator) {
        this.entries = new ArrayList<>();
        this.comparator = comparator;
    }
    /**
     * Inserts a new entry with the given key and value to the end of the heap.
     * Then, bubbleUp so that the heap properties are not violated.
     * @param k the given key
     * @param v the given value
     */
    @Override
    public void add(K k, V v) {
        if (k == null) {
            return;
        }
        Entry<K,V> entry = new Entry<>(k, v);
        entries.add(entry);
        bubbleUp(entries.size() - 1);
    }

    /**
     * Remove and return the root element of the heap. 
     * Set the last entry in the heap to the root. 
     * Use bubbleDown to fix the heap after the removal. 
     * If the size is zero, throw NoSuchElementException()
     * @return the root element in the heap
     * @throws NoSuchElementException if size is 0
     */
    @Override
    public Entry<K, V> poll() throws NoSuchElementException {
        if (entries.size() == 0) {
            throw new NoSuchElementException();
        }
        Entry<K,V> root = entries.get(0);
        swap(0, entries.size() - 1);
        entries.remove(entries.size() - 1);
        bubbleDown(0);  
        return root;
    }

    /**
     * Returns the root element of the heap.
     * Throws exception if size is 0
     * @return the root element of the heap
     * @throws NoSuchElementException if size is 0
     */
    @Override
    public Entry<K,V> peek() throws NoSuchElementException {
        if (entries.size() == 0) {
            throw new NoSuchElementException();
        }
        Entry<K,V> root = entries.get(0);
        return root;
    }

    /**
     * Returns the list of entries
     * @return the list of entries
     */
    @Override
    public List<Entry<K, V>> toArray() {
        return entries;
    }

    /**
     * If the List of entries is empty, return true. 
     * Otherwise, return false.
     * @return true if the list of entries is empty.
     */
    @Override
    public boolean isEmpty() {
        return entries.size() == 0;
    }

    /**
     * Bubbles up the entry at the given index to make sure the heap is in the right order
     * @param index the given index of the entry
     */
    public void bubbleUp(int index) {
        // }
        if (index <= 0) {
            return;
        }
        Entry<K,V> entry = entries.get(index);
        Entry<K,V> parent = entries.get(parent(index));
        int comp = comparator.compare(entry.key, parent.key);
        if (comp > 0) {
            swap(index, parent(index));
            bubbleUp(parent(index));
        } else {
            return;
        }
    }

    /**
     * Bubbles down  the entry at the given index to make sure the heap is in the right order
     * @param index the given index of the entry
     */
    public void bubbleDown(int index) {
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

    /**
     * Returns true if the entry at index1 is greater than that at index2 
     * (Note: Both entries at the specified indicies must exist for this to be true). 
     * Return false otherwise.
     * @param index1 the given index1
     * @param index2 the given index2
     * @return true if both indices are valid and the entry at index1 is greater
     */
    public boolean existsAndGreater(int index1, int index2) {
        if (index1 < entries.size() && index2 < entries.size()) {
            K key1 = entries.get(index1).key;
            K key2 = entries.get(index2).key;
            if (comparator.compare(key1, key2) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the parent index
     * @param index the index of the current entry
     * @return the index of the parent of the current entry
     */
    public int parent(int index) {
        return (index - 1) / 2;
    }
    
    /**
     * Return the left child index
     * @param index the index of the current entry
     * @return the index of the left child of the current entry
     */
    public int left(int index) {
        return index * 2 + 1;
    }

    /**
     * Return the right child index
     * @param index the index of the current entry
     * @return the index of the right child of the current entry
     */
    public int right(int index) {
        return index * 2 + 2;
    }

    public void swap(int i1, int i2) {
        Entry<K,V> temp = entries.get(i1);
        entries.set(i1, entries.get(i2));
        entries.set(i2, temp);
        temp = null;
    }

    /**
     * Returns the number of elements in entries
     * @return the number of elements in entries
     */
    public int size() {
        return entries.size();
    }

    /**
     * Returns a string representation of the elements in entries
     * @return a string representation of the elements in entries
     */
    public String toString() {
        String str = "";
        for (Entry<K,V> entry: entries) {
            str += "key: ";
            str += entry.key.toString();
            str += " value: ";
            str += entry.value.toString();
            str += " | ";
        }
        return str;
    }
}
