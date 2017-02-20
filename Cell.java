public class Cell {
	
	public boolean isOccupied;
	public int x;
	public int y;
	public Creature species;

	/** Constructor for unoccupied cell*/
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		isOccupied = false;

	}
	public Cell(int x, int y, Creature species) {
		this.x=x;
		this.y=y;
		this.species = species;
		isOccupied = true;
	}

	public boolean getOccupation() {
		return isOccupied;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setOccupied(boolean isOccupied) {
		this.isOccupied =  isOccupied;
	}

	public Creature getSpecies() {
		return species;
	}

	public void setSpecies(Creature species) {
		this.species = species;
	}
}