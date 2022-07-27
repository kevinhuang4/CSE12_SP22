
/** MyHashMap is an implementation of HashMap using arrays and ArrayList.
 * It includes a private class of HashMapEntry<K,V>/
 * It uses separate chaining to resolve conflicts and Objects.hashCode() to hash keys.
 * It includes basic methods such as put, replace, remove, set, get, size, isEmpty, containsKey, keys, expandCapacity.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// import org.junit.experimental.theories.Theory;

public class MyHashMap<K, V> implements DefaultMap<K, V> {
	public static final double DEFAULT_LOAD_FACTOR = 0.75;
	public static final int DEFAULT_INITIAL_CAPACITY = 16;
	public static final String ILLEGAL_ARG_CAPACITY = "Initial Capacity must be non-negative";
	public static final String ILLEGAL_ARG_LOAD_FACTOR = "Load Factor must be positive";
	public static final String ILLEGAL_ARG_NULL_KEY = "Keys must be non-null";

	private double loadFactor;
	private int capacity;
	private int size;

	// Use this instance variable for Separate Chaining conflict resolution
	private List<HashMapEntry<K, V>>[] buckets;

	// Use this instance variable for Linear Probing
	private HashMapEntry<K, V>[] entries;

	/**
	 * default constructor that initiates the object with the default fields
	 */
	public MyHashMap() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	/**
	 * initiates the object with the input values
	 * 
	 * @param initialCapacity the initial capacity of this MyHashMap
	 * @param loadFactor      the load factor for rehashing this MyHashMap
	 * @throws IllegalArgumentException if initialCapacity is negative or loadFactor
	 *                                  not
	 *                                  positive
	 */
	@SuppressWarnings("unchecked")
	public MyHashMap(int initialCapacity, double loadFactor) throws IllegalArgumentException {
		// TODO Finish initializing instance fields
		if (initialCapacity < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARG_CAPACITY);
		}
		if (loadFactor <= 0) {
			throw new IllegalArgumentException(ILLEGAL_ARG_LOAD_FACTOR);
		}
		this.loadFactor = loadFactor;
		this.capacity = initialCapacity;
		this.size = 0;

		// if you use Separate Chaining
		buckets = (List<HashMapEntry<K, V>>[]) new List<?>[this.capacity];

		// // if you use Linear Probing
		// entries = (HashMapEntry<K, V>[]) new HashMapEntry<?, ?>[initialCapacity];
	}

	/**
	 * Adds the specified key, value pair to this DefaultMap
	 * Note: duplicate keys are not allowed
	 * 
	 * @return true if the key value pair was added to this DefaultMap
	 * @throws IllegalArgument exception if the key is null
	 */
	@Override
	public boolean put(K key, V value) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		if (this.containsKey(key)) {
			return false;
		}
		if (this.size / this.capacity > this.loadFactor) {
			this.expandCapacity();
		}
		// can also use key.hashCode() assuming key is not null
		int keyHash = Objects.hashCode(key);
		// TODO Auto-generated method stub
		int index = Math.abs(keyHash) % this.capacity;
		HashMapEntry<K, V> newEntry = new HashMapEntry<>(key, value);
		if (this.buckets[index] == null) {
			this.buckets[index] = new ArrayList<HashMapEntry<K, V>>();
		}
		boolean add = this.buckets[index].add(newEntry);
		if (add) {
			this.size += 1;
		}
		return add;
	}

	/**
	 * Replaces the value that maps to the key if it is present
	 * 
	 * @param key      The key whose mapped value is being replaced
	 * @param newValue The value to replace the existing value with
	 * @return true if the key was in this DefaultMap
	 * @throws IllegalArgument exception if the key is null
	 */
	@Override
	public boolean replace(K key, V newValue) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		if (!this.containsKey(key)) {
			return false;
		}
		int index = Math.abs(Objects.hashCode(key)) % this.capacity;
		for (HashMapEntry<K, V> entry : this.buckets[index]) {
			if (entry.getKey().equals(key)) {
				entry.setValue(newValue);
				return true;
			}
		}
		return false;
	}

	/**
	 * Remove the entry corresponding to the given key
	 * 
	 * @return true if an entry for the given key was removed
	 * @throws IllegalArgument exception if the key is null
	 */
	@Override
	public boolean remove(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		if (!this.containsKey(key)) {
			return false;
		}
		int index = Math.abs(Objects.hashCode(key)) % this.capacity;
		for (HashMapEntry<K, V> entry : this.buckets[index]) {
			if (entry.getKey().equals(key)) {
				this.size -= 1;
				return this.buckets[index].remove(entry);
			}
		}
		return false;
	}

	/**
	 * Adds the key, value pair to this DefaultMap if it is not present,
	 * otherwise, replaces the value with the given value
	 * 
	 * @throws IllegalArgument exception if the key is null
	 */
	@Override
	public void set(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		if (this.containsKey(key)) {
			this.replace(key, value);
		} else {
			this.put(key, value);
		}
	}

	/**
	 * @return the value corresponding to the specified key, null if key doesn't
	 *         exist in hash map
	 * @throws IllegalArgument exception if the key is null
	 */
	@Override
	public V get(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		if (this.size() == 0) {
			return null;
		}
		if (!this.containsKey(key)) {
			return null;
		}
		int index = Math.abs(Objects.hashCode(key)) % this.capacity;
		for (HashMapEntry<K, V> entry : this.buckets[index]) {
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		return null;
	}

	/**
	 * 
	 * @return The number of (key, value) pairs in this DefaultMap
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	/**
	 * 
	 * @return true iff this.size() == 0 is true
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size == 0;
	}

	/**
	 * @return true if the specified key is in this DefaultMap
	 * @throws IllegalArgument exception if the key is null
	 */
	@Override
	public boolean containsKey(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
		}
		int index = Math.abs(Objects.hashCode(key)) % this.capacity;
		// TODO Auto-generated method stub
		List<HashMapEntry<K, V>> currentList = this.buckets[index];
		if (currentList == null) {
			return false;
		}
		for (HashMapEntry<K, V> currentPair : currentList) {
			if (currentPair.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @return an array containing the keys of this DefaultMap. If this DefaultMap
	 *         is
	 *         empty, returns array of length zero.
	 */
	@Override
	public List<K> keys() {
		// TODO Auto-generated method stub
		List<K> keys = new ArrayList<>();
		for (int i = 0; i < this.buckets.length; i += 1) {
			if (this.buckets[i] == null) {
				continue;
			}
			for (HashMapEntry<K, V> entry : this.buckets[i]) {
				keys.add(entry.getKey());
			}
		}
		return keys;
	}

	/**
	 * Double the size of the buckets and the capacity.
	 * Rehash all data that's already inside the buckets.
	 */
	@SuppressWarnings("unchecked")
	public void expandCapacity() {
		List<HashMapEntry<K, V>>[] newBuckets = (List<HashMapEntry<K, V>>[]) new List<?>[2 * this.capacity];
		this.capacity *= 2;
		List<HashMapEntry<K, V>>[] oldBuckets = this.buckets;
		this.buckets = newBuckets;
		for (int i = 0; i < oldBuckets.length; i += 1) {
			if (oldBuckets[i] == null) {
				continue;
			}
			for (HashMapEntry<K, V> entry : oldBuckets[i]) {
				this.put(entry.getKey(), entry.getValue());
			}
		}
	}

	private static class HashMapEntry<K, V> implements DefaultMap.Entry<K, V> {

		K key;
		V value;

		private HashMapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public void setValue(V value) {
			this.value = value;
		}
	}
}
