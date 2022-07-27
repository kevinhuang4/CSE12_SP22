
/**
 * BST is a class that implements DefaultMap.
 * It represents the data structure - binary search tree.
 * It has a private class, Node, that stores key, value pairs.
 * It supports basic operations, such as put, replace,
 * remove, set, get, size, isEmpty, containsKey, and keys
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * @param <K> The type of the keys of this BST. They need to be comparable by
 *            nature of the BST
 *            "K extends Comparable" means that BST will only compile with
 *            classes that implement Comparable
 *            interface. This is because our BST sorts entries by key. Therefore
 *            keys must be comparable.
 * @param <V> The type of the values of this BST.
 */
public class BST<K extends Comparable<? super K>, V> implements DefaultMap<K, V> {
	/*
	 * You may add any instance variables you need, but
	 * you may NOT use any class that implements java.util.SortedMap
	 * or any other implementation of a binary search tree
	 */
	Node<K, V> root;
	int size;
	String NULLKEYISNOTALLOWED = "null key is not allowed";

	/**
	 * BST constructor
	 * Sets the root to null, size to 0
	 * Initializes the comparator
	 * 
	 */
	public BST() {
		this.root = null;
		this.size = 0;
		// this.comparator = new Comparator<K>();
	}

	/**
	 * Adds the specified key, value pair to this DefaultMap
	 * Note: duplicate keys are not allowed
	 * 
	 * @return true if the key value pair was added to this DefaultMap
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public boolean put(K key, V value) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException(NULLKEYISNOTALLOWED);
		}
		if (this.containsKey(key)) {
			return false;
		}
		this.root = this.put(root, key, value);
		return true;
	}

	/**
	 * Puts a key-alue pair (new node) into the subtree
	 * 
	 * @param node  the root of the subtree
	 * @param key   the key of the key-value pair
	 * @param value the value of the key-value pair
	 * @return the root node of the subtree after
	 *         the new node has been added
	 */
	private Node<K, V> put(Node<K, V> node, K key, V value) {
		if (node == null) {
			this.size += 1;
			return new Node<K, V>(key, value);
		}
		int comp = node.key.compareTo(key);
		// the case where comp == 0 will not appear because
		// containsKey is called before the private put
		if (comp < 0) {
			node.right = this.put(node.right, key, value);
			return node;
		} else {
			node.left = this.put(node.left, key, value);
			return node;
		}
	}

	/**
	 * Replaces the value that maps to the key if it is present
	 * 
	 * @param key      The key whose mapped value is being replaced
	 * @param newValue The value to replace the existing value with
	 * @return true if the key was in this DefaultMap
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public boolean replace(K key, V newValue) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException(NULLKEYISNOTALLOWED);
		}
		if (!this.containsKey(key)) {
			return false;
		}
		Node<K, V> toBeUpdated = this.find(this.root, key);
		toBeUpdated.setValue(newValue);
		return true;
	}

	/**
	 * Finds the node with the given key in the subtree
	 * 
	 * @param node the root of the subtree
	 * @param key  The given key
	 * @return the node with the given key
	 */
	private Node<K, V> find(Node<K, V> node, K key) {
		int comp = node.key.compareTo(key);
		if (comp > 0) {
			return find(node.left, key);
		} else if (comp < 0) {
			return find(node.right, key);
		} else {
			return node;
		}
	}

	/**
	 * Remove the entry corresponding to the given key
	 * 
	 * @param key the given key
	 * @return true if an entry for the given key was removed
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public boolean remove(K key) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException(NULLKEYISNOTALLOWED);
		}
		if (!this.containsKey(key)) {
			return false;
		}
		this.root = this.remove(this.root, key);
		this.size -= 1;
		return true;
	}

	/**
	 * Removes the entry corresponding to the given key
	 * from the subtree
	 *
	 * @param node the root of the subtree
	 * @param key  the given key
	 * @return the root of the subtree after the entry is removed
	 */
	private Node<K, V> remove(Node<K, V> node, K key) {
		if (node == null) {
			return null;
		}
		int comp = node.key.compareTo(key);
		if (comp > 0) {
			node.left = this.remove(node.left, key);
		} else if (comp < 0) {
			node.right = this.remove(node.right, key);
		} else {
			if (node.right == null) {
				return node.left;
			}
			if (node.left == null) {
				return node.right;
			}
			Node<K, V> temp = node;
			node = this.min(temp.right);
			node.right = this.removeMin(temp.right);
			node.left = temp.left;
		}
		return node;
	}

	/**
	 * Returns the node with the smallest key in the subtree.
	 *
	 * @param node the root of the subtree
	 * @return the node with the smallest key in the subtree
	 */
	private Node<K, V> min(Node<K, V> node) {
		if (node.left == null) {
			return node;
		}
		return this.min(node.left);
	}

	/**
	 * Removes the node with the smallest key in the subtree
	 *
	 * @param node the root of the subtree
	 * @return the root of the subtree after removing the node
	 */
	private Node<K, V> removeMin(Node<K, V> node) {
		if (node.left == null) {
			return node.right;
		}
		node.left = removeMin(node.left);
		this.size -= 1;
		return node;
	}

