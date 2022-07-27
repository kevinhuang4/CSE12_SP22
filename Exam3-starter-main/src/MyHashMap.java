import java.util.List;
import java.util.Objects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

public class MyHashMap<K, V> implements DefaultMap<K, V> {

    public static final int DEFAULT_INITIAL_CAPACITY = 10;
    public static final String ILLEGAL_ARG_CAPACITY = 
                                        "Initial Capacity must be non-negative";
    public static final String ILLEGAL_ARG_NULL_KEY = "Keys must be non-null";

    private double loadFactor;
    private int capacity;
    private int size;	
    private Comparator myComparator;
    private Character[] sections;

    // Use this instance variable for Separate Chaining conflict resolution
    // private List<HashMapEntry<K, V>>[] buckets;  
    private List<MaxHeap<K, V>> buckets;

    // Use this instance variable for Linear Probing
    //	private HashMapEntry<K, V>[] entries; 

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, null);}

        @SuppressWarnings("unchecked")
		public MyHashMap(int initialCapacity, Comparator myComparator)
            throws IllegalArgumentException {
                if (initialCapacity < 0) {
                    throw new IllegalArgumentException(ILLEGAL_ARG_CAPACITY);
                }
                this.capacity = initialCapacity;
                this.size = 0;
                this.myComparator = myComparator;
                this.buckets = new ArrayList<>();
                for (int i = 0; i < capacity; i++) {
                    this.buckets.add(new MaxHeap<>(1000000, myComparator));
                }
        }

    @Override
        public boolean put(K key, V value) throws IllegalArgumentException {
            if (key == null) {
                throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
            }
            int index = Math.abs(Objects.hashCode(key)) % capacity;
            MaxHeap<K,V> maxHeap = this.buckets.get(index);
            maxHeap.add(key, value);
            this.size += 1;
            return true;
        }

    @Override
        public V get(K key) throws IllegalArgumentException {
            if (key == null) {
                throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
            }
            int index = Math.abs(Objects.hashCode(key)) % capacity;
            MaxHeap<K, V> maxHeap = buckets.get(index);
            HeapEntry<K, V> popped = maxHeap.peek();
            if (popped == null) { 
                return null;
            }
            return popped.getValue();
        }
 
    @Override
        public boolean containsKey(K key) throws IllegalArgumentException {
            if (key == null) {
                throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY);
            }
            int index = Math.abs(Objects.hashCode(key)) % capacity;
            MaxHeap<K, V> maxHeap = this.buckets.get(index);
            List<HeapEntry<K,V>> entries = maxHeap.getEntries();
            boolean contains = false;
            for (HeapEntry<K, V> entry: entries) {
                if (entry.key.equals(key)) {
                    contains = true;
                }
            }
            return contains;
        }

    @Override
        public int size() {
            return size;
        }

    @Override
        public boolean isEmpty() {
            return size == 0;
        }

    protected static class HashMapEntry<K, V> implements DefaultMap.Entry<K, V> {

        K key;
        V value;

        public HashMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
            public K getKey() {
                return this.key;
            }

        @Override
            public V getValue() {
                return this.value;
            }

        @Override
            public void setValue(V value) {
                this.value = value;
            }

        @Override
            @SuppressWarnings("unchecked")
            public boolean equals(Object o) {
                if (o instanceof MyHashMap.HashMapEntry<?, ?>) {
                    HashMapEntry<K, V> other = null;
                    try {
                        other = (HashMapEntry<K, V>) o;
                    } catch (ClassCastException e) {
                        return false;
                    }

                    return Objects.equals(key, other.key);
                }


                return false;
            }

    }
}