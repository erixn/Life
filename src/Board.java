import java.util.Formatter;


public class Board {

	private int width;
	private int height;
	
	private SquareCell grid[][];
	
	public Board(int width, int height)
	{
		this.width = width;
		this.height = height;
		grid = new SquareCell[width][height];
		
		// Create all of the cells.
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				SquareCell cell = new SquareCell(Cell.State.Dead);
				grid[x][y] = cell;
			}
		}

		// Hate to loop through again, but neighbors need to be set up after the
		// array has values.
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				SquareCell cell = grid[x][y];
				
				// Set all of the neighboring cell values:
				cell.setNeighbors(getNorthNeighbor(x, y),
						getNorthEastNeighbor(x, y),
						getEastNeighbor(x, y),
						getSouthEastNeighbor(x, y),
						getSouthNeighbor(x, y),
						getSouthWestNeighbor(x, y),
						getWestNeighbor(x, y),
						getNorthWestNeighbor(x, y));
			}
		}
	}
	
	public void initializeCell(int x, int y, Cell.State state) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			printOutOfBoundsMessage(x,y);
			return;
		}
		
		SquareCell cell = grid[x][y];
		cell.setState(state);
		
		// Set all of the neighboring cell values:
		cell.setNeighbors(getNorthNeighbor(x, y),
				getNorthEastNeighbor(x, y),
				getEastNeighbor(x, y),
				getSouthEastNeighbor(x, y),
				getSouthNeighbor(x, y),
				getSouthWestNeighbor(x, y),
				getWestNeighbor(x, y),
				getNorthWestNeighbor(x, y));
	}
		
	public SquareCell getNorthNeighbor(int x, int y) {
		if (y > 0) {
			return grid[x][y-1];
		}
		return null;
	}
	
	public SquareCell getNorthEastNeighbor(int x, int y) {
		if (x < width-1 && y > 0) {
			return grid[x+1][y-1];
		}
		return null;
	}

	public SquareCell getEastNeighbor(int x, int y) {
		if (x < width-1) {
			return grid[x+1][y];
		}
		return null;
	}

	public SquareCell getSouthEastNeighbor(int x, int y) {
		if (x < width-1 && y < height-1) {
			return grid[x+1][y+1];
		}
		return null;
	}

	public SquareCell getSouthNeighbor(int x, int y) {
		if (y < height-1) {
			return grid[x][y+1];
		}
		return null;
	}

	public SquareCell getSouthWestNeighbor(int x, int y) {
		if (x > 0 && y < height-1) {
			return grid[x-1][y+1];
		}
		return null;
	}

	public SquareCell getWestNeighbor(int x, int y) {
		if (x > 0) {
			return grid[x-1][y];
		}
		return null;
	}

	public SquareCell getNorthWestNeighbor(int x, int y) {
		if (x > 0 && y > 0) {
			return grid[x-1][y-1];
		}
		return null;
	}
	
	
	public void setCellState(int x, int y, Cell.State newState) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			printOutOfBoundsMessage(x,y);
			return;
		}
		grid[x][y].setState(newState);
	}

	public void move() {
		// First calculate the new states based on current values.
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				SquareCell cell = grid[x][y];
				
				cell.calculateNextState();
			}
		}
		
		// Now flip all of the cells to their new values.
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				SquareCell cell = grid[x][y];
				
				cell.goToNextState();
			}
		}

	}
	
	public void printOutOfBoundsMessage(int x, int y) {
		
		Formatter formatter = new Formatter();
		formatter.format("Coordinates %1,%2 are not within the boundaries of %3,%4", x, y, width, height);
		System.out.println(formatter.toString());
		formatter.close();
		return;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				SquareCell cell = grid[x][y];
				
				if (cell.isAlive()) {
					sb.append("1 ");
				}
				else {
					sb.append("0 ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
