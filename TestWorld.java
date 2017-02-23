import java.util.*;

public class TestWorld {
	public static void main(String[] args) {

		/** WorldTypes:
		* worldType = 1:
		* The edges of the grid are the edges of the world
		*
		* worldType = 2:
		* The edges of grid wrap around
		*/
		int worldType = 2;
		int rRows = 10;
		int cCols = 10;


		Grid world = new Grid(rRows,cCols, worldType);


		world.initialStart();
		Cell [][] grid = world.getGrid();

		//Outputs the state and population of the world every 0.5 seconds
		try {
    		while (true) {
        		world.toString();
        		System.out.println("The world population is: " +world.getWorldPopulation());
    			Thread.sleep(500);  // every 0.5 seconds
  	  		}
 		} 
 		catch (InterruptedException e) {
  			e.printStackTrace();
   		}
	}
}