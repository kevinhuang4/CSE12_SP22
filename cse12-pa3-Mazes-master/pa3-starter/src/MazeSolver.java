/* Class to implement a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		/* Complete this method */

		// add the start square to wl
		wl.add(maze.start);
		// mark the start as visited
		maze.start.visit();
		// while wl is not empty
		while (!wl.isEmpty()) {
			// let current = remove the first element from wl
			Square current = wl.remove();
			Square[] neighbors = null;
			// if current is the finish square
			if (current == maze.finish) {
				// return current
				return current;
			} else {
				// get the neighbors
				neighbors = MazeSolver.getNeighbors(maze, current);
				// for each neighbor
				for (int i = 0; i < 4; i++) {
					// only perform the actions if the neighbor is valid and not visited
					if (neighbors[i] != null && !(neighbors[i].isVisited())) {
						// mark the neighbor as visited
						neighbors[i].visit();
						// set the previous of the neighbor to current
						neighbors[i].setPrevious(current);
						// add the neighbor to the worklist
						wl.add(neighbors[i]);
					}
				}
			}
		}
		return null;
	}

	/* Add any helper methods you want */
	// return an array of the current square's neighbors
	public static Square[] getNeighbors(Maze maze, Square current) {
		// get the row of the current square
		int currentRow = current.getRow();
		// get the col of the current square
		int currentCol = current.getCol();
		// initialize count, the final length of the Square array
		Square[] neighbors = new Square[4];
		// append the valid neighbors and nulls in order
		neighbors[0] = getValidNeighbor(maze, currentRow - 1, currentCol);
		neighbors[1] = getValidNeighbor(maze, currentRow + 1, currentCol);
		neighbors[2] = getValidNeighbor(maze, currentRow, currentCol + 1);
		neighbors[3] = getValidNeighbor(maze, currentRow, currentCol - 1);
		return neighbors;
	}

	public static Square getValidNeighbor(Maze maze, int row, int col) {
		// return false if row or col is out-of-range
		if (row < 0 || row >= maze.contents.length || col < 0 || col >= maze.contents[0].length) {
			return null;
		} else if (maze.contents[row][col].getIsWall()) {
			// return null if it's a wall
			return null;
		}
		return maze.contents[row][col];
	}
}
