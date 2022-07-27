import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class TestExam1 {

	@Test
	public void testExamAList() {
		Exam_List<Integer> examList = new Exam_AList<Integer>();
		Integer[] expected0 = new Integer[0];
		assertArrayEquals(expected0, examList.toArray());
		examList.add(1);
		Integer[] expected1 = {1};
		assertArrayEquals(expected1, examList.toArray());
		examList.flipAround(1);
		assertArrayEquals(expected1, examList.toArray());
		examList.add(2);
		Integer[] expected2 = {1,2};
		assertArrayEquals(expected2, examList.toArray());
		examList.flipAround(1);
		Integer[] expected3 = {2,1};
		assertArrayEquals(expected3, examList.toArray());
		examList.flipAround(2);
		assertArrayEquals(expected2, examList.toArray());
		examList.add(3);
		Integer[] expected4 = {1,2,3};
		assertArrayEquals(expected4, examList.toArray());
		examList.flipAround(1);
		Integer[] expected5 = {2,3,1};
		assertArrayEquals(expected5, examList.toArray());
		examList.flipAround(3);
		Integer[] expected6 = {1,3,2};
		assertArrayEquals(expected6, examList.toArray());
		examList.flipAround(2);
		Integer[] expected7 = {2,1,3};
		assertArrayEquals(expected7, examList.toArray());
		examList.add(4);
		Integer[] expected8 = {2,1,3,4};
		assertArrayEquals(expected8, examList.toArray());
		examList.flipAround(2);
		Integer[] expected9 = {1,3,4,2};
		assertArrayEquals(expected9, examList.toArray());
		examList.flipAround(3);
		Integer[] expected10 = {4,2,3,1};
		assertArrayEquals(expected10, examList.toArray());
		examList.flipAround(3);
		Integer[] expected11 = {1,3,4,2};
		assertArrayEquals(expected11, examList.toArray());
		examList.flipAround(2);
		Integer[] expected12 = {2,1,3,4};
		assertArrayEquals(expected12, examList.toArray());
		examList.add(5);
		Integer[] expected13 = {2,1,3,4,5};
		assertArrayEquals(expected13, examList.toArray());
		examList.flipAround(2);
		Integer[] expected14 = {1,3,4,5,2};
		assertArrayEquals(expected14, examList.toArray());
		examList.flipAround(3);
		Integer[] expected15 = {4,5,2,3,1};
		assertArrayEquals(expected15, examList.toArray());
		examList.flipAround(2);
		Integer[] expected16 = {3,1,2,4,5};
		assertArrayEquals(expected16, examList.toArray());
		examList.flipAround(4);
		Integer[] expected17 = {5,4,3,1,2};
		assertArrayEquals(expected17, examList.toArray());
		examList.flipAround(2);
		Integer[] expected18 = {2,5,4,3,1};
		assertArrayEquals(expected18, examList.toArray());
	}
	
	@Test
	public void testExamLList() {
		Exam_List<Integer> examList = new Exam_LList<Integer>();
		Integer[] expected0 = new Integer[0];
		assertArrayEquals(expected0, examList.toArray());
		examList.add(1);
		Integer[] expected1 = {1};
		assertArrayEquals(expected1, examList.toArray());
		examList.flipAround(1);
		assertArrayEquals(expected1, examList.toArray());
		examList.add(2);
		Integer[] expected2 = {1,2};
		assertArrayEquals(expected2, examList.toArray());
		examList.flipAround(1);
		Integer[] expected3 = {2,1};
		assertArrayEquals(expected3, examList.toArray());
		examList.flipAround(2);
		assertArrayEquals(expected2, examList.toArray());
		examList.add(3);
		Integer[] expected4 = {1,2,3};
		assertArrayEquals(expected4, examList.toArray());
		examList.flipAround(1);
		Integer[] expected5 = {2,3,1};
		assertArrayEquals(expected5, examList.toArray());
		examList.flipAround(3);
		Integer[] expected6 = {1,3,2};
		assertArrayEquals(expected6, examList.toArray());
		examList.flipAround(2);
		Integer[] expected7 = {2,1,3};
		assertArrayEquals(expected7, examList.toArray());
		examList.add(4);
		Integer[] expected8 = {2,1,3,4};
		assertArrayEquals(expected8, examList.toArray());
		examList.flipAround(2);
		Integer[] expected9 = {1,3,4,2};
		assertArrayEquals(expected9, examList.toArray());
		examList.flipAround(3);
		Integer[] expected10 = {4,2,3,1};
		assertArrayEquals(expected10, examList.toArray());
		examList.flipAround(3);
		Integer[] expected11 = {1,3,4,2};
		assertArrayEquals(expected11, examList.toArray());
		examList.flipAround(2);
		Integer[] expected12 = {2,1,3,4};
		assertArrayEquals(expected12, examList.toArray());
		examList.add(5);
		Integer[] expected13 = {2,1,3,4,5};
		assertArrayEquals(expected13, examList.toArray());
		examList.flipAround(2);
		Integer[] expected14 = {1,3,4,5,2};
		assertArrayEquals(expected14, examList.toArray());
		examList.flipAround(3);
		Integer[] expected15 = {4,5,2,3,1};
		assertArrayEquals(expected15, examList.toArray());
		examList.flipAround(2);
		Integer[] expected16 = {3,1,2,4,5};
		assertArrayEquals(expected16, examList.toArray());
		examList.flipAround(4);
		Integer[] expected17 = {5,4,3,1,2};
		assertArrayEquals(expected17, examList.toArray());
		examList.flipAround(2);
		Integer[] expected18 = {2,5,4,3,1};
		assertArrayEquals(expected18, examList.toArray());
	}
	
	@Test
	public void testExamAListString() {
		Exam_List<String> examList = new Exam_AList<String>();
		String[] expected0 = new String[0];
		assertArrayEquals(expected0, examList.toArray());
		examList.add("one");
		String[] expected1 = {"one"};
		assertArrayEquals(expected1, examList.toArray());
		examList.flipAround("one");
		assertArrayEquals(expected1, examList.toArray());
		examList.add("two");
		String[] expected2 = {"one", "two"};
		assertArrayEquals(expected2, examList.toArray());
		examList.flipAround("one");
		String[] expected3 = {"two", "one"};
		assertArrayEquals(expected3, examList.toArray());
		examList.flipAround("two");
		assertArrayEquals(expected2, examList.toArray());
		examList.add("three");
		String[] expected4 = {"one", "two", "three"};
		assertArrayEquals(expected4, examList.toArray());
		examList.flipAround("one");
		String[] expected5 = {"two", "three", "one"};
		assertArrayEquals(expected5, examList.toArray());
		examList.flipAround("three");
		String[] expected6 = {"one", "three", "two"};
		assertArrayEquals(expected6, examList.toArray());
		examList.flipAround("two");
		String[] expected7 = {"two", "one", "three"};
		assertArrayEquals(expected7, examList.toArray());
		examList.add("four");
		String[] expected8 = {"two", "one", "three", "four"};
		assertArrayEquals(expected8, examList.toArray());
		examList.flipAround("two");
		String[] expected9 = {"one", "three", "four", "two"};
		assertArrayEquals(expected9, examList.toArray());
		examList.flipAround("three");
		String[] expected10 = {"four", "two", "three", "one"};
		assertArrayEquals(expected10, examList.toArray());
		examList.flipAround("three");
		String[] expected11 = {"one", "three", "four", "two"};
		assertArrayEquals(expected11, examList.toArray());
		examList.flipAround("two");
		String[] expected12 = {"two", "one", "three", "four"};
		assertArrayEquals(expected12, examList.toArray());
		examList.add("five");
		String[] expected13 = {"two", "one", "three", "four", "five"};
		assertArrayEquals(expected13, examList.toArray());
		examList.flipAround("two");
		String[] expected14 = {"one", "three", "four", "five", "two"};
		assertArrayEquals(expected14, examList.toArray());
		examList.flipAround("three");
		String[] expected15 = {"four", "five", "two", "three", "one"};
		assertArrayEquals(expected15, examList.toArray());
		examList.flipAround("two");
		String[] expected16 = {"three", "one", "two", "four", "five"};
		assertArrayEquals(expected16, examList.toArray());
		examList.flipAround("four");
		String[] expected17 = {"five", "four", "three", "one", "two"};
		assertArrayEquals(expected17, examList.toArray());
		examList.flipAround("two");
		String[] expected18 = {"two", "five", "four", "three", "one"};
		assertArrayEquals(expected18, examList.toArray());
	}
	
	@Test
	public void testExamLListString() {
		Exam_List<String> examList = new Exam_LList<String>();
		String[] expected0 = new String[0];
		assertArrayEquals(expected0, examList.toArray());
		examList.add("one");
		String[] expected1 = {"one"};
		assertArrayEquals(expected1, examList.toArray());
		examList.flipAround("one");
		assertArrayEquals(expected1, examList.toArray());
		examList.add("two");
		String[] expected2 = {"one", "two"};
		assertArrayEquals(expected2, examList.toArray());
		examList.flipAround("one");
		String[] expected3 = {"two", "one"};
		assertArrayEquals(expected3, examList.toArray());
		examList.flipAround("two");
		assertArrayEquals(expected2, examList.toArray());
		examList.add("three");
		String[] expected4 = {"one", "two", "three"};
		assertArrayEquals(expected4, examList.toArray());
		examList.flipAround("one");
		String[] expected5 = {"two", "three", "one"};
		assertArrayEquals(expected5, examList.toArray());
		examList.flipAround("three");
		String[] expected6 = {"one", "three", "two"};
		assertArrayEquals(expected6, examList.toArray());
		examList.flipAround("two");
		String[] expected7 = {"two", "one", "three"};
		assertArrayEquals(expected7, examList.toArray());
		examList.add("four");
		String[] expected8 = {"two", "one", "three", "four"};
		assertArrayEquals(expected8, examList.toArray());
		examList.flipAround("two");
		String[] expected9 = {"one", "three", "four", "two"};
		assertArrayEquals(expected9, examList.toArray());
		examList.flipAround("three");
		String[] expected10 = {"four", "two", "three", "one"};
		assertArrayEquals(expected10, examList.toArray());
		examList.flipAround("three");
		String[] expected11 = {"one", "three", "four", "two"};
		assertArrayEquals(expected11, examList.toArray());
		examList.flipAround("two");
		String[] expected12 = {"two", "one", "three", "four"};
		assertArrayEquals(expected12, examList.toArray());
		examList.add("five");
		String[] expected13 = {"two", "one", "three", "four", "five"};
		assertArrayEquals(expected13, examList.toArray());
		examList.flipAround("two");
		String[] expected14 = {"one", "three", "four", "five", "two"};
		assertArrayEquals(expected14, examList.toArray());
		examList.flipAround("three");
		String[] expected15 = {"four", "five", "two", "three", "one"};
		assertArrayEquals(expected15, examList.toArray());
		examList.flipAround("two");
		String[] expected16 = {"three", "one", "two", "four", "five"};
		assertArrayEquals(expected16, examList.toArray());
		examList.flipAround("four");
		String[] expected17 = {"five", "four", "three", "one", "two"};
		assertArrayEquals(expected17, examList.toArray());
		examList.flipAround("two");
		String[] expected18 = {"two", "five", "four", "three", "one"};
		assertArrayEquals(expected18, examList.toArray());
	}
	
	@Test
	public void testAddNull() {
		Exam_List<Integer> examList = new Exam_AList<Integer>();
		Integer[] expected0 = new Integer[0];
		assertArrayEquals(expected0, examList.toArray());
		examList.add(null);
		Integer[] expected1 = {null};
		assertArrayEquals(expected1, examList.toArray());
		examList.flipAround(null);
		assertArrayEquals(expected1, examList.toArray());
		examList.add(1);
		Integer[] expected2 = {null, 1};
		assertArrayEquals(expected2, examList.toArray());
		examList.flipAround(null);
		Integer[] expected3 = {1, null};
		assertArrayEquals(expected3, examList.toArray());
		examList.flipAround(null);
		assertArrayEquals(expected2, examList.toArray());
		examList.add(null);
		Integer[] expected4 = {null, 1, null};
		assertArrayEquals(expected4, examList.toArray());
		examList.flipAround(null);
		Integer[] expected5 = {1, null, null};
		assertArrayEquals(expected5, examList.toArray());
		examList.flipAround(null);
		Integer[] expected6 = {null, null, 1};
		assertArrayEquals(expected6, examList.toArray());
		examList.flipAround(1);
		assertArrayEquals(expected5, examList.toArray());
		examList.add(2);
		Integer[] expected7 = {1, null, null, 2};
		assertArrayEquals(expected7, examList.toArray());
		examList.flipAround(1);
		Integer[] expected8 = {null, null, 2, 1};
		assertArrayEquals(expected8, examList.toArray());
		examList.flipAround(null);
		Integer[] expected9 = {null, 2, 1, null};
		assertArrayEquals(expected9, examList.toArray());
		examList.flipAround(1);
		Integer[] expected10 = {null, 1, null, 2};
		assertArrayEquals(expected10, examList.toArray());
		examList.flipAround(2);
		Integer[] expected11 = {2, null, 1, null};
		assertArrayEquals(expected11, examList.toArray());
		examList.add(3);
		Integer[] expected12 = {2, null, 1, null, 3};
		assertArrayEquals(expected12, examList.toArray());
		examList.flipAround(2);
		Integer[] expected13 = {null, 1, null, 3, 2};
		assertArrayEquals(expected13, examList.toArray());
		examList.flipAround(1);
		Integer[] expected14 = {null, 3, 2, 1, null};
		assertArrayEquals(expected14, examList.toArray());
		examList.flipAround(2);
		Integer[] expected15 = {1, null, 2, null, 3};
		assertArrayEquals(expected15, examList.toArray());
		examList.flipAround(null);
		Integer[] expected16 = {2, null, 3, null, 1};
		assertArrayEquals(expected16, examList.toArray());
		examList.flipAround(1);
		Integer[] expected17 = {1, 2, null, 3, null};
		assertArrayEquals(expected17, examList.toArray());
		examList = new Exam_AList<Integer>();
		examList.add(null);
		examList.add(null);
		Integer[] expected18 = {null, null};
		assertArrayEquals(expected18, examList.toArray());
		examList.flipAround(null);
		assertArrayEquals(expected18, examList.toArray());
		examList.add(null);
		Integer[] expected19 = {null, null, null};
		assertArrayEquals(expected19, examList.toArray());
		examList.flipAround(null);
		assertArrayEquals(expected19, examList.toArray());
		examList.add(null);
		Integer[] expected20 = {null, null, null, null};
		assertArrayEquals(expected20, examList.toArray());
		examList.flipAround(null);
		assertArrayEquals(expected20, examList.toArray());
		examList.add(null);
		Integer[] expected21 = {null, null, null, null, null};
		assertArrayEquals(expected21, examList.toArray());
		examList.flipAround(null);
		assertArrayEquals(expected21, examList.toArray());
	}
	
	@Test
	public void testAddNull2() {
		Exam_List<Integer> examList = new Exam_LList<Integer>();
		Integer[] expected0 = new Integer[0];
		assertArrayEquals(expected0, examList.toArray());
		examList.add(null);
		Integer[] expected1 = {null};
		assertArrayEquals(expected1, examList.toArray());
		examList.flipAround(null);
		assertArrayEquals(expected1, examList.toArray());
		examList.add(1);
		Integer[] expected2 = {null, 1};
		assertArrayEquals(expected2, examList.toArray());
		examList.flipAround(null);
		Integer[] expected3 = {1, null};
		assertArrayEquals(expected3, examList.toArray());
		examList.flipAround(null);
		assertArrayEquals(expected2, examList.toArray());
		examList.add(null);
		Integer[] expected4 = {null, 1, null};
		assertArrayEquals(expected4, examList.toArray());
		examList.flipAround(null);
		Integer[] expected5 = {1, null, null};
		assertArrayEquals(expected5, examList.toArray());
		examList.flipAround(null);
		Integer[] expected6 = {null, null, 1};
		assertArrayEquals(expected6, examList.toArray());
		examList.flipAround(1);
		assertArrayEquals(expected5, examList.toArray());
		examList.add(2);
		Integer[] expected7 = {1, null, null, 2};
		assertArrayEquals(expected7, examList.toArray());
		examList.flipAround(1);
		Integer[] expected8 = {null, null, 2, 1};
		assertArrayEquals(expected8, examList.toArray());
		examList.flipAround(null);
		Integer[] expected9 = {null, 2, 1, null};
		assertArrayEquals(expected9, examList.toArray());
		examList.flipAround(1);
		Integer[] expected10 = {null, 1, null, 2};
		assertArrayEquals(expected10, examList.toArray());
		examList.flipAround(2);
		Integer[] expected11 = {2, null, 1, null};
		assertArrayEquals(expected11, examList.toArray());
		examList.add(3);
		Integer[] expected12 = {2, null, 1, null, 3};
		assertArrayEquals(expected12, examList.toArray());
		examList.flipAround(2);
		Integer[] expected13 = {null, 1, null, 3, 2};
		assertArrayEquals(expected13, examList.toArray());
		examList.flipAround(1);
		Integer[] expected14 = {null, 3, 2, 1, null};
		assertArrayEquals(expected14, examList.toArray());
		examList.flipAround(2);
		Integer[] expected15 = {1, null, 2, null, 3};
		assertArrayEquals(expected15, examList.toArray());
		examList.flipAround(null);
		Integer[] expected16 = {2, null, 3, null, 1};
		assertArrayEquals(expected16, examList.toArray());
		examList.flipAround(1);
		Integer[] expected17 = {1, 2, null, 3, null};
		assertArrayEquals(expected17, examList.toArray());
		examList = new Exam_AList<Integer>();
		examList.add(null);
		examList.add(null);
		Integer[] expected18 = {null, null};
		assertArrayEquals(expected18, examList.toArray());
		examList.flipAround(null);
		assertArrayEquals(expected18, examList.toArray());
		examList.add(null);
		Integer[] expected19 = {null, null, null};
		assertArrayEquals(expected19, examList.toArray());
		examList.flipAround(null);
		assertArrayEquals(expected19, examList.toArray());
		examList.add(null);
		Integer[] expected20 = {null, null, null, null};
		assertArrayEquals(expected20, examList.toArray());
		examList.flipAround(null);
		assertArrayEquals(expected20, examList.toArray());
		examList.add(null);
		Integer[] expected21 = {null, null, null, null, null};
		assertArrayEquals(expected21, examList.toArray());
		examList.flipAround(null);
		assertArrayEquals(expected21, examList.toArray());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testNoSuchElementException() {
		Exam_List<String> examList = new Exam_AList<String>();
		examList.flipAround("four");
	}
	
	@Test
	public void testDuplicates() {
		Exam_List<Integer> examList = new Exam_LList<Integer>();
		examList.add(1);
		examList.add(2);
		examList.add(3);
		examList.add(2);
		examList.add(4);
		examList.flipAround(2);
		Integer[] expected = {3,2,4,2,1};
		assertArrayEquals(expected, examList.toArray());
		examList.flipAround(2);
		Integer[] expected2 = {4,2,1,2,3};
		assertArrayEquals(expected2, examList.toArray());
	}
	
	@Test
	public void testAutoGraderStackAccept() throws Exception {
		Exam_SQ<Ticket> tickets = new Exam_Stack<>();
		Autograder myGrader = new Autograder(tickets);
		Ticket ticket0 = new Ticket();
		myGrader.add(ticket0);
		assertEquals("", ticket0.status);
		myGrader.accept();
		assertEquals("accepted", ticket0.status);
		Ticket ticket1 = new Ticket();
		myGrader.add(ticket1);
		assertEquals("", ticket1.status);
		myGrader.accept();
		assertEquals("accepted", ticket1.status);
		Ticket ticket2 = new Ticket();
		myGrader.add(ticket2);
		assertEquals("", ticket2.status);
		myGrader.accept();
		assertEquals("accepted", ticket2.status);
		Ticket ticket3 = new Ticket();
		Ticket ticket4 = new Ticket();
		Ticket ticket5 = new Ticket();
		myGrader.add(ticket3);
		myGrader.add(ticket4);
		myGrader.add(ticket5);
		assertEquals("", ticket3.status);
		assertEquals("", ticket4.status);
		assertEquals("", ticket5.status);
		myGrader.accept();
		assertEquals("accepted", ticket3.status);
		assertEquals("", ticket4.status);
		assertEquals("", ticket5.status);
		myGrader.accept();
		assertEquals("accepted", ticket4.status);
		assertEquals("", ticket5.status);
		myGrader.accept();
		assertEquals("accepted", ticket5.status);
		myGrader.accept();
		assertEquals("accepted", ticket0.status);
		assertEquals("accepted", ticket1.status);
		assertEquals("accepted", ticket2.status);
		assertEquals("accepted", ticket3.status);
		assertEquals("accepted", ticket4.status);
		assertEquals("accepted", ticket5.status);
		myGrader.accept();
		myGrader.accept();
		myGrader.accept();
		assertEquals("accepted", ticket0.status);
		assertEquals("accepted", ticket1.status);
		assertEquals("accepted", ticket2.status);
		assertEquals("accepted", ticket3.status);
		assertEquals("accepted", ticket4.status);
		assertEquals("accepted", ticket5.status);
		Ticket ticket6 = new Ticket();
		myGrader.add(ticket6);
		assertEquals("", ticket6.status);
	}
	
	@Test
	public void testAutoGraderQueueAccept() throws Exception {
		Exam_SQ<Ticket> tickets = new Exam_Queue<>();
		Autograder myGrader = new Autograder(tickets);
		Ticket ticket0 = new Ticket();
		myGrader.add(ticket0);
		assertEquals("", ticket0.status);
		myGrader.accept();
		assertEquals("accepted", ticket0.status);
		Ticket ticket1 = new Ticket();
		myGrader.add(ticket1);
		assertEquals("", ticket1.status);
		myGrader.accept();
		assertEquals("accepted", ticket1.status);
		Ticket ticket2 = new Ticket();
		myGrader.add(ticket2);
		assertEquals("", ticket2.status);
		myGrader.accept();
		assertEquals("accepted", ticket2.status);
		Ticket ticket3 = new Ticket();
		Ticket ticket4 = new Ticket();
		Ticket ticket5 = new Ticket();
		myGrader.add(ticket3);
		myGrader.add(ticket4);
		myGrader.add(ticket5);
		assertEquals("", ticket3.status);
		assertEquals("", ticket4.status);
		assertEquals("", ticket5.status);
		myGrader.accept();
		assertEquals("accepted", ticket3.status);
		assertEquals("", ticket4.status);
		assertEquals("", ticket5.status);
		myGrader.accept();
		assertEquals("accepted", ticket4.status);
		assertEquals("", ticket5.status);
		myGrader.accept();
		assertEquals("accepted", ticket5.status);
		myGrader.accept();
		assertEquals("accepted", ticket0.status);
		assertEquals("accepted", ticket1.status);
		assertEquals("accepted", ticket2.status);
		assertEquals("accepted", ticket3.status);
		assertEquals("accepted", ticket4.status);
		assertEquals("accepted", ticket5.status);
		myGrader.accept();
		myGrader.accept();
		myGrader.accept();
		assertEquals("accepted", ticket0.status);
		assertEquals("accepted", ticket1.status);
		assertEquals("accepted", ticket2.status);
		assertEquals("accepted", ticket3.status);
		assertEquals("accepted", ticket4.status);
		assertEquals("accepted", ticket5.status);
		Ticket ticket6 = new Ticket();
		myGrader.add(ticket6);
		assertEquals("", ticket6.status);
	}
	
	@Test
	public void testAutoGraderStackCancel() throws Exception {
		Exam_SQ<Ticket> tickets = new Exam_Stack<>();
		Autograder myGrader = new Autograder(tickets);
		Ticket ticket0 = new Ticket();
		myGrader.add(ticket0);
		assertEquals("", ticket0.status);
		myGrader.cancel();
		assertEquals("canceled", ticket0.status);
		Ticket ticket1 = new Ticket();
		myGrader.add(ticket1);
		assertEquals("", ticket1.status);
		myGrader.cancel();
		assertEquals("canceled", ticket1.status);
		Ticket ticket2 = new Ticket();
		myGrader.add(ticket2);
		assertEquals("", ticket2.status);
		myGrader.cancel();
		assertEquals("canceled", ticket2.status);
		Ticket ticket3 = new Ticket();
		Ticket ticket4 = new Ticket();
		Ticket ticket5 = new Ticket();
		myGrader.add(ticket3);
		myGrader.add(ticket4);
		myGrader.add(ticket5);
		assertEquals("", ticket3.status);
		assertEquals("", ticket4.status);
		assertEquals("", ticket5.status);
		myGrader.cancel();
		assertEquals("canceled", ticket3.status);
		assertEquals("", ticket4.status);
		assertEquals("", ticket5.status);
		myGrader.cancel();
		assertEquals("canceled", ticket4.status);
		assertEquals("", ticket5.status);
		myGrader.cancel();
		assertEquals("canceled", ticket5.status);
		myGrader.cancel();
		assertEquals("canceled", ticket0.status);
		assertEquals("canceled", ticket1.status);
		assertEquals("canceled", ticket2.status);
		assertEquals("canceled", ticket3.status);
		assertEquals("canceled", ticket4.status);
		assertEquals("canceled", ticket5.status);
		myGrader.cancel();
		myGrader.cancel();
		myGrader.cancel();
		assertEquals("canceled", ticket0.status);
		assertEquals("canceled", ticket1.status);
		assertEquals("canceled", ticket2.status);
		assertEquals("canceled", ticket3.status);
		assertEquals("canceled", ticket4.status);
		assertEquals("canceled", ticket5.status);
		Ticket ticket6 = new Ticket();
		myGrader.add(ticket6);
		assertEquals("", ticket6.status);
	}
	
	@Test
	public void testAutoGraderQueueCancel() throws Exception {
		Exam_SQ<Ticket> tickets = new Exam_Queue<>();
		Autograder myGrader = new Autograder(tickets);
		Ticket ticket0 = new Ticket();
		myGrader.add(ticket0);
		assertEquals("", ticket0.status);
		myGrader.cancel();
		assertEquals("canceled", ticket0.status);
		Ticket ticket1 = new Ticket();
		myGrader.add(ticket1);
		assertEquals("", ticket1.status);
		myGrader.cancel();
		assertEquals("canceled", ticket1.status);
		Ticket ticket2 = new Ticket();
		myGrader.add(ticket2);
		assertEquals("", ticket2.status);
		myGrader.cancel();
		assertEquals("canceled", ticket2.status);
		Ticket ticket3 = new Ticket();
		Ticket ticket4 = new Ticket();
		Ticket ticket5 = new Ticket();
		myGrader.add(ticket3);
		myGrader.add(ticket4);
		myGrader.add(ticket5);
		assertEquals("", ticket3.status);
		assertEquals("", ticket4.status);
		assertEquals("", ticket5.status);
		myGrader.cancel();
		assertEquals("canceled", ticket3.status);
		assertEquals("", ticket4.status);
		assertEquals("", ticket5.status);
		myGrader.cancel();
		assertEquals("canceled", ticket4.status);
		assertEquals("", ticket5.status);
		myGrader.cancel();
		assertEquals("canceled", ticket5.status);
		myGrader.cancel();
		assertEquals("canceled", ticket0.status);
		assertEquals("canceled", ticket1.status);
		assertEquals("canceled", ticket2.status);
		assertEquals("canceled", ticket3.status);
		assertEquals("canceled", ticket4.status);
		assertEquals("canceled", ticket5.status);
		myGrader.cancel();
		myGrader.cancel();
		myGrader.cancel();
		assertEquals("canceled", ticket0.status);
		assertEquals("canceled", ticket1.status);
		assertEquals("canceled", ticket2.status);
		assertEquals("canceled", ticket3.status);
		assertEquals("canceled", ticket4.status);
		assertEquals("canceled", ticket5.status);
		Ticket ticket6 = new Ticket();
		myGrader.add(ticket6);
		assertEquals("", ticket6.status);
	}
	
	@Test
	public void testAutoGraderStack() throws Exception {
		Exam_SQ<Ticket> tickets = new Exam_Stack<>();
		Autograder myGrader = new Autograder(tickets);
		Ticket ticket0 = new Ticket();
		Ticket ticket1 = new Ticket();
		Ticket ticket2 = new Ticket();
		myGrader.add(ticket0);
		myGrader.add(ticket1);
		myGrader.add(ticket2);
		assertEquals("", ticket0.status);
		assertEquals("", ticket1.status);
		assertEquals("", ticket2.status);
		myGrader.accept();
		myGrader.cancel();
		assertEquals("accepted", ticket0.status);
		assertEquals("canceled", ticket1.status);
		assertEquals("", ticket2.status);
		myGrader.accept();
		assertEquals("accepted", ticket2.status);
		Ticket ticket3 = new Ticket();
		myGrader.add(ticket3);
		myGrader.cancel();
		assertEquals("canceled", ticket3.status);
		Ticket ticket4 = new Ticket();
		myGrader.add(ticket4);
		myGrader.accept();
		assertEquals("accepted", ticket4.status);
		Ticket ticket5 = new Ticket();
		myGrader.add(ticket5);
		myGrader.add(ticket5);
		myGrader.add(ticket5);
		myGrader.add(ticket5);
		myGrader.accept();
		assertEquals("accepted", ticket5.status);
		myGrader.cancel();
		assertEquals("accepted", ticket5.status);
		myGrader.accept();
		assertEquals("accepted", ticket5.status);
		myGrader.cancel();
		assertEquals("accepted", ticket5.status);
		Ticket ticket7 = new Ticket();
		tickets.add(ticket7);
		myGrader.accept();
		assertEquals("accepted", ticket7.status);
	}
	
	@Test
	public void testAutoGraderQueue() throws Exception {
		Exam_SQ<Ticket> tickets = new Exam_Queue<>();
		Autograder myGrader = new Autograder(tickets);
		Ticket ticket0 = new Ticket();
		Ticket ticket1 = new Ticket();
		Ticket ticket2 = new Ticket();
		myGrader.add(ticket0);
		myGrader.add(ticket1);
		myGrader.add(ticket2);
		assertEquals("", ticket0.status);
		assertEquals("", ticket1.status);
		assertEquals("", ticket2.status);
		myGrader.accept();
		myGrader.cancel();
		assertEquals("accepted", ticket0.status);
		assertEquals("canceled", ticket1.status);
		assertEquals("", ticket2.status);
		myGrader.accept();
		assertEquals("accepted", ticket2.status);
		Ticket ticket3 = new Ticket();
		myGrader.add(ticket3);
		myGrader.cancel();
		assertEquals("canceled", ticket3.status);
		Ticket ticket4 = new Ticket();
		myGrader.add(ticket4);
		myGrader.accept();
		assertEquals("accepted", ticket4.status);
		Ticket ticket5 = new Ticket();
		myGrader.add(ticket5);
		myGrader.add(ticket5);
		myGrader.add(ticket5);
		myGrader.add(ticket5);
		myGrader.accept();
		assertEquals("accepted", ticket5.status);
		myGrader.cancel();
		assertEquals("accepted", ticket5.status);
		myGrader.accept();
		assertEquals("accepted", ticket5.status);
		myGrader.cancel();
		assertEquals("accepted", ticket5.status);
		Ticket ticket7 = new Ticket();
		tickets.add(ticket7);
		myGrader.accept();
		assertEquals("accepted", ticket7.status);
	}
	
	@Test
	public void testAutoGraderNull() throws Exception {
		Exam_SQ<Ticket> tickets = new Exam_Stack<>();
		Autograder myGrader = new Autograder(tickets);
		Ticket ticket0 = new Ticket();
		Ticket ticket1 = null;
		Ticket ticket2 = new Ticket();
		myGrader.add(ticket0);
		myGrader.add(ticket1);
		myGrader.add(ticket2);
		assertEquals("", ticket0.status);
		assertEquals("", ticket2.status);
		myGrader.accept();
		myGrader.cancel();
		assertEquals("accepted", ticket0.status);
		assertEquals("canceled", ticket2.status);
	}
	
	@Test
	public void testTask31(){
		Exam_List<Integer> myLinkedList = new Exam_LList<>();
		myLinkedList.add(1);
		myLinkedList.add(2);
		myLinkedList.add(3);
		myLinkedList.add(4);
		myLinkedList.add(5);
		// head/dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> null
		/*
		 * myLinkedList: Exam_LList [head: head, size: 5]
		 * head: Node [value: null, next: node1]
		 * node1: Node [value: 1, next: node2]
		 * node2: Node [value: 2, next: node3]
		 * node3: Node [value: 3, next: node4]
		 * node4: Node [value: 4, next: node5]
		 * node5: Node [value: 5, next: null]
		 */
		myLinkedList.flipAround(3);
		/*
		 * myLinkedList: Exam_LList [head: head, size: 5]
		 * head: Node [value: null, next: node4]
		 * node1: Node [value: 1, next: node2]
		 * node2: Node [value: 2, next: null]
		 * node3: Node [value: 3, next: node1]
		 * node4: Node [value: 4, next: node5]
		 * node5: Node [value: 5, next: node3]
		 * found; true
		 * target: node3
		 * tail: node5
		 * first: node1
		 * current: node2
		 */
		// head/dummy -> 4 -> 5 -> 3 -> 1 -> 2 -> null
		Integer[] expected = {4, 5, 3, 1, 2};
		assertArrayEquals(expected, myLinkedList.toArray());
	}
	
	@Test
	public void testTask32() throws Exception{
		Ticket ticket0 = new Ticket();
		Ticket ticket1 = new Ticket();
		Ticket ticket2 = new Ticket();
		Ticket ticket3 = new Ticket();
		Exam_SQ<Ticket> stackTickets = new Exam_Stack<>();
		Autograder stackGrader = new Autograder(stackTickets);
		stackGrader.add(ticket0);
		stackGrader.add(ticket1);
		stackGrader.add(ticket2);
		stackGrader.add(ticket3);
		/*
		 * ticket0: Ticket [status: ""]
		 * ticket1: Ticket [status: ""]
		 * ticket2: Ticket [status: ""]
		 * ticket3: Ticket [status: ""]
		 * stackTickets: Exam_Stack [stack: {ticket0, ticket1, ticket2, ticket3}(ArrayList)]
		 * stackGrader: Autograder [tickets: stackTickets]
		 * 
		 */
		stackGrader.accept();
		stackGrader.accept();
		stackGrader.cancel();
		stackGrader.cancel();
		/*
		 * ticket0: Ticket [status: "accepted"]
		 * ticket1: Ticket [status: "accepted"]
		 * ticket2: Ticket [status: "canceled"]
		 * ticket3: Ticket [status: "canceled"]
		 * stackTickets: Exam_Stack [stack: {ticket0, ticket1, ticket2, ticket3}(ArrayList)]
		 * stackGrader: Autograder [tickets: stackTickets]
		 * popped: {ticket3, ticket2, ticket1, ticket0}
		 */
		assertEquals("accepted", ticket0.status);
		assertEquals("accepted", ticket1.status);
		assertEquals("canceled", ticket2.status);
		assertEquals("canceled", ticket3.status);
		
		Ticket ticket4 = new Ticket();
		Ticket ticket5 = new Ticket();
		Ticket ticket6 = new Ticket();
		Ticket ticket7 = new Ticket();
		Exam_SQ<Ticket> queueTickets = new Exam_Queue<>();
		Autograder queueGrader = new Autograder(queueTickets);
		stackGrader.add(ticket4);
		stackGrader.add(ticket5);
		stackGrader.add(ticket6);
		stackGrader.add(ticket7);
		
		/*
		 * ticket4: Ticket [status: ""]
		 * ticket5: Ticket [status: ""]
		 * ticket6: Ticket [status: ""]
		 * ticket7: Ticket [status: ""]
		 * queueTickets: Exam_Queue [queue: {ticket4, ticket5, ticket6, ticket7}(ArrayList)]
		 * queueGrader: Autograder [tickets: queueTickets]
		 * 
		 */
		stackGrader.accept();
		stackGrader.accept();
		stackGrader.cancel();
		stackGrader.cancel();
		/*
		 * ticket4: Ticket [status: "accepted"]
		 * ticket5: Ticket [status: "accepted"]
		 * ticket6: Ticket [status: "canceled"]
		 * ticket7: Ticket [status: "canceled"]
		 * queueTickets: Exam_Queue [queue: {ticket4, ticket5, ticket6, ticket7}(ArrayList)]
		 * queueGrader: Autograder [tickets: queueTickets]
		 * popped: {ticket4, ticket5, ticket6, ticket7}
		 * 
		 */
		assertEquals("accepted", ticket4.status);
		assertEquals("accepted", ticket5.status);
		assertEquals("canceled", ticket6.status);
		assertEquals("canceled", ticket7.status);
	}
}
