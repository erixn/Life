



public class SquareCell extends Cell {

	public SquareCell() {
		super(Cell.State.Dead);
	}
	
	public SquareCell(State initialState) {
		super(initialState);
	}
	
	public void setNeighbors(Cell north, Cell northEast, Cell east, Cell southEast, Cell south, Cell southWest, Cell west, Cell northWest) {
		addNeighbor(north);
		addNeighbor(northEast);
		addNeighbor(east);
		addNeighbor(southEast);
		addNeighbor(south);
		addNeighbor(southWest);
		addNeighbor(west);
		addNeighbor(northWest);
	}
	
	@Override
	public int getUnderPopulationLimit() {
		return 2;
	}

	@Override
	public int getOverCrowdingLimit() {
		return 3;
	}

	@Override
	public int getReproductionValue() {
		return 3;
	}

}