	/**
	 * Adds the key, value pair to this DefaultMap if it is not present,
	 * otherwise, replaces the value with the given value
	 * 
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public void set(K key, V value) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException(NULLKEYISNOTALLOWED);
		}
		if (!this.containsKey(key)) {
			this.put(key, value);
		} else {
			this.replace(key, value);
		}
	}

	/**
	 * @return the value corresponding to the specified key
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public V get(K key) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException(NULLKEYISNOTALLOWED);
		}
		if (this.root == null || !this.containsKey(key)) {
			return null;
		}
		return this.get(this.root, key);
	}

	private V get(Node<K, V> node, K key) {
		if (node == null) {
			return null;
		}
		int comp = node.key.compareTo(key);
		if (comp > 0) {
			return this.get(node.left, key);
		} else if (comp < 0) {
			return this.get(node.right, key);
		} else {
			return node.getValue();
		}
	}

	/**
	 * 
	 * @return The number of (key, value) pairs in this DefaultMap
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * 
	 * @return true iff this.size() == 0 is true
	 */
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	/**
	 * @return true if the specified key is in this BST
	 * @throws IllegalArgumentException if the key is null
	 */
	@Override
	public boolean containsKey(K key) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException(NULLKEYISNOTALLOWED);
		}
		if (this.root == null) {
			return false;
		}
		return this.containsKey(this.root, key);
	}

	/**
	 * Checks if a key exists in the subtree
	 * 
	 * @param node the root of the subtree
	 * @param key  the target key
	 * @return true if the key exists in the subtree
	 */
	private boolean containsKey(Node<K, V> node, K key) {
		if (node == null) {
			return false;
		}
		int comp = node.key.compareTo(key);
		if (comp < 0) {
			return this.containsKey(node.right, key);
		} else if (comp > 0) {
			return this.containsKey(node.left, key);
		} else {
			return true;
		}
	}

	// Keys must be in ascending sorted order
	// You CANNOT use Collections.sort() or any other sorting implementations
	// You must do inorder traversal of the tree
	/**
	 * 
	 * @return an array containing the keys of this DefaultMap. If this DefaultMap
	 *         is
	 *         empty, returns array of length zero.
	 */
	@Override
	public List<K> keys() {
		return this.keys(this.root);
	}

	/**
	 * Returns a list of keys of the subtree
	 * 
	 * @param node the root of the subtree
	 * @return a list of keys of the subtree
	 */
	private List<K> keys(Node<K, V> node) {
		List<K> keys = new ArrayList<>();
		if (node == null) {
			return keys;
		}
		keys.addAll(this.keys(node.left));
		keys.add(node.getKey());
		keys.addAll(this.keys(node.right));
		return keys;
	}

	/**
	 * Returns the string representations of all the values in the BST
	 * with inorder traversal
	 * 
	 * @return the string representations of all the values in the BST
	 *         with inorder traversal
	 */
	public List<String> toStringList() {
		return this.toStringList(this.root);
	}

	/**
	 * Returns the string representation of all the values in the subtree
	 * with inorder traversal
	 * 
	 * @param node the root of the subtree
	 * @return the string representation of all the values in the subtree
	 */
	private List<String> toStringList(Node<K, V> node) {
		List<String> valuesInString = new ArrayList<>();
		if (node == null) {
			return valuesInString;
		}
		valuesInString.addAll(this.toStringList(node.left));
		valuesInString.add(node.getKey().toString() + ": " + node.getValue().toString());
		valuesInString.addAll(this.toStringList(node.right));
		return valuesInString;
	}

	/**
	 * Returns the string representations of all the values in the BST
	 * with postorder traversal
	 * Assumes the values are lists of FileData
	 * Loops through each list in reversed order
	 * 
	 * @return the string representations of all the values in the BST
	 *         with postorder traversal
	 */
	public List<String> reversedToStringListForDateMap() {
		return this.reversedToStringListForDateMap(this.root);
	}

	/**
	 * Returns the string representation of all the values in the subtree
	 * with postorder traversal
	 * 
	 * @param node the root of the subtree
	 * @return the string representation of all the values in the subtree
	 */
	@SuppressWarnings("unchecked")
	private List<String> reversedToStringListForDateMap(Node<K, V> node) {
		List<String> valuesInString = new ArrayList<>();
		if (node == null) {
			return valuesInString;
		}
		valuesInString.addAll(this.reversedToStringListForDateMap(node.right));
		List<FileData> currentValue = (List<FileData>) node.getValue();
		for (int i = currentValue.size() - 1; i >= 0; i -= 1) {
			valuesInString.add(currentValue.get(i).lastModifiedDate + ": "
					+ currentValue.get(i).toString());
		}
		valuesInString.addAll(this.reversedToStringListForDateMap(node.left));
		return valuesInString;
	}

	/**
	 * Returns the string representation of the BST with inorder traversal
	 * 
	 * @return the string representation of the BST with inorder traversal
	 */
	public String myToString() {
		return this.myToString(this.root);
	}

	/**
	 * Returns the string representation of the subtree with inorder traversal
	 * 
	 * @param node the root of the subtree
	 * @return the string representation of the subtree
	 */
	private String myToString(Node<K, V> node) {
		String s = "";
		if (node == null) {
			return "";
		}
		s += this.myToString(node.left);
		s += node.myToString();
		s += this.myToString(node.right);
		return s;
	}

	private static class Node<K extends Comparable<? super K>, V>
			implements DefaultMap.Entry<K, V> {

		K key;
		V value;
		Node<K, V> left;
		Node<K, V> right;

		/**
		 * Node constructor
		 * Sets the key and the value according to input
		 * 
		 * @param key   the key of the node
		 * @param value the value of the node
		 */
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}

		/**
		 * Returns the key
		 * 
		 * @return the key of the node
		 */
		@Override
		public K getKey() {
			return this.key;
		}

		/**
		 * Returns the value
		 * 
		 * @return the value of the node
		 */
		@Override
		public V getValue() {
			return this.value;
		}

		/**
		 * Sets a new value for the node
		 * 
		 * @param value the new value of the node
		 */
		@Override
		public void setValue(V value) {
			this.value = value;
		}

		/**
		 * Return the string representation of the node
		 * 
		 * @return the string representation of the node
		 */
		public String myToString() {
			return "k" + this.key.toString() + "v" + this.value.toString() + "--";
		}
	}

}