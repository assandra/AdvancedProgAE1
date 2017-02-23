import java.util.*;


/*
* Class which creates the 2d grid
* of cell objects, which species can inhabit
*/
public class Grid {

	/** Class Constants */
	private static final int NUM_SPECIES = 2; 

	/** Instance Variables */
	private int rows;
	private int columns;
	public Cell [][] grid;
	private int worldType;

	/** Constructor */
	public Grid(int rows, int columns, int worldType) {
		this.rows = rows;
		this.columns = columns;
		this.worldType = worldType;
		grid = new Cell[rows][columns];
		
	}

	/** Accesor Methods */
	public Cell [][] getGrid() {
		return grid;
	}

	/*
	* Instantiates every Cell object in the 2d Cell array, and randomly places either a species 1
	* or a species 2 and starts their thread. It can also choose to leave a cell
	* empty.
	*/
	public void initialStart() {

		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++) {

				int random = new Random().nextInt(3);

				//Leaves the cell empty
				if (random==0) {
					grid[i][j] = new Cell(i,j);
				}

				//Places a Species1 in the cell
				else if (random==1) {
					Species1 s1 = new Species1(i,j,grid, worldType);
					grid[i][j]  = new Cell(i,j,s1);
					Thread t = new Thread(s1);
					t.start();
				}

				//Places a Species2 in the cell
				else if (random == 2) {
					Species2 s2 = new Species2(i,j,grid, worldType);
					grid[i][j] = new Cell(i, j, s2);
					Thread t= new Thread(s2);
					t.start();

				}	
			}
		}
	}


	/**
	*	Method to print out the state of the world
	*/
	public String toString() {
		String [] stringArray = new String [rows];
		String line = "";
		for (int i = 0; i < grid.length; i++) {
      		for (int j = 0; j < grid[i].length; j++) {
      			String value ="";

      			//Case where the cell is not occupied
      			if (grid[i][j].getOccupation() == false){
      				value = "-";
      			}

      			//Case where the cell is occupied
      			else if (grid[i][j].getOccupation() == true) {
      			 	value = "" +grid[i][j].getSpecies().identifier();
      			}

      			line +=" " +value;          
      		
            }
            
            stringArray[i] = line;
            line = "";
        }

        for (int i=0; i<stringArray.length; i++) {
        	System.out.println(stringArray[i]);
        }

        System.out.println("-----------");

        return line;
	}

	/**
	*  Counts the world's population
	*  @return count - world's total population
	*/
	public int getWorldPopulation() {
		int count =0;
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[0].length; j++) {
				if (grid[i][j].getOccupation() == true) {
					count++;
				}
			}
		}
		return count;
	}
}