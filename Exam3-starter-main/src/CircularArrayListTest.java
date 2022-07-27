import static org.junit.Assert.*;

import org.junit.*;
public class CircularArrayListTest {
	@Test
	public void test_baseCase() throws Exception {
		ArrayListADT<Integer> cal = new CircularArrayList<Integer> (4);
		cal.addFront(23);
		cal.addFront(24);
		cal.addRear(300);
		cal.addFront(24);
		cal.addRear(0);
		// 24 24 23 300 0
		assertEquals(Integer.valueOf(24), cal.get(0));
		assertEquals(Integer.valueOf(24), cal.get(1));
		assertEquals(Integer.valueOf(23), cal.get(2));
		assertEquals(Integer.valueOf(300), cal.get(3));
		assertEquals(Integer.valueOf(0), cal.get(4));
		assertEquals(5, cal.getSize());
		assertEquals(8, cal.getCapacity());
		cal.remove();
		assertEquals(Integer.valueOf(24), cal.get(0));
		cal.remove();
		assertEquals(Integer.valueOf(23), cal.get(0));
		assertEquals(3, cal.getSize());
		assertEquals(8, cal.getCapacity());
	}

	@Test
	public void test0Capacity() throws Exception {
		ArrayListADT<Integer> cal = new CircularArrayList<Integer> (0);
		assertEquals(0, cal.getSize());
		assertEquals(0, cal.getCapacity());
		cal.addFront(5);
		assertEquals(1, cal.getSize());
		assertEquals(1, cal.getCapacity());
		assertEquals(Integer.valueOf(5), cal.get(0));
		cal.remove();
		assertEquals(0, cal.getSize());
		assertEquals(1, cal.getCapacity());
	}

	@Test
	public void testRear() throws Exception {
		ArrayListADT<Integer> cal = new CircularArrayList<Integer> (2);
		cal.addRear(50);
		cal.addRear(3);
		cal.addRear(34);
		cal.addRear(84);
		// 50 3 34 84
		assertEquals(Integer.valueOf(50), cal.get(0));
		assertEquals(Integer.valueOf(3), cal.get(1));
		assertEquals(Integer.valueOf(34), cal.get(2));
		assertEquals(Integer.valueOf(84), cal.get(3));
		assertEquals(4, cal.getSize());
		assertEquals(4, cal.getCapacity());
	}

	@Test
	public void testFront() throws Exception {
		ArrayListADT<Integer> cal = new CircularArrayList<Integer> (2);
		cal.addFront(50);
		cal.addFront(3);
		cal.addFront(34);
		cal.addFront(84);
		// 84 34 3 50
		assertEquals(Integer.valueOf(84), cal.get(0));
		assertEquals(Integer.valueOf(34), cal.get(1));
		assertEquals(Integer.valueOf(3), cal.get(2));
		assertEquals(Integer.valueOf(50), cal.get(3));
		assertEquals(4, cal.getSize());
		assertEquals(4, cal.getCapacity());
	}

	@Test
	public void testBothAdds() throws Exception {
		ArrayListADT<Integer> cal = new CircularArrayList<Integer> (2);
		cal.addFront(50);
		cal.addRear(3);
		cal.addFront(34);
		cal.addRear(84);
		cal.addRear(43);
		cal.addFront(81);
		// 81 34 50 3 84 43
		assertEquals(Integer.valueOf(81), cal.get(0));
		assertEquals(Integer.valueOf(34), cal.get(1));
		assertEquals(Integer.valueOf(50), cal.get(2));
		assertEquals(Integer.valueOf(3), cal.get(3));
		assertEquals(Integer.valueOf(84), cal.get(4));
		assertEquals(Integer.valueOf(43), cal.get(5));
		assertEquals(6, cal.getSize());
		assertEquals(8, cal.getCapacity());
	}

	@Test(expected = Exception.class)
	public void testException() throws Exception {
		ArrayListADT<Integer> cal = new CircularArrayList<Integer> (2);
		cal.addFront(50);
		cal.addRear(3);
		cal.get(3);
	}

	@Test 
	public void testRemove() throws Exception {
		ArrayListADT<Integer> cal = new CircularArrayList<Integer> (2);
		cal.addFront(50);
		cal.addRear(3);
		cal.addFront(34);
		cal.addRear(84);
		cal.addRear(43);
		cal.addFront(81);
		cal.remove();
		assertEquals(Integer.valueOf(34), cal.get(0));
		assertEquals(Integer.valueOf(50), cal.get(1));
		assertEquals(Integer.valueOf(3), cal.get(2));
		assertEquals(Integer.valueOf(84), cal.get(3));
		assertEquals(Integer.valueOf(43), cal.get(4));
		assertEquals(5, cal.getSize());
		cal.addRear(5);
		cal.remove();
		assertEquals(Integer.valueOf(50), cal.get(0));
		assertEquals(Integer.valueOf(3), cal.get(1));
		assertEquals(Integer.valueOf(84), cal.get(2));
		assertEquals(Integer.valueOf(43), cal.get(3));
		assertEquals(Integer.valueOf(5), cal.get(4));
		assertEquals(5, cal.getSize());
	}
}