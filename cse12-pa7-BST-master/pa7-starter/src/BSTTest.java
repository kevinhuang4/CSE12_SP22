
/**
 * BSTTest a test file for BST.java
 * It includes two or three tests for each BST method. 
 * The methodName indicates which method it is testing.
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.*;

public class BSTTest {

	@Test
	public void testPut() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(4, 4);
		bst.put(2, 2);
		bst.put(6, 6);
		assertEquals("k2v2--k4v4--k6v6--", bst.myToString());
		bst.put(1, 1);
		bst.put(3, 3);
		bst.put(5, 5);
		bst.put(7, 7);
		assertEquals("k1v1--k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
	}

	@Test
	public void testPut2() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(7, 7);
		bst.put(6, 6);
		bst.put(5, 5);
		assertEquals("k5v5--k6v6--k7v7--", bst.myToString());
		bst.put(4, 4);
		bst.put(3, 3);
		bst.put(2, 2);
		bst.put(1, 1);
		assertEquals("k1v1--k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPut3() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(null, 7);
	}

	@Test
	public void testContainsKey() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(4, 4);
		bst.put(2, 2);
		bst.put(6, 6);
		assertEquals(true, bst.containsKey(4));
		assertEquals(true, bst.containsKey(2));
		assertEquals(true, bst.containsKey(6));
	}

	@Test
	public void testContainsKey2() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(4, 4);
		bst.put(2, 2);
		bst.put(6, 6);
		assertEquals(false, bst.containsKey(1));
		assertEquals(false, bst.containsKey(3));
		assertEquals(false, bst.containsKey(5));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testContainsKey3() {
		BST<Integer, Integer> bst = new BST<>();
		bst.containsKey(null);
	}

	@Test
	public void testGet() {
		BST<Integer, Integer> bst = new BST<>();
		assertEquals(null, bst.get(5));
		bst.put(4, 4);
		bst.put(2, 2);
		bst.put(6, 6);
		assertEquals(Integer.valueOf(4), bst.get(4));
		assertEquals(Integer.valueOf(2), bst.get(2));
		assertEquals(Integer.valueOf(6), bst.get(6));
	}

	@Test
	public void testGet2() {
		BST<Integer, Integer> bst = new BST<>();
		assertEquals(null, bst.get(5));
		bst.put(4, 4);
		bst.put(2, 2);
		bst.put(6, 6);
		assertEquals(null, bst.get(1));
		assertEquals(null, bst.get(3));
		assertEquals(null, bst.get(5));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGet3() {
		BST<Integer, Integer> bst = new BST<>();
		bst.get(null);
	}

	@Test
	public void testRemove() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(4, 4);
		bst.put(2, 2);
		bst.put(6, 6);
		bst.put(1, 1);
		bst.put(3, 3);
		bst.put(5, 5);
		bst.put(7, 7);
		assertEquals("k1v1--k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.remove(1);
		assertEquals("k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.remove(2);
		assertEquals("k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.remove(3);
		assertEquals("k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.remove(7);
		assertEquals("k4v4--k5v5--k6v6--", bst.myToString());
		bst.remove(5);
		assertEquals("k4v4--k6v6--", bst.myToString());
		bst.remove(4);
		assertEquals("k6v6--", bst.myToString());
		bst.remove(6);
		assertEquals("", bst.myToString());
	}

	@Test
	public void testRemove2() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(4, 4);
		bst.put(2, 2);
		bst.put(6, 6);
		bst.put(1, 1);
		bst.put(3, 3);
		bst.put(5, 5);
		bst.put(7, 7);
		assertEquals("k1v1--k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.remove(8);
		assertEquals("k1v1--k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.remove(9);
		assertEquals("k1v1--k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemove3() {
		BST<Integer, Integer> bst = new BST<>();
		bst.remove(null);
	}

	@Test
	public void testReplace() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(4, 4);
		bst.put(2, 2);
		bst.put(6, 6);
		bst.put(1, 1);
		bst.put(3, 3);
		bst.put(5, 5);
		bst.put(7, 7);
		assertEquals("k1v1--k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.replace(1, 2);
		assertEquals("k1v2--k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.replace(2, 3);
		assertEquals("k1v2--k2v3--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.replace(3, 4);
		assertEquals("k1v2--k2v3--k3v4--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.replace(4, 5);
		assertEquals("k1v2--k2v3--k3v4--k4v5--k5v5--k6v6--k7v7--", bst.myToString());
		bst.replace(5, 6);
		assertEquals("k1v2--k2v3--k3v4--k4v5--k5v6--k6v6--k7v7--", bst.myToString());
		bst.replace(6, 7);
		assertEquals("k1v2--k2v3--k3v4--k4v5--k5v6--k6v7--k7v7--", bst.myToString());
		bst.replace(7, 8);
		assertEquals("k1v2--k2v3--k3v4--k4v5--k5v6--k6v7--k7v8--", bst.myToString());
	}

	@Test
	public void testReplace2() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(7, 7);
		bst.put(6, 6);
		bst.put(5, 5);
		bst.put(4, 4);
		bst.put(3, 3);
		bst.put(2, 2);
		bst.put(1, 1);
		assertEquals("k1v1--k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.replace(8, 2);
		assertEquals("k1v1--k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testReplace3() {
		BST<Integer, Integer> bst = new BST<>();
		bst.replace(null, 3);
	}

	@Test
	public void testSet1() {
		BST<Integer, Integer> bst = new BST<>();
		bst.set(4, 4);
		bst.set(2, 2);
		bst.set(6, 6);
		assertEquals("k2v2--k4v4--k6v6--", bst.myToString());
		bst.set(1, 1);
		bst.set(3, 3);
		bst.set(5, 5);
		bst.set(7, 7);
		assertEquals("k1v1--k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
	}

	@Test
	public void testSet2() {
		BST<Integer, Integer> bst = new BST<>();
		bst.set(4, 4);
		bst.set(2, 2);
		bst.set(6, 6);
		bst.set(1, 1);
		bst.set(3, 3);
		bst.set(5, 5);
		bst.set(7, 7);
		assertEquals("k1v1--k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.set(1, 2);
		assertEquals("k1v2--k2v2--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.set(2, 3);
		assertEquals("k1v2--k2v3--k3v3--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.set(3, 4);
		assertEquals("k1v2--k2v3--k3v4--k4v4--k5v5--k6v6--k7v7--", bst.myToString());
		bst.set(4, 5);
		assertEquals("k1v2--k2v3--k3v4--k4v5--k5v5--k6v6--k7v7--", bst.myToString());
		bst.set(5, 6);
		assertEquals("k1v2--k2v3--k3v4--k4v5--k5v6--k6v6--k7v7--", bst.myToString());
		bst.set(6, 7);
		assertEquals("k1v2--k2v3--k3v4--k4v5--k5v6--k6v7--k7v7--", bst.myToString());
		bst.set(7, 8);
		assertEquals("k1v2--k2v3--k3v4--k4v5--k5v6--k6v7--k7v8--", bst.myToString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSet3() {
		BST<Integer, Integer> bst = new BST<>();
		bst.set(null, 3);
	}

	@Test
	public void testSize() {
		BST<Integer, Integer> bst = new BST<>();
		assertEquals(0, bst.size());
		bst.set(4, 4);
		assertEquals(1, bst.size());
		bst.set(2, 2);
		assertEquals(2, bst.size());
		bst.set(6, 6);
		assertEquals(3, bst.size());
		bst.set(1, 1);
		assertEquals(4, bst.size());
		bst.set(3, 3);
		assertEquals(5, bst.size());
		bst.set(5, 5);
		assertEquals(6, bst.size());
		bst.set(7, 7);
		assertEquals(7, bst.size());
	}

	@Test
	public void testSize2() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(4, 4);
		bst.put(2, 2);
		bst.put(6, 6);
		bst.put(1, 1);
		bst.put(3, 3);
		bst.put(5, 5);
		bst.put(7, 7);
		assertEquals(7, bst.size());
		bst.remove(1);
		assertEquals(6, bst.size());
		bst.remove(2);
		assertEquals(5, bst.size());
		bst.remove(3);
		assertEquals(4, bst.size());
		bst.remove(7);
		assertEquals(3, bst.size());
		bst.remove(5);
		assertEquals(2, bst.size());
		bst.remove(4);
		assertEquals(1, bst.size());
		bst.remove(6);
		assertEquals(0, bst.size());
	}

	@Test
	public void testIsEmpty() {
		BST<Integer, Integer> bst = new BST<>();
		assertEquals(true, bst.isEmpty());
	}

	@Test
	public void testIsEmpty2() {
		BST<Integer, Integer> bst = new BST<>();
		assertEquals(true, bst.isEmpty());
		bst.put(4, 4);
		bst.put(2, 2);
		bst.put(6, 6);
		bst.put(1, 1);
		bst.put(3, 3);
		bst.put(5, 5);
		bst.put(7, 7);
		assertEquals(false, bst.isEmpty());
		bst.remove(1);
		bst.remove(2);
		bst.remove(3);
		assertEquals(false, bst.isEmpty());
		bst.remove(7);
		bst.remove(5);
		bst.remove(4);
		bst.remove(6);
		assertEquals(true, bst.isEmpty());
	}

	@Test
	public void testKeys() {
		BST<Integer, Integer> bst = new BST<>();
		List<Integer> expected = new ArrayList<>();
		assertEquals(expected, bst.keys());
		bst.set(4, 4);
		expected.add(4);
		assertEquals(expected, bst.keys());
		bst.set(2, 2);
		expected.add(2);
		Collections.sort(expected);
		assertEquals(expected, bst.keys());
		bst.set(6, 6);
		expected.add(6);
		Collections.sort(expected);
		assertEquals(expected, bst.keys());
		bst.set(1, 1);
		expected.add(1);
		Collections.sort(expected);
		assertEquals(expected, bst.keys());
		bst.set(3, 3);
		expected.add(3);
		Collections.sort(expected);
		assertEquals(expected, bst.keys());
		bst.set(5, 5);
		expected.add(5);
		Collections.sort(expected);
		assertEquals(expected, bst.keys());
		bst.set(7, 7);
		expected.add(7);
		Collections.sort(expected);
		assertEquals(expected, bst.keys());
	}

	@Test
	public void testKeys2() {
		BST<Integer, Integer> bst = new BST<>();
		bst.put(4, 4);
		bst.put(2, 2);
		bst.put(6, 6);
		bst.put(1, 1);
		bst.put(3, 3);
		bst.put(5, 5);
		bst.put(7, 7);
		List<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(5);
		expected.add(6);
		expected.add(7);
		assertEquals(expected, bst.keys());
		bst.remove(1);
		expected.remove(0);
		assertEquals(expected, bst.keys());
		bst.remove(2);
		expected.remove(0);
		assertEquals(expected, bst.keys());
		bst.remove(3);
		expected.remove(0);
		assertEquals(expected, bst.keys());
		bst.remove(4);
		expected.remove(0);
		assertEquals(expected, bst.keys());
		bst.remove(5);
		expected.remove(0);
		assertEquals(expected, bst.keys());
		bst.remove(6);
		expected.remove(0);
		assertEquals(expected, bst.keys());
		bst.remove(7);
		expected.remove(0);
		assertEquals(expected, bst.keys());
	}
}
