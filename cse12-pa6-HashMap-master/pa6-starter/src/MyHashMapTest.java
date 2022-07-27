import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.*;

public class MyHashMapTest {

	private DefaultMap<String, String> testMap; // use this for basic tests
	private DefaultMap<String, String> mapWithCap; // use for testing proper rehashing
	public static final String TEST_KEY = "Test Key";
	public static final String TEST_VAL = "Test Value";

	@Before
	public void setUp() {
		testMap = new MyHashMap<>();
		mapWithCap = new MyHashMap<>(4, MyHashMap.DEFAULT_LOAD_FACTOR);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPut_nullKey() {
		testMap.put(null, TEST_VAL);
	}

	@Test
	public void testKeys_nonEmptyMap() {
		// You don't have to use array list
		// This test will work with any object that implements List
		List<String> expectedKeys = new ArrayList<>(5);
		for (int i = 0; i < 5; i++) {
			// key + i is used to differentiate keys since they must be unique
			testMap.put(TEST_KEY + i, TEST_VAL + i);
			expectedKeys.add(TEST_KEY + i);
		}
		List<String> resultKeys = testMap.keys();
		// we need to sort because hash map doesn't guarantee ordering
		Collections.sort(resultKeys);
		assertEquals(expectedKeys, resultKeys);
	}

	/* Add more of your tests below */
	@Test
	public void testGet_emptyMap() {
		this.testMap = new MyHashMap<>();
		assertNull(this.testMap.get("hi"));
	}

	@Test
	public void testContainsKey() {
		this.testMap = new MyHashMap<>();
		this.testMap.set("hello", "hi");
		this.testMap.set("yooo", "hi");
		assertEquals(true, this.testMap.containsKey("hello"));
		assertEquals(true, this.testMap.containsKey("yooo"));
		assertEquals(false, this.testMap.containsKey("ayo"));
	}

	@Test
	public void testPut_cannotAddDuplicateKey() {
		this.testMap = new MyHashMap<>();
		this.testMap.put("hello", "hi");
		assertEquals(false, this.testMap.put("hello", "hi"));
	}
}