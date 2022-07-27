/**
 * TestSolvers.java is a test file for MazeSolver.java.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntComparator implements Comparator<Integer> {
	public int compare(Integer a, Integer b) {
		return b - a;
	}
}


public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(PriorityQueue<Integer,Square> pq, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, pq);
		if(expected == null) { assertNull(s); }
		else {
			ArrayList<Square> sp = startMaze.storePath();
			String actualStr = formatMaze(startMaze.showSolution(sp));
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}	

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s: arr)
			result += "\n"+s;
		return (result+"\n");
	}

	/* Add your own Worklist tests below */

	/* ************** HINT ******************** 
	 * Use the helper methods to create simple
	 * tests that are easier to debug. 
	 */


	@Test
	public void testshortExample() {
		String[] mazeString = new String[] { 
				"#_#_", 
				"____", 
				"_##S", 
				"F___" 
				};
		int[][] costArray = new int[][] {	{0,0,0,0}, 
											{4,3,2,1}, 
											{5,0,0,0}, 
											{50,8,2,1} };

		Maze m = new Maze(mazeString, costArray);
		String[] queueExpected = { 
				"#_#_", 
				"____", 
				"_##S", 
				"F***", 
				};
		checkMaze(new Heap<Integer, Square>(new IntComparator()), m, queueExpected);
	}

	@Test
	public void testUnsolvable() {
		String[] mazeString = new String[] { 
				"#__#", 
				"____", 
				"#_#S", 
				"F#__" 
				};
		int[][] costArray = new int[][] {	{0,0,0,0}, 
											{1,2,3,4}, 
											{10,0,5,0}, 
											{4,3,2,1} };

		Maze m = new Maze(mazeString, costArray);
		assertEquals(null, MazeSolver.solve(m, new Heap<Integer, Square>(new IntComparator())));
	}

	
}