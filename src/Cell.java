
import java.util.ArrayList;


/**
 * Interface for common features of a Cell in "The Game of Life".
 * 
 * @author paulerickson
 *
 */
public abstract class Cell {
	
	private ArrayList<Cell> neighbors = new ArrayList<Cell>() ;

	private State state = State.Dead;
	
	private State nextState = State.Dead;
	
	abstract public int getUnderPopulationLimit();
	
	abstract public int getOverCrowdingLimit();
	
	abstract public int getReproductionValue();
	
	public enum State {
		Dead("0"),
		Alive("1");
		
		private String val;
		State(String s) {
			val = s;
		}
		
		public String toString() {
			return val;
		}
	}
	
	public Cell(State initialState) {
		state = initialState;
	}
	
	public void setState(State newState) {
		state = newState;
	}
	
	/**
	 * Check to see the current state of the Cell.
	 * @return true if the Cell is alive.
	 */
	public boolean isAlive() {
		return state == State.Alive;
	}
	
	/**
	 * Figure out what the next state will be (based on number of neighbors),
	 * but don't change the current state of the cell.
	 * @return true if the Cell will be alive on the next turn.
	 */
	public State calculateNextState() {
		nextState = state;
		
		int livingNeighborCount = getLivingNeighborCount();
		
		switch (state) {
		case Dead:
			if (livingNeighborCount == getReproductionValue()) {
				nextState = State.Alive;
			}
			break;
		case Alive:
			if (livingNeighborCount < getUnderPopulationLimit()) {
				nextState = State.Dead;
			}
			else if (livingNeighborCount > getOverCrowdingLimit()) {
				nextState = State.Dead;
			}
		}
		
		return nextState;
		
	};
	
	/**
	 * After all of the cells have their next state figured out, this will make the 
	 * change on the Cell to reflect the next state (next turn). 
	 * @return The new state of the Cell.
	 */
	 public State goToNextState() {
		 state = nextState;
		 return state;
	 }
	
	/** 
	 * @return The number of neighbor Cells which are currently alive.
	 */ 
	 public int getLivingNeighborCount() {
		 int count = 0;
		 for (Cell neighbor : neighbors) {
			 if (neighbor.isAlive() ) {
				 count ++;
			 }
		 }
		 return count;
	 }
	 
	 public void addNeighbor(Cell newNeighbor) {
		 if (newNeighbor != null) {
			 neighbors.add(newNeighbor);
		 }
	 }
}
