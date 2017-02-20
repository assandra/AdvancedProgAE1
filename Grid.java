import java.util.*;


/*
* Class which creates the 2d grid for the species to inhabit
*/
public class Grid {

	/** Class Constants */
	private static final int NUM_SPECIES = 2; 

	/** Instance Variables */
	public int rows;
	public int columns;
	public Cell [][] grid;
	 
	


	/** Constructor */
	public Grid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		grid = new Cell[rows][columns];
		
	}

	public Cell [][] getGrid() {
		return grid;
	}

	

	/*
	* Goes through every cell in grid and randomly places either a species 1
	* or a species 2 and starts their thread. It can also choose to leave a cell
	* empty.
	*/
	public void placeRandomThread() {

		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++) {

				int random = new Random().nextInt(3);

				if (random==0) {
					
					grid[i][j] = new Cell(i,j);
				}
				else if (random==1) {
					Species1 s1 = new Species1(i,j,grid);
				
					grid[i][j]  =new Cell(i,j,s1);
					Thread t = new Thread(s1);
					t.start();
				}
				else if (random == 2) {
					Species2 s2 = new Species2(i,j,grid);
				
					grid[i][j] = new Cell(i, j, s2);
					Thread t= new Thread(s2);
					t.start();

				}	
			}
		}

	}



	public String toString() {
		String [] stringArray = new String [rows];
		String line = "";
		for (int i = 0; i < grid.length; i++) {
      		for (int j = 0; j < grid[i].length; j++) {
      			String value ="";
      			if (grid[i][j].getOccupation() == false){
      				value = "-";
      			}

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
        System.out.println("--------");
        return line;
	}
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