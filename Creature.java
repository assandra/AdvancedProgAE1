import java.util.*;
public class Creature {

	/** Class Constants */
	private static final int MAX_NEIGHBOURS = 8; 


	/** Instance Variables */
	protected double lifeSpan;
	protected double maxLifeSpan;
	protected double fitnessLevel;
	protected int worldType;
	
	protected boolean isAlive;
	protected int x;
	protected int y;
	protected Grid world;
	public Cell [][] grid;
	
	/** Constructor */
	public Creature(int x, int y, Cell [][] grid, int worldType) {
		this.x = x;
		this.y = y;
		this.worldType = worldType;
		this.world = world;
		this.grid = grid;		

	}


	/** Accessor Methods */
	public double getLifeSpan() {
		return lifeSpan;
	}

	public double getMaxLifeSpan() {
		return maxLifeSpan;
	}

	public double getFitnessLevel() {
		return fitnessLevel;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public int getWorldType() {
		return worldType;
	}

	public boolean getIsAlive() {
		return isAlive;
	}


	/** Mutator methods */
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public void setLifeSpan(double lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public void setMaxLifeSpan(double maxLifeSpan) {
		this.maxLifeSpan = maxLifeSpan;
	}

	public void setFitnessLevel(double fitnessLevel) {
		this.fitnessLevel= fitnessLevel;
	}

	/** 
	*	Calculates the lifeSpan of a species, using their
	*   maxLifeSpan
	*   @return lifeSpan - lifeSpan of the species
	*/
 	public double findLifeSpan() {
	
 		double lifeSpan = Math.random() * this.getMaxLifeSpan();
  		this.setLifeSpan(lifeSpan);
 		return lifeSpan;
    }

    /** 
    *	Identifies which species it is. 
    *   1=Species1, 2=Species2
    *   @return species number
     */
	public int identifier() {
		return 0;
	}

	/** 
	*	This finds all the neighbour Cells of a creature 
	*   and places them into an array.
	*   This uses the world with egdes, so creatures at
	*   the egde of the world will have less neighbours than 
	*   creatures near the center. 
	*   @return actualNeighbours - Cell array of all neighbouring cells
	*/
	public Cell [] getNeighboursW1() {

		Cell [] neighbours = new Cell [MAX_NEIGHBOURS];

		/**Condition for finding the neighbour 
		* in the position (x-1,y-1) relative the species
		* position
		*/
		if (((x-1) >= 0) && ((y-1) >=0)) {
			neighbours[0] = grid[x-1][y-1];
		}

		/**Condition for finding the neighbour 
		* in the position (x-1,y) relative the species
		* position
		*/
		if ((x-1) >=0) {
			neighbours[1] = grid[x-1][y];
		}

		/**Condition for finding the neighbour 
		* in the position (x-1,y+1) relative the species
		* position
		*/
		if (((x-1) >= 0) && ((y+1) < grid[0].length)) {
			neighbours[2] = grid[x-1][y+1];
		}

		/**Conditions for finding the neighbour 
		* in the position (x,y-1) relative the species
		* position
		*/
		if ((y-1) >=0) {
			neighbours[3] =grid[x][y-1];
		}

		/**Conditions for finding the neighbour 
		* in the position (x,y+1) relative the species
		* position
		*/
		if ((y+1)< grid[0].length) {
			neighbours[4] = grid[x][y+1];
		}

		/**Conditions for finding the neighbour 
		* in the position (x+1,y-1) relative the species
		* position
		*/
		if (((x+1) <grid.length) && ((y-1)>= 0)) {
			neighbours[5] = grid[x+1][y-1];
		}

		/**Conditions for finding the neighbour 
		* in the position (x+1,y) relative the species
		* position
		*/
		if ((x+1) < grid.length) {
			neighbours[6] = grid[x+1][y];
		}

		/**Conditions for finding the neighbour 
		* in the position (x+1,y+1) relative the species
		* position
		*/
		if (((x+1) < grid[0].length) && ((y+1) < grid[0].length)){
			neighbours[7] = grid[x+1][y];
		}

		//Counts how many neighbours the creature has
		int count =0;
		for (int i=0; i<8; i++ ) {
			if (neighbours[i] != null) {
				count++;
			}
		}
		
		//Create Cell array with the creatures neighbours
		Cell [] actualNeighbours = new Cell [count];
		int j=0;
		for (int i=0; i<8; i++ ) {
			if (neighbours[i]!=null) {
				actualNeighbours[j++] = neighbours[i];	
			}
		}

		return actualNeighbours;
	}

	/** 
	*	This finds all the neighbour Cells of a creature 
	*   and places them into an array.
	*   This uses the wrap around world, so the creature 
	*   will always have 8 neighbours cells.
	*   @return neighbours - Cell array of all neighbouring cells 
	*/
	public Cell [] getNeighboursW2() {

		Cell [] neighbours = new Cell [MAX_NEIGHBOURS];

		/**Conditions for finding the neighbour 
		* in the position (x-1,y-1) relative the species
		* position
		*/
		if ((x-1>=0) && (y-1>=0)){
			neighbours[0] = grid[x-1][y-1];
		}
		else if ((x-1<0) && (y-1>=0)){
			neighbours[0] = grid[x-1+grid.length][y-1];
		}
		else if ((x-1>=0) && (y-1<0)) {
			neighbours[0] = grid[x-1][y-1+grid[0].length];
		}
		else if ((x-1<0) && (y-1<0)) {
			neighbours[0] = grid[x-1+grid.length][y-1+grid[0].length];
		}
		
		/**Conditions for finding the neighbour 
		* in the position (x-1,y) relative the species
		* position
		*/
		if (x-1>=0){
			neighbours[1] = grid[x-1][y];
		}
		else if (x-1<0) {
			neighbours[1] = grid[x-1+grid.length][y];
		}

		/**Conditions for finding the neighbour 
		* in the position (x-1,y+1) relative the species
		* position
		*/
		if ((x-1>=0) && (y+1<grid[0].length)) {
			neighbours[2] = grid[x-1][y+1];
		}
		else if ((x-1<0) && (y+1<grid[0].length)) {
			neighbours[2] = grid[x-1+grid.length][y+1];
		}
		else if ((x-1>=0) && (y+1>=grid[0].length)) {
			neighbours[2] = grid[x-1][y+1-grid[0].length];
		}
		else if ((x-1<0) && (y+1>=grid[0].length)) {
			neighbours[2] = grid[x-1+grid.length][y+1-grid[0].length];
		} 

		/**Conditions for finding the neighbour 
		* in the position (x,y-1) relative the species
		* position
		*/
		if (y-1>=0) {
			neighbours[3] = grid[x][y-1];
		}
		else if (y-1<0) {
			neighbours[3] = grid[x][y-1+grid[0].length];
		}

		/**Conditions for finding the neighbour 
		* in the position (x,y+1) relative the species
		* position
		*/
		if (y+1<grid[0].length) {
			neighbours[4] = grid[x][y+1];
		}
		else if (y+1>=grid.length) {
			neighbours[4] = grid[x][y+1-grid[0].length];
		}

		/**Conditions for finding the neighbour 
		* in the position (x+1,y-1) relative the species
		* position
		*/
		if ((x+1<grid.length) && (y-1>=0)) {
			neighbours[5]= grid[x+1][y-1];
		}
		else if ((x+1>=grid.length) && (y-1 >=0)) {
			neighbours[5] = grid[x+1-grid.length][y-1];
		}
		else if ((x+1<grid.length) && (y-1<0)) {
			neighbours[5] = grid[x+1][y-1+grid[0].length];
		}
		else if ((x+1>=grid.length) && (y-1<0)) {
			neighbours[5] = grid[x+1-grid.length][y-1+grid[0].length];
		}

		/**Conditions for finding the neighbour 
		* in the position (x+1,y) relative the species
		* position
		*/
		if (x+1<grid.length) {
			neighbours[6] = grid[x+1][y];
		}
		else if (x+1>=grid.length) {
			neighbours[6] = grid[x+1-grid.length][y];
		}

		/**Conditions for finding the neighbour 
		* in the position (x+1,y+1) relative the species
		* position
		*/
		if ((x+1<grid.length ) && (y+1<grid[0].length)) {
			neighbours[7] = grid[x+1][y+1];
		}
		else if ((x+1>=grid.length) && (y+1<grid[0].length)) {
			neighbours[7]= grid[x+1-grid.length][y+1]; 
		}
		else if ((x+1<grid.length) && (y+1>=grid[0].length)) {
			neighbours[7] = grid[x+1][y+1-grid[0].length];
		}
		else if ((x+1>=grid.length) && (y+1>=grid[0].length)) {
			neighbours[7] = grid[x+1-grid.length][y+1-grid[0].length];
		}

		return neighbours;
		
	}

}
