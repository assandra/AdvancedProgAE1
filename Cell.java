/**
*  A cell is a location on the 2d world grid, which a 
*  species can occupy
*/
public class Cell {
	
	private boolean isOccupied;
	private int x;
	private int y;
	private Creature species;

	/** Constructor for unoccupied cell*/
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		isOccupied = false;
	}

	/** Constructor for occupied cell*/
	public Cell(int x, int y, Creature species) {
		this.x=x;
		this.y=y;
		this.species = species;
		isOccupied = true;
	}

	/** Accesor Methods */
	public boolean getOccupation() {
		return isOccupied;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Creature getSpecies() {
		return species;
	}
	

	/** Mutator Methods*/
	public void setOccupied(boolean isOccupied) {
		this.isOccupied =  isOccupied;
	}

	public void setSpecies(Creature species) {
		this.species = species;
	}
}