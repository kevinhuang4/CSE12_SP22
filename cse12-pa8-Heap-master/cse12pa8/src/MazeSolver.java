/**
 * MazeSolver.java is a Maze solver that takes into account the cost attribute for each square.
 * It finds the shortest path of the maze using Dijkstra’s Algorithm.
 */

// import java.util.ArrayList;

public abstract class MazeSolver {
	/**
	 * Solves the given maze using a priority queue
	 * @param maze the given maze
	 * @param pq the given priority queue
	 * @return the current/ finish square after finding the path, null if it's unsolvable
	 */
	public static Square solve(Maze maze, PriorityQueue<Integer,Square> pq) {
		pq.add(maze.start.getCost(), maze.start);
		while (!pq.isEmpty()) {
			Entry<Integer,Square> current = pq.poll();
			Square currentSquare = current.value;
			currentSquare.visit();
			if (currentSquare.equals(maze.finish)) {
				return currentSquare;
			}
			Square[] neighbors = MazeSolver.getNeighbors(maze, currentSquare);
			for (int i = 0; i < 4; i++) {
				if (neighbors[i] != null) {
					int currentCost = current.key + neighbors[i].getCost();
					if (currentCost < neighbors[i].getRunningCost()) {
						neighbors[i].setPrevious(currentSquare);
						neighbors[i].setRunningCost(currentCost);
						pq.add(currentCost, neighbors[i]);
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns the 4 neighbors of the current square in the maze (NSEW)
	 * @param maze the given maze
	 * @param current the current square
	 * @return the 4 neighbors of the current square in the maze
	 */
	public static Square[] getNeighbors(Maze maze, Square current) {
		int currentRow = current.getRow();
		int currentCol = current.getCol();
		Square[] neighbors = new Square[4];
		neighbors[0] = getValidSquare(maze, currentRow - 1, currentCol);
		neighbors[1] = getValidSquare(maze, currentRow + 1, currentCol);
		neighbors[2] = getValidSquare(maze, currentRow, currentCol + 1);
		neighbors[3] = getValidSquare(maze, currentRow, currentCol - 1);
		return neighbors;
	}

	/**
	 * Returns the square with the given row and col in the maze if it's not a wall
	 * @param maze the given maze
	 * @param row the row of the square
	 * @param col the column of the square
	 * @return the square at the given position if it's not a wall, else null
	 */
	public static Square getValidSquare(Maze maze, int row, int col) {
		if (row < 0 || row >= maze.contents.length || col < 0 || col >= maze.contents[0].length) {
			return null;
		} else if (maze.contents[row][col].getIsWall()) {
			return null;
		}
		return maze.contents[row][col];
	}
}
	
