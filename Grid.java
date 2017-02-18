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
	public Creature [][] grid;
	public Thread [][] myThreads; 
	


	/** Constructor */
	public Grid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		grid = new Creature[rows][columns];
		//myThreads = new Thread[rows][columns];
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
					grid[i][j] = null;
			}
				else if (random==1) {
				Species1 s1 = new Species1(i,j);

				grid[i][j]  = s1;

				Thread t = new Thread(s1);
				t.start();
			}
			else if (random == 2) {
					Species2 s2 = new Species2(i,j);
					grid[i][j] = s2;
					
					Thread t= new Thread(s2);
					t.start();

				}
				
			
				
				
				
			}
		}

	}



	public String toString() {
		String [] stringArray = new String [rows];

		//for (int i=0; i<stringArray.length; i++) {
		//	stringArray[i] = "0";
		//}
		String line = "";
		for (int i = 0; i < grid.length; i++) {
      		for (int j = 0; j < grid[i].length; j++) {
      			String value ="";
      			if (grid[i][j] == null){
      				value = "-";
      			}

      			else if (grid[i][j]!= null) {
      			 value = "" +grid[i][j].identifier();
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


}