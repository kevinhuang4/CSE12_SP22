package cse12pa1student;

import java.util.Collection;
import java.util.Arrays;


import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BasketTest {

	public static Collection<Object[]> BAGNUMS =
			Arrays.asList(new Object[][] { {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12} });
	private int bagType;

	public BasketTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Basket{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}
	
	private Basket makeBasket() {
		switch(this.bagType) {
			case 0: return new Basket0();
			case 1: return new Basket1();
			case 2: return new Basket2();
			case 3: return new Basket3();
			case 4: return new Basket4();
			case 5: return new Basket5();
			case 6: return new Basket6();
			case 7: return new Basket7();
			case 8: return new Basket8();
			case 9: return new Basket9();
			case 10: return new Basket10();
			case 11: return new Basket11();
			case 12: return new Basket12();
		}
		return null;
	}
	
	@Test
	public void addedHasCount1() {
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo", 5);
		assertEquals(0, basketToTest.count());
		basketToTest.addToBasket(i);
		assertEquals(1, basketToTest.count());
	}

	@Test
	public void testAddingAndCount() {
		Basket basketToTest = makeBasket();
		Item i0 = new Item("Shampoo", 5);
		Item i1 = new Item("Yogurt", 2);
		Item i2 = new Item("milk", 2);
		assertEquals(0, basketToTest.count());
		basketToTest.addToBasket(i0);
		assertEquals(1, basketToTest.count());
		basketToTest.addToBasket(i1);
		assertEquals(2, basketToTest.count());
		basketToTest.addToBasket(i2);
		assertEquals(3, basketToTest.count());
	}

	@Test
	public void testAddingAndTotalCost() {
		Basket basketToTest = makeBasket();
		Item i0 = new Item("Shampoo", 5);
		Item i1 = new Item("Yogurt", 2);
		Item i2 = new Item("milk", 2);
		assertEquals(0, basketToTest.totalCost());
		basketToTest.addToBasket(i0);
		assertEquals(5, basketToTest.totalCost());
		basketToTest.addToBasket(i1);
		assertEquals(7, basketToTest.totalCost());
		basketToTest.addToBasket(i2);
		assertEquals(9, basketToTest.totalCost());
	}

	@Test
	public void testAddingAndCountItem() {
		Basket basketToTest = makeBasket();
		Item i0 = new Item("Shampoo", 5);
		Item i1 = new Item("Yogurt", 2);
		Item i2 = new Item("milk", 2);
		assertEquals(0, basketToTest.countItem(i0));
		assertEquals(0, basketToTest.countItem(i1));
		assertEquals(0, basketToTest.countItem(i2));
		basketToTest.addToBasket(i0);
		assertEquals(1, basketToTest.countItem(i0));
		assertEquals(0, basketToTest.countItem(i1));
		assertEquals(0, basketToTest.countItem(i2));
		basketToTest.addToBasket(i1);
		assertEquals(1, basketToTest.countItem(i0));
		assertEquals(1, basketToTest.countItem(i1));
		assertEquals(0, basketToTest.countItem(i2));
		basketToTest.addToBasket(i2);
		assertEquals(1, basketToTest.countItem(i0));
		assertEquals(1, basketToTest.countItem(i1));
		assertEquals(1, basketToTest.countItem(i2));
	}

	@Test
	public void testAddingDuplicatesAndCount() {
		Basket basketToTest = makeBasket();
		Item i0 = new Item("Shampoo", 5);
		Item i1 = new Item("Shampoo", 5);
		Item i2 = new Item("Yogurt", 2);
		assertEquals(0, basketToTest.count());
		basketToTest.addToBasket(i0);
		assertEquals(1, basketToTest.count());
		basketToTest.addToBasket(i0);
		assertEquals(2, basketToTest.count());
		basketToTest.addToBasket(i1);
		assertEquals(3, basketToTest.count());
		basketToTest.addToBasket(i2);
		assertEquals(4, basketToTest.count());
		basketToTest.addToBasket(i2);
		assertEquals(5, basketToTest.count());
	}

	@Test
	public void testAddingDuplicatesAndTotalCost() {
		Basket basketToTest = makeBasket();
		Item i0 = new Item("Shampoo", 5);
		Item i1 = new Item("Shampoo", 5);
		Item i2 = new Item("Yogurt", 2);
		assertEquals(0, basketToTest.totalCost());
		basketToTest.addToBasket(i0);
		assertEquals(5, basketToTest.totalCost());
		basketToTest.addToBasket(i0);
		assertEquals(10, basketToTest.totalCost());
		basketToTest.addToBasket(i1);
		assertEquals(15, basketToTest.totalCost());
		basketToTest.addToBasket(i2);
		assertEquals(17, basketToTest.totalCost());
		basketToTest.addToBasket(i2);
		assertEquals(19, basketToTest.totalCost());
	}

	@Test
	public void testAddingDuplicatesAndCountItemByValue() {
		Basket basketToTest = makeBasket();
		Item i0 = new Item("Shampoo", 5);
		Item i1 = new Item("Shampoo", 5);
		Item i2 = new Item("Yogurt", 2);
		assertEquals(0, basketToTest.countItem(i0));
		assertEquals(0, basketToTest.countItem(i1));
		assertEquals(0, basketToTest.countItem(i2));
		basketToTest.addToBasket(i0);
		assertEquals(1, basketToTest.countItem(i0));
		assertEquals(1, basketToTest.countItem(i1));
		assertEquals(0, basketToTest.countItem(i2));
		basketToTest.addToBasket(i0);
		assertEquals(2, basketToTest.countItem(i0));
		assertEquals(2, basketToTest.countItem(i1));
		assertEquals(0, basketToTest.countItem(i2));
		basketToTest.addToBasket(i1);
		assertEquals(3, basketToTest.countItem(i0));
		assertEquals(3, basketToTest.countItem(i1));
		assertEquals(0, basketToTest.countItem(i2));
		basketToTest.addToBasket(i2);
		assertEquals(3, basketToTest.countItem(i0));
		assertEquals(3, basketToTest.countItem(i1));
		assertEquals(1, basketToTest.countItem(i2));
		basketToTest.addToBasket(i2);
		assertEquals(3, basketToTest.countItem(i0));
		assertEquals(3, basketToTest.countItem(i1));
		assertEquals(2, basketToTest.countItem(i2));
	}

	@Test
	public void testAddingAndRemoving() {
		Basket basketToTest = makeBasket();
		Item i0 = new Item("Shampoo", 5);
		Item i1 = new Item("Yogurt", 2);
		basketToTest.addToBasket(i0);
		basketToTest.addToBasket(i1);
		basketToTest.removeFromBasket(i0);
		assertEquals(1, basketToTest.count());
		assertEquals(2, basketToTest.totalCost());
		basketToTest.removeFromBasket(i1);
		assertEquals(0, basketToTest.count());
		assertEquals(0, basketToTest.totalCost());
	}

	@Test
	public void testAddingDuplicatesAndRemoveAll() {
		Basket basketToTest = makeBasket();
		Item i0 = new Item("Shampoo", 5);
		Item i1 = new Item("Yogurt", 2);
		basketToTest.addToBasket(i0);
		basketToTest.addToBasket(i0);
		basketToTest.addToBasket(i1);
		basketToTest.removeAllFromBasket(i0);
		assertEquals(1, basketToTest.count());
	}

	@Test
	public void testAddingDuplicatesAndRemoveAllByValue() {
		Basket basketToTest = makeBasket();
		Item i0 = new Item("Shampoo", 5);
		Item i1 = new Item("Shampoo", 5);
		Item i2 = new Item("Yogurt", 2);
		basketToTest.addToBasket(i0);
		basketToTest.addToBasket(i0);
		basketToTest.addToBasket(i1);
		basketToTest.addToBasket(i2);
		basketToTest.addToBasket(i2);
		assertEquals(true, basketToTest.removeAllFromBasket(i0));
		assertEquals(2, basketToTest.count());
		assertEquals(true, basketToTest.removeAllFromBasket(i2));
		assertEquals(0, basketToTest.count());
		assertEquals(false, basketToTest.removeAllFromBasket(i1));
		assertEquals(0, basketToTest.count());
	}

	@Test
	public void testAddingNull() {
		Basket basketToTest = makeBasket();
		Item i0 = null;
		basketToTest.addToBasket(i0);
		assertEquals(0, basketToTest.count());
	}

	@Test
	public void testRemovingNull() {
		Basket basketToTest = makeBasket();
		Item i0 = null;
		basketToTest.addToBasket(i0);
		assertEquals(false, basketToTest.removeFromBasket(i0));
	}
}