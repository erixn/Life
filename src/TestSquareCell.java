

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSquareCell {

	private Cell deadCell = new SquareCell(Cell.State.Dead);
	private Cell liveCell = new SquareCell(Cell.State.Alive);
	
	
	
	@Test
	public void testNextMoveDeadCell0Alive() {
		SquareCell cell = new SquareCell(Cell.State.Dead);
		
		cell.setNeighbors(deadCell, deadCell, deadCell, deadCell, deadCell, deadCell, deadCell, deadCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
	}

	@Test
	public void testNextMoveDeadCell1Alive() {
		SquareCell cell = new SquareCell(Cell.State.Dead);

		cell.setNeighbors(liveCell, deadCell, deadCell, deadCell, deadCell, deadCell, deadCell, deadCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
	}

	@Test
	public void testNextMoveDeadCell2Alive() {
		SquareCell cell = new SquareCell(Cell.State.Dead);
		
		cell.setNeighbors(liveCell, liveCell, deadCell, deadCell, deadCell, deadCell, deadCell, deadCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
	}

	@Test
	public void testNextMoveDeadCell3Alive() {
		SquareCell cell = new SquareCell(Cell.State.Dead);
		
		// The only time a dead cell will come to life is with 3 live neighbors
		cell.setNeighbors(liveCell, liveCell, liveCell, deadCell, deadCell, deadCell, deadCell, deadCell);
		assertEquals(Cell.State.Alive, cell.calculateNextState());
		assertEquals(Cell.State.Alive, cell.goToNextState());
		assertEquals(true, cell.isAlive());
	}

	@Test
	public void testNextMoveDeadCell4Alive() {
		SquareCell cell = new SquareCell(Cell.State.Dead);
		
		cell.setNeighbors(liveCell, liveCell, liveCell, liveCell, deadCell, deadCell, deadCell, deadCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
		
	}

	@Test
	public void testNextMoveDeadCell5Alive() {
		SquareCell cell = new SquareCell(Cell.State.Dead);
		
		cell.setNeighbors(liveCell, liveCell, liveCell, liveCell, liveCell, deadCell, deadCell, deadCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
	}

	@Test
	public void testNextMoveDeadCell6Alive() {
		SquareCell cell = new SquareCell(Cell.State.Dead);
				
		cell.setNeighbors(liveCell, liveCell, liveCell, liveCell, liveCell, liveCell, deadCell, deadCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
	}

	@Test
	public void testNextMoveDeadCell7Alive() {
		SquareCell cell = new SquareCell(Cell.State.Dead);

		cell.setNeighbors(liveCell, liveCell, liveCell, liveCell, liveCell, liveCell, liveCell, deadCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
	}

	@Test
	public void testNextMoveDeadCell8Alive() {
		SquareCell cell = new SquareCell(Cell.State.Dead);

		cell.setNeighbors(liveCell, liveCell, liveCell, liveCell, liveCell, liveCell, liveCell, liveCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
	}
	
	
	// Now test against a live cell.
	@Test
	public void testNextMoveLiveCell0Alive() {
		SquareCell cell = new SquareCell(Cell.State.Alive);
		
		cell.setNeighbors(deadCell, deadCell, deadCell, deadCell, deadCell, deadCell, deadCell, deadCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
	}

	@Test
	public void testNextMoveLiveCell1Alive() {
		SquareCell cell = new SquareCell(Cell.State.Alive);

		cell.setNeighbors(liveCell, deadCell, deadCell, deadCell, deadCell, deadCell, deadCell, deadCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
	}

	@Test
	public void testNextMoveLiveCell2Alive() {
		SquareCell cell = new SquareCell(Cell.State.Alive);
		
		// Cell with 2 neighbors lives
		cell.setNeighbors(liveCell, liveCell, deadCell, deadCell, deadCell, deadCell, deadCell, deadCell);
		assertEquals(Cell.State.Alive, cell.calculateNextState());
		assertEquals(Cell.State.Alive, cell.goToNextState());
		assertEquals(true, cell.isAlive());
	}

	@Test
	public void testNextMoveLiveCell3Alive() {
		SquareCell cell = new SquareCell(Cell.State.Alive);
		
		// Cell with 3 neighbors lives
		cell.setNeighbors(liveCell, liveCell, liveCell, deadCell, deadCell, deadCell, deadCell, deadCell);
		assertEquals(Cell.State.Alive, cell.calculateNextState());
		assertEquals(Cell.State.Alive, cell.goToNextState());
		assertEquals(true, cell.isAlive());
	}

	@Test
	public void testNextMoveLiveCell4Alive() {
		SquareCell cell = new SquareCell(Cell.State.Alive);
		
		cell.setNeighbors(liveCell, liveCell, liveCell, liveCell, deadCell, deadCell, deadCell, deadCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
		
	}

	@Test
	public void testNextMoveLiveCell5Alive() {
		SquareCell cell = new SquareCell(Cell.State.Alive);
		
		cell.setNeighbors(liveCell, liveCell, liveCell, liveCell, liveCell, deadCell, deadCell, deadCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
	}

	@Test
	public void testNextMoveLiveCell6Alive() {
		SquareCell cell = new SquareCell(Cell.State.Alive);
				
		cell.setNeighbors(liveCell, liveCell, liveCell, liveCell, liveCell, liveCell, deadCell, deadCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
	}

	@Test
	public void testNextMoveLiveCell7Alive() {
		SquareCell cell = new SquareCell(Cell.State.Alive);

		cell.setNeighbors(liveCell, liveCell, liveCell, liveCell, liveCell, liveCell, liveCell, deadCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
	}

	@Test
	public void testNextMoveLiveCell8Alive() {
		SquareCell cell = new SquareCell(Cell.State.Alive);

		cell.setNeighbors(liveCell, liveCell, liveCell, liveCell, liveCell, liveCell, liveCell, liveCell);
		assertEquals(Cell.State.Dead, cell.calculateNextState());
		assertEquals(Cell.State.Dead, cell.goToNextState());
		assertEquals(false, cell.isAlive());
	}
	
	
}
