import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.junit.*;

public class MyHashMapTest {
	
	private FileReader filereader;
	private DefaultMap<Integer, Student> testMap; // use this for basic tests

	@Before
	public void setUp() {
		// filereader = new FileReader("src/input.txt");
	}



	//Write testcase for checking max score of 2 sections
	@Test
	public void testGivenFileA() throws IOException {
		filereader = new FileReader("src/input.txt");
		filereader.createHeap();
		assertEquals("James", filereader.getMaxOfSection('A').name);
		assertEquals(94, (int)filereader.getMaxOfSection('A').marks);
	}

	@Test
	public void testGivenFileBC() throws IOException {
		filereader = new FileReader("src/input.txt");
		filereader.createHeap();
		assertEquals("Ria", filereader.getMaxOfSection('B').name);
		assertEquals(88, (int)filereader.getMaxOfSection('B').marks);
		assertEquals("Peter", filereader.getMaxOfSection('C').name);
		assertEquals(70, (int)filereader.getMaxOfSection('C').marks);
	}

	@Test
	public void testEmptyFile() throws IOException {
		filereader = new FileReader("src/test0.txt");
		filereader.createHeap();
		assertEquals(null, filereader.getMaxOfSection('A'));
	}

	@Test
	public void testOneSectionIncreasingScore() throws IOException {
		filereader = new FileReader("src/test1.txt");
		filereader.createHeap();
		assertEquals("Malone", filereader.getMaxOfSection('A').name);
		assertEquals(100, (int)filereader.getMaxOfSection('A').marks);
		assertEquals(null, filereader.getMaxOfSection('B'));
	}

	@Test
	public void testOneSectionDecreasingScore() throws IOException {
		filereader = new FileReader("src/test2.txt");
		filereader.createHeap();
		assertEquals("Yousif", filereader.getMaxOfSection('A').name);
		assertEquals(100, (int)filereader.getMaxOfSection('A').marks);
		assertEquals(null, filereader.getMaxOfSection('C'));
	}

	@Test
	public void testOneSectionRandomScore() throws IOException {
		filereader = new FileReader("src/test3.txt");
		filereader.createHeap();
		assertEquals("Simra", filereader.getMaxOfSection('A').name);
		assertEquals(100, (int)filereader.getMaxOfSection('A').marks);
		assertEquals(null, filereader.getMaxOfSection('C'));
	}

	@Test
	public void testOneSectionDuplicateNames() throws IOException {
		filereader = new FileReader("src/test4.txt");
		filereader.createHeap();
		assertEquals("Simra", filereader.getMaxOfSection('A').name);
		assertEquals(120, (int)filereader.getMaxOfSection('A').marks);
		assertEquals(null, filereader.getMaxOfSection('C'));
	}
	
	@Test
	public void testOneSectionLotsOfStudents() throws IOException {
		filereader = new FileReader("src/test5.txt");
		filereader.createHeap();
		assertEquals("Simra", filereader.getMaxOfSection('A').name);
		assertEquals(120, (int)filereader.getMaxOfSection('A').marks);
		assertEquals(null, filereader.getMaxOfSection('C'));
	}

	@Test
	public void testTwoSectionsIncreasingScore() throws IOException {
		filereader = new FileReader("src/test6.txt");
		filereader.createHeap();
		assertEquals("Malone", filereader.getMaxOfSection('A').name);
		assertEquals(100, (int)filereader.getMaxOfSection('A').marks);
		assertEquals(null, filereader.getMaxOfSection('C'));
		assertEquals("Breanna", filereader.getMaxOfSection('B').name);
		assertEquals(95, (int)filereader.getMaxOfSection('B').marks);
	}

	@Test
	public void testTwoSectionsDecreasingScore() throws IOException {
		filereader = new FileReader("src/test7.txt");
		filereader.createHeap();
		assertEquals("Yousif", filereader.getMaxOfSection('A').name);
		assertEquals(100, (int)filereader.getMaxOfSection('A').marks);
		assertEquals(null, filereader.getMaxOfSection('C'));
		assertEquals("Maysa", filereader.getMaxOfSection('B').name);
		assertEquals(95, (int)filereader.getMaxOfSection('B').marks);
	}

	@Test
	public void testTwoSectionsRandomScore() throws IOException {
		filereader = new FileReader("src/test8.txt");
		filereader.createHeap();
		assertEquals("Maegan", filereader.getMaxOfSection('A').name);
		assertEquals(43, (int)filereader.getMaxOfSection('A').marks);
		assertEquals(null, filereader.getMaxOfSection('C'));
		assertEquals("Simra", filereader.getMaxOfSection('B').name);
		assertEquals(100, (int)filereader.getMaxOfSection('B').marks);
	}

	@Test
	public void testTwoSectionsDuplicateNames() throws IOException {
		filereader = new FileReader("src/test9.txt");
		filereader.createHeap();
		assertEquals("Avleen", filereader.getMaxOfSection('A').name);
		assertEquals(96, (int)filereader.getMaxOfSection('A').marks);
		assertEquals(null, filereader.getMaxOfSection('C'));
		assertEquals("Simra", filereader.getMaxOfSection('B').name);
		assertEquals(120, (int)filereader.getMaxOfSection('B').marks);
	}

	@Test
	public void testTwoSectionsLotsOfNames() throws IOException {
		filereader = new FileReader("src/test10.txt");
		filereader.createHeap();
		assertEquals("Simra", filereader.getMaxOfSection('A').name);
		assertEquals(120, (int)filereader.getMaxOfSection('A').marks);
		assertEquals(null, filereader.getMaxOfSection('C'));
		assertEquals("Malone", filereader.getMaxOfSection('B').name);
		assertEquals(103, (int)filereader.getMaxOfSection('B').marks);
	}

	@Test
	public void testThreeSections() throws IOException {
		filereader = new FileReader("src/test11.txt");
		filereader.createHeap();
		assertEquals("Simra", filereader.getMaxOfSection('A').name);
		assertEquals(120, (int)filereader.getMaxOfSection('A').marks);
		assertEquals("Malone", filereader.getMaxOfSection('B').name);
		assertEquals(103, (int)filereader.getMaxOfSection('B').marks);
		assertEquals("Kevin", filereader.getMaxOfSection('C').name);
		assertEquals(140, (int)filereader.getMaxOfSection('C').marks);
	}
}
