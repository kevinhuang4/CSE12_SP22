
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection; 
import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Linked"}, {"Array"} });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private <E> MyList<E> makeList(E[] contents) {
		switch (this.listType) {
		case "Linked":
			return new LinkedGL<E>(contents);
		case "Array":
			return new ArrayGL<E>(contents);
		}
		return null;
	}

  // Don't change code above this line, it ensures the autograder works as
  // expected


  // This is a sample test; you can keep it, change it, or remove it as you like.
  // Note that it uses the method `assertArrayEquals`, which you should use to
  // test equality of arrays in this PA.
	// @Test
	// public void testSimpleToArray() {
	// 	// Using the generic list to create an Integer list
	// 	Integer[] int_input = {1, 2, 3};
	// 	MyList<Integer> int_s = makeList(int_input);
	// 	assertArrayEquals(int_input, int_s.toArray());
		
	// 	// Using the generic list to create a String list
	// 	String[] string_input = {"a", "b", "c"};
	// 	MyList<String> string_s = makeList(string_input);
	// 	assertArrayEquals(string_input, string_s.toArray());
	// }
	@Test
	public void testToArray() {
		Integer[] int_input = {-1, 0, 1, 2, 3};
		MyList<Integer> int_list = makeList(int_input);
		assertArrayEquals(int_input, int_list.toArray());
		assertNotEquals(int_input, int_list.toArray());
		String[] string_input = {null, "hello", "world", "happy", "hacking"};
		MyList<String> string_list = makeList(string_input);
		assertArrayEquals(string_input, string_list.toArray());
		assertNotEquals(string_input, string_list.toArray());
	}
	
	@Test
	public void testTransformAll() {
		Integer[] int_input = {-1, 0, 1, 2, 3};
		MyList<Integer> int_list = makeList(int_input);
		HalfIntegerTransformer halfIntegerTransformer = new HalfIntegerTransformer();
		int_list.transformAll(halfIntegerTransformer);
		Integer[] int_res = {0, 0, 0, 1, 1};
		assertArrayEquals(int_res, int_list.toArray());
		String[] string_input = {"hello", "world", "happy", "hacking"};
		MyList<String> string_list = makeList(string_input);
		HalfStringTransformer halfStringTransformer = new HalfStringTransformer();
		UpperCaseTransformer upperCaseTransformer = new UpperCaseTransformer();
		string_list.transformAll(upperCaseTransformer);
		String[] string_res0 = {"HELLO", "WORLD", "HAPPY", "HACKING"};
		assertArrayEquals(string_res0, string_list.toArray());
		string_list.transformAll(halfStringTransformer);
		String[] string_res1 = {"HE", "WO", "HA", "HAC"};
		assertArrayEquals(string_res1, string_list.toArray());
	}

	@Test
	public void testChooseAll() {
		Integer[] int_input = {-1, 0, 1, 2, 3};
		MyList<Integer> int_list = makeList(int_input);
		EvenIntChooser evenIntChooser = new EvenIntChooser();
		int_list.chooseAll(evenIntChooser);
		Integer[] int_res = {0, 2};
		assertArrayEquals(int_res, int_list.toArray());
		String[] string_input = {"hello", "WORLD", "happy", "HACKING"};
		MyList<String> string_list = makeList(string_input);
		UpperCaseChooser upperCaseChooser = new UpperCaseChooser();
		LongWordChooser longWordChooser = new LongWordChooser();
		string_list.chooseAll(upperCaseChooser);
		String[] string_res0 = {"WORLD", "HACKING"};
		assertArrayEquals(string_res0, string_list.toArray());
		string_list.chooseAll(longWordChooser);
		String[] string_res1 = {"HACKING"};
		assertArrayEquals(string_res1, string_list.toArray());
	}
	
	@Test
	public void testisEmpty() {
		Integer[] int_input = {-1, 0, 1, 2, 3};
		MyList<Integer> int_list = makeList(int_input);
		assertEquals(false, int_list.isEmpty());
		Integer[] empty_int_input = new Integer[0];
		MyList<Integer> empty_int_list = makeList(empty_int_input);
		assertEquals(true, empty_int_list.isEmpty());
		String[] string_input = {"hello", "world", "happy", "hacking"};
		MyList<String> string_list = makeList(string_input);
		assertEquals(false, string_list.isEmpty());
		String[] empty_string_input = new String[0];
		MyList<String> empty_string_list = makeList(empty_string_input);
		assertEquals(true, empty_string_list.isEmpty());
	}
	
	@Test
	public void testEmpty() {
		Integer[] int_input = new Integer[0];
		MyList<Integer> int_list = makeList(int_input);
		assertArrayEquals(int_input, int_list.toArray());
		assertNotEquals(int_input, int_list.toArray());
		HalfIntegerTransformer halfIntegerTransformer = new HalfIntegerTransformer();
		int_list.transformAll(halfIntegerTransformer);
		assertArrayEquals(int_input, int_list.toArray());
		EvenIntChooser evenIntChooser = new EvenIntChooser();
		int_list.chooseAll(evenIntChooser);
		assertArrayEquals(int_input, int_list.toArray());
		assertEquals(true, int_list.isEmpty());
		
		String[] string_input = new String[0];
		MyList<String> string_list = makeList(string_input);
		assertArrayEquals(string_input, string_list.toArray());
		assertNotEquals(string_input, string_list.toArray());
		HalfStringTransformer halfStringTransformer = new HalfStringTransformer();
		string_list.transformAll(halfStringTransformer);
		assertArrayEquals(string_input, string_list.toArray());
		UpperCaseChooser upperCaseChooser = new UpperCaseChooser();
		string_list.chooseAll(upperCaseChooser);
		assertArrayEquals(string_input, string_list.toArray());
		assertEquals(true, string_list.isEmpty());
	}
	
	@Test
	public void testNull() {
		Integer[] int_input = {null, null, null, null, null};
		MyList<Integer> int_list = makeList(int_input);
		assertArrayEquals(int_input, int_list.toArray());
		assertNotEquals(int_input, int_list.toArray());
		HalfIntegerTransformer halfIntegerTransformer = new HalfIntegerTransformer();
		int_list.transformAll(halfIntegerTransformer);
		assertArrayEquals(int_input, int_list.toArray());
		assertEquals(false, int_list.isEmpty());
		EvenIntChooser evenIntChooser = new EvenIntChooser();
		int_list.chooseAll(evenIntChooser);
		Integer[] empty_int_list = new Integer[0];
		assertArrayEquals(empty_int_list, int_list.toArray());
		assertEquals(true, int_list.isEmpty());
		
		String[] string_input = {null, null, null, null, null};
		MyList<String> string_list = makeList(string_input);
		assertArrayEquals(string_input, string_list.toArray());
		assertNotEquals(string_input, string_list.toArray());
		HalfStringTransformer halfStringTransformer = new HalfStringTransformer();
		string_list.transformAll(halfStringTransformer);
		assertArrayEquals(string_input, string_list.toArray());
		assertEquals(false, string_list.isEmpty());
		UpperCaseChooser upperCaseChooser = new UpperCaseChooser();
		string_list.chooseAll(upperCaseChooser);
		String[] empty_string_list = new String[0];
		assertArrayEquals(empty_string_list, string_list.toArray());
		assertEquals(true, int_list.isEmpty());
	}
	
	@Test
	public void testIsEmptyWithOneValue() {
		Integer[] int_input = {1};
		MyList<Integer> int_list = makeList(int_input);
		assertEquals(false, int_list.isEmpty());
	}
	
	@Test
	public void testToArrayWithALargeSize() {
		Integer[] int_input = new Integer[10000];
		for (int i = 0; i < int_input.length; i ++) {
			int_input[i] = i;
		}
		MyList<Integer> int_list = makeList(int_input);
		assertArrayEquals(int_input, int_list.toArray());
	}
	
	@Test
	public void testChooseAllElements() {
		Integer[] int_input = {0, 2, 4, 6, 8, 10};
		MyList<Integer> int_list = makeList(int_input);
		EvenIntChooser evenIntChooser = new EvenIntChooser();
		int_list.chooseAll(evenIntChooser);
		assertArrayEquals(int_input, int_list.toArray());
	}
	
	@Test
	public void testChooseTheSecondElement() {
		Integer[] int_input = {1, 2};
		MyList<Integer> int_list = makeList(int_input);
		EvenIntChooser evenIntChooser = new EvenIntChooser();
		int_list.chooseAll(evenIntChooser);
		Integer[] res = {2};
		assertArrayEquals(res, int_list.toArray());
	}
	
	@Test
	public void testChooseTheFirstAndLastElement() {
		Integer[] int_input = {2, 3, 5, 7, 10};
		MyList<Integer> int_list = makeList(int_input);
		EvenIntChooser evenIntChooser = new EvenIntChooser();
		int_list.chooseAll(evenIntChooser);
		Integer[] res = {2, 10};
		assertArrayEquals(res, int_list.toArray());
	}
	
	@Test
	public void testTransformTwoItems() {
		Integer[] int_input = {2, 5};
		MyList<Integer> int_list = makeList(int_input);
		HalfIntegerTransformer halfIntegerTransformer = new HalfIntegerTransformer();
		int_list.transformAll(halfIntegerTransformer);
		Integer[] res = {1, 2};
		assertArrayEquals(res, int_list.toArray());
	}
	
	@Test
	public void testTransformLargeList() {
		Integer[] int_input = new Integer[10000];
		for (int i = 0; i < int_input.length; i ++) {
			int_input[i] = i;
		}
		MyList<Integer> int_list = makeList(int_input);
		HalfIntegerTransformer halfIntegerTransformer = new HalfIntegerTransformer();
		int_list.transformAll(halfIntegerTransformer);
		for (int i= 0; i < int_input.length; i ++) {
			int_input[i] /= 2;
		}
		assertArrayEquals(int_input, int_list.toArray());
	}
}