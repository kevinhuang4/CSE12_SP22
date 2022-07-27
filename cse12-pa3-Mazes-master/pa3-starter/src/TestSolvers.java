import java.util.ArrayList;
import java.util.Locale;

/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
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
	public void testNoWallMaze() {
		SearchWorklist stackWl = new StackWorklist();
		SearchWorklist queueWl = new QueueWorklist();
		Maze noWallMaze = new Maze(new String [] {
				"S___",
				"____",
				"_F__",
				"____"
		});
		String[] noWallMazeStackSolution = new String [] {
				"S***",
				"___*",
				"_F**",
				"____"
		};
		String[] noWallMazeQueueSolution = new String [] {
				"S___",
				"*___",
				"*F__",
				"____"
		};
		this.checkMaze(stackWl, noWallMaze, noWallMazeStackSolution);
		noWallMaze = new Maze(new String [] {
				"S___",
				"____",
				"_F__",
				"____"
		});
		this.checkMaze(queueWl, noWallMaze, noWallMazeQueueSolution);
		
		stackWl = new StackWorklist();
		queueWl = new QueueWorklist();
		noWallMaze = new Maze(new String [] {
				"S___",
				"____",
				"F___",
				"____"
		});
		noWallMazeStackSolution = new String [] {
				"S***",
				"___*",
				"F***",
				"____"
		};
		noWallMazeQueueSolution = new String [] {
				"S___",
				"*___",
				"F___",
				"____"
		};
		this.checkMaze(stackWl, noWallMaze, noWallMazeStackSolution);
		noWallMaze = new Maze(new String [] {
				"S___",
				"____",
				"F___",
				"____"
		});
		this.checkMaze(queueWl, noWallMaze, noWallMazeQueueSolution);
		
		stackWl = new StackWorklist();
		queueWl = new QueueWorklist();
		noWallMaze = new Maze(new String [] {
				"S___",
				"____",
				"___F",
				"____"
		});
		noWallMazeStackSolution = new String [] {
				"S***",
				"___*",
				"___F",
				"____"
		};
		noWallMazeQueueSolution = new String [] {
				"S___",
				"*___",
				"***F",
				"____"
		};
		this.checkMaze(stackWl, noWallMaze, noWallMazeStackSolution);
		noWallMaze = new Maze(new String [] {
				"S___",
				"____",
				"___F",
				"____"
		});
		this.checkMaze(queueWl, noWallMaze, noWallMazeQueueSolution);
		
		stackWl = new StackWorklist();
		queueWl = new QueueWorklist();
		noWallMaze = new Maze(new String [] {
				"S___",
				"____",
				"____",
				"___F"
		});
		noWallMazeStackSolution = new String [] {
				"S***",
				"___*",
				"___*",
				"___F"
		};
		noWallMazeQueueSolution = new String [] {
				"S___",
				"*___",
				"*___",
				"***F"
		};
		this.checkMaze(stackWl, noWallMaze, noWallMazeStackSolution);
		noWallMaze = new Maze(new String [] {
				"S___",
				"____",
				"____",
				"___F"
		});
		this.checkMaze(queueWl, noWallMaze, noWallMazeQueueSolution);
	}
	
	@Test
	public void testManyWallMaze() {
		SearchWorklist stackWl = new StackWorklist();
		SearchWorklist queueWl = new QueueWorklist();
		Maze ManyWallMaze = new Maze(new String [] {
				"S###",
				"_###",
				"_F##",
				"####"
		});
		String[] noWallMazeSolution = new String [] {
				"S###",
				"*###",
				"*F##",
				"####"
		};
		this.checkMaze(stackWl, ManyWallMaze, noWallMazeSolution);
		ManyWallMaze = new Maze(new String [] {
				"S###",
				"_###",
				"_F##",
				"####"
		});
		this.checkMaze(queueWl, ManyWallMaze, noWallMazeSolution);
		
		stackWl = new StackWorklist();
		queueWl = new QueueWorklist();
		ManyWallMaze = new Maze(new String [] {
				"#___",
				"#S#_",
				"###F",
				"####"
		});
		noWallMazeSolution = new String [] {
				"#***",
				"#S#*",
				"###F",
				"####"
		};
		this.checkMaze(stackWl, ManyWallMaze, noWallMazeSolution);
		ManyWallMaze = new Maze(new String [] {
				"#___",
				"#S#_",
				"###F",
				"####"
		});
		this.checkMaze(queueWl, ManyWallMaze, noWallMazeSolution);
		
		stackWl = new StackWorklist();
		queueWl = new QueueWorklist();
		ManyWallMaze = new Maze(new String [] {
				"####",
				"#F##",
				"#_##",
				"#_S#"
		});
		noWallMazeSolution = new String [] {
				"####",
				"#F##",
				"#*##",
				"#*S#"
		};
		this.checkMaze(stackWl, ManyWallMaze, noWallMazeSolution);
		ManyWallMaze = new Maze(new String [] {
				"####",
				"#F##",
				"#_##",
				"#_S#"
		});
		this.checkMaze(queueWl, ManyWallMaze, noWallMazeSolution);
	}
	
	@Test
	public void testCloseStartAndFinishMaze() {
		SearchWorklist stackWl = new StackWorklist();
		SearchWorklist queueWl = new QueueWorklist();
		Maze closeStartAndFinishMaze = new Maze(new String [] {
				"__#_",
				"_##_",
				"_SF#",
				"#_##"
		});
		String[] closeStartAndFinishMazeSolution = new String [] {
				"__#_",
				"_##_",
				"_SF#",
				"#_##"
		};
		this.checkMaze(stackWl, closeStartAndFinishMaze, closeStartAndFinishMazeSolution);
		this.checkMaze(queueWl, closeStartAndFinishMaze, closeStartAndFinishMazeSolution);
		
		stackWl = new StackWorklist();
		queueWl = new QueueWorklist();
		closeStartAndFinishMaze = new Maze(new String [] {
				"__#_",
				"_##_",
				"_#_#",
				"SF##"
		});
		closeStartAndFinishMazeSolution = new String [] {
				"__#_",
				"_##_",
				"_#_#",
				"SF##"
		};
		this.checkMaze(stackWl, closeStartAndFinishMaze, closeStartAndFinishMazeSolution);
		this.checkMaze(queueWl, closeStartAndFinishMaze, closeStartAndFinishMazeSolution);
		
		stackWl = new StackWorklist();
		queueWl = new QueueWorklist();
		closeStartAndFinishMaze = new Maze(new String [] {
				"__#_",
				"_#SF",
				"_#_#",
				"__##"
		});
		closeStartAndFinishMazeSolution = new String [] {
				"__#_",
				"_#SF",
				"_#_#",
				"__##"
		};
		this.checkMaze(stackWl, closeStartAndFinishMaze, closeStartAndFinishMazeSolution);
		this.checkMaze(queueWl, closeStartAndFinishMaze, closeStartAndFinishMazeSolution);
	}
	
	@Test
	public void testTwoCornerMaze() {
		SearchWorklist stackWl = new StackWorklist();
		SearchWorklist queueWl = new QueueWorklist();
		Maze twoCornerMaze = new Maze(new String [] {
				"S_#F",
				"____",
				"#_#_",
				"#___"
		});
		String[] twoCornerMazeStackSolution = new String [] {
				"S*#F",
				"_***",
				"#_#_",
				"#___"
		};
		String[] twoCornerMazeQueueSolution = new String [] {
				"S_#F",
				"****",
				"#_#_",
				"#___"
		};
		this.checkMaze(stackWl, twoCornerMaze, twoCornerMazeStackSolution);
		twoCornerMaze = new Maze(new String [] {
				"S_#F",
				"____",
				"#_#_",
				"#___"
		});
		this.checkMaze(queueWl, twoCornerMaze, twoCornerMazeQueueSolution);
		
		stackWl = new StackWorklist();
		queueWl = new QueueWorklist();
		twoCornerMaze = new Maze(new String [] {
				"F_#_",
				"#___",
				"#_#_",
				"#__S"
		});
		twoCornerMazeStackSolution = new String [] {
				"F*#_",
				"#*__",
				"#*#_",
				"#**S"
		};
		twoCornerMazeQueueSolution = new String [] {
				"F*#_",
				"#***",
				"#_#*",
				"#__S"
		};
		this.checkMaze(stackWl, twoCornerMaze, twoCornerMazeStackSolution);
		twoCornerMaze = new Maze(new String [] {
				"F_#_",
				"#___",
				"#_#_",
				"#__S"
		});
		this.checkMaze(queueWl, twoCornerMaze, twoCornerMazeQueueSolution);
		
		stackWl = new StackWorklist();
		queueWl = new QueueWorklist();
		twoCornerMaze = new Maze(new String [] {
				"__#F",
				"#___",
				"#_#_",
				"S___"
		});
		twoCornerMazeStackSolution = new String [] {
				"__#F",
				"#__*",
				"#_#*",
				"S***"
		};
		twoCornerMazeQueueSolution = new String [] {
				"__#F",
				"#***",
				"#*#_",
				"S*__"
		};
		this.checkMaze(stackWl, twoCornerMaze, twoCornerMazeStackSolution);
		twoCornerMaze = new Maze(new String [] {
				"__#F",
				"#___",
				"#_#_",
				"S___"
		});
		this.checkMaze(queueWl, twoCornerMaze, twoCornerMazeQueueSolution);
	}
	
	@Test
	public void testUnsolvableMaze() {
		SearchWorklist stackWl = new StackWorklist();
		SearchWorklist queueWl = new QueueWorklist();
		Maze unsolvableMaze = new Maze(new String [] {
				"S_#F",
				"__##",
				"#_#_",
				"#___"
		});
		String[] noSolution = new String[] {
				"S_#F",
				"__##",
				"#_#_",
				"#___"
		};
		this.checkMaze(stackWl, unsolvableMaze, noSolution);
		this.checkMaze(queueWl, unsolvableMaze, noSolution);
	}
}



