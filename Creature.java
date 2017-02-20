import java.util.*;
public class Creature {
	protected double lifeSpan;
	protected double maxLifeSpan;
	protected double fitnessLevel;
	
	protected boolean isAlive;
	protected int x;
	protected int y;
	protected Grid world;
	public Cell [][] grid;

	

	//Default constructor
	//CONSIDER LEAVING BLANK, SO JAVA INSERTS DEFAULT VALUES, GOOD DESIGN?
	public Creature(int x, int y, Cell [][] grid) {
		this.x = x;
		this.y = y;
		this.world = world;
		this.grid = grid;		

	}


		//Accessor Methods
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



	//Mutator methods
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}


	protected void setLifeSpan(double lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	protected void setMaxLifeSpan(double maxLifeSpan) {
		this.maxLifeSpan = maxLifeSpan;
	}

	protected void setFitnessLevel(double fitnessLevel) {
		this.fitnessLevel= fitnessLevel;
	}





	public int identifier() {
		return 0;
	}

	public Cell [] getNeighbours() {

		Cell [] neighbours = new Cell [8];
		

			//conditions for neighbour x-1,y-1
			if ((x-1>=0) && (y-1>=0)){
				neighbours[0] = grid[x-1][y-1];
			//	System.out.println("1 My location is" +(x-1) +" "+(y-1));
			}
			else if ((x-1<0) && (y-1>=0)){
				neighbours[0] = grid[x-1+grid.length][y-1];
			//	System.out.println("1 My location is" +(x-1+grid[0].length) +" "+(y-1));
			}
			else if ((x-1>=0) && (y-1<0)) {
				neighbours[0] = grid[x-1][y-1+grid[0].length];
			//	System.out.println("1 My location is" +(x-1) +" "+(y-1+grid.length));
			}
			else if ((x-1<0) && (y-1<0)) {
				neighbours[0] = grid[x-1+grid.length][y-1+grid[0].length];
				//System.out.println("1 My location is" +(x-1+grid[0].length) +" "+(y-1+grid.length));
			}
		

			//conditions for neighbour x-1, y
			if (x-1>=0){
				neighbours[1] = grid[x-1][y];
				//System.out.println("2 My location is" +(x-1) +" "+(y));

			}
			else if (x-1<0) {
				neighbours[1] = grid[x-1+grid.length][y];
				//System.out.println("2 My location is" +(x-1+grid[0].length) +" "+(y));
			}

			//conditions for neighbour x-1, y+1
			if ((x-1>=0) && (y+1<grid[0].length)) {
				neighbours[2] = grid[x-1][y+1];
				//System.out.println("3 My location is" +(x-1) +" "+(y+1));
			}
			else if ((x-1<0) && (y+1<grid[0].length)) {
				neighbours[2] = grid[x-1+grid.length][y+1];
				//System.out.println("3 My location is" +(x-1+grid[0].length) +" "+(y+1));
			}
			else if ((x-1>=0) && (y+1>=grid[0].length)) {
				neighbours[2] = grid[x-1][y+1-grid[0].length];
				//System.out.println(" 3 My location is" +(x-1) +" "+(y+1-grid.length));
			}
			else if ((x-1<0) && (y+1>=grid[0].length)) {
				neighbours[2] = grid[x-1+grid.length][y+1-grid[0].length];
				//System.out.println("3 My location is" +(x-1+grid[0].length) +" "+(y+1-grid[0].length));
			} 


			//conditins for x, y-1
			if (y-1>=0) {
				neighbours[3] = grid[x][y-1];
				//System.out.println("4 My location is" +(x) +" "+(y-1));

			}
			else if (y-1<0) {
				neighbours[3] = grid[x][y-1+grid[0].length];
				//System.out.println("4 My location is" +(x) +" "+(y-1+grid.length));

			}

			//conditions for x, y+1

			if (y+1<grid[0].length) {
				neighbours[4] = grid[x][y+1];
				//System.out.println("5 My location is" +(x) +" "+(y+1));
			}
			else if (y+1>=grid.length) {
				neighbours[4] = grid[x][y+1-grid[0].length];
				//System.out.println("5 My location is" +(x) +" "+(y+1-grid.length));
			}

			//conditions for x+1, y-1
			if ((x+1<grid.length) && (y-1>=0)) {
				neighbours[5]= grid[x+1][y-1];
				//System.out.println("6 My location is" +(x+1) +" "+(y-1));
			}
			else if ((x+1>=grid.length) && (y-1 >=0)) {
				neighbours[5] = grid[x+1-grid.length][y-1];
				//System.out.println("6 My location is" +(x+1-grid[0].length) +" "+(y-1));
			}
			else if ((x+1<grid.length) && (y-1<0)) {
				neighbours[5] = grid[x+1][y-1+grid[0].length];
				//System.out.println("6 My location is" +(x+1) +" "+(y-1+grid.length));
			}
			else if ((x+1>=grid.length) && (y-1<0)) {
				neighbours[5] = grid[x+1-grid.length][y-1+grid[0].length];
				//System.out.println("6 My location is" +(x+1-grid[0].length) +" "+(y-1+grid.length));
			}

			//condition for x+1, y
			if (x+1<grid.length) {
				neighbours[6] = grid[x+1][y];
				//System.out.println("7  My location is" +(x+1) +" "+(y));
			}
			else if (x+1>=grid.length) {
				neighbours[6] = grid[x+1-grid.length][y];
				//System.out.println("7  My location is" +(x+1-grid[0].length) +" "+(y));
			}


			//condition for x+1, y+1
			if ((x+1<grid.length ) && (y+1<grid[0].length)) {
				neighbours[7] = grid[x+1][y+1];
				//System.out.println("8  My location is" +(x+1) +" "+(y+1));
			}
			else if ((x+1>=grid.length) && (y+1<grid[0].length)) {
				neighbours[7]= grid[x+1-grid.length][y+1];
				//System.out.println("8  My location is" +(x+1-grid[0].length) +" "+(y+1)); 
			}
			else if ((x+1<grid.length) && (y+1>=grid[0].length)) {
				neighbours[7] = grid[x+1][y+1-grid[0].length];
				//System.out.println("8   My location is" +(x+1) +" "+(y+1-grid.length));
			}
			else if ((x+1>=grid.length) && (y+1>=grid[0].length)) {
				neighbours[7] = grid[x+1-grid.length][y+1-grid[0].length];
				//System.out.println("8  My location is" +(x+1-grid[0].length) +" "+(y+1-grid.length));
			}

			return neighbours;
		
		}


	public Cell [] getNeighboursW1() {
		Cell [] neighbours = new Cell [8];
		if (((x-1) >= 0) && ((y-1) >=0)) {
			neighbours[0] = grid[x-1][y-1];
		}
		if ((x-1) >=0) {
			neighbours[1] = grid[x-1][y];
		}
		if (((x-1) >= 0) && ((y+1) < grid[0].length)) {
			neighbours[2] = grid[x-1][y+1];
		}
		if ((y-1) >=0) {
			neighbours[3] =grid[x][y-1];
		}
		if ((y+1)< grid[0].length) {
			neighbours[4] = grid[x][y+1];
		}
		if (((x+1) <grid.length) && ((y-1)>= 0)) {
			neighbours[5] = grid[x+1][y-1];
		}
		if ((x+1) < grid.length) {
			neighbours[6] = grid[x+1][y];
		}
		if (((x+1) < grid[0].length) && ((y+1) < grid[0].length)){
			neighbours[7] = grid[x+1][y];
		}

		int count =0;
		for (int i=0; i<8; i++ ) {
			if (neighbours[i] == null) {
				
				System.out.println("I dont exist");
			}
			else if (neighbours[i] != null) {
				count++;

				System.out.println("I do exist");
			}
		}
		System.out.println(count);
		Cell [] actualNeighbours = new Cell [count];
		int j=0;
		for (int i=0; i<8; i++ ) {
			if (neighbours[i]!=null) {
				actualNeighbours[j++] = neighbours[i];
				
		}
	}

		return actualNeighbours;
}


	
	
	}




