import java.util.*;

public class TestWorld {
	public static void main(String[] args) {

		/** Set up of the initial world
		*	CONSIDER MAKING IT OWN METHOD
		 */
		int rRows = 10;
		int cCols = 10;
		Grid world = new Grid(rRows,cCols);

		Cell [][] grid = world.getGrid();


		world.placeRandomThread();

		grid[0][0].getSpecies().getNeighboursW1();
		//System.out.println(grid[0].length);
		//System.out.println(grid.length);
		//world.toString();

		/*try {
      	while (true) {
        	world.toString();

        	System.out.println(world.getWorldPopulation());
        	//System.out.println(grid[0][0].getOccupation());
        //	System.out.println(grid[0][1].getOccupation());
        //	System.out.println(grid[0][2].getOccupation());
        //	System.out.println(grid[0][3].getOccupation());
        //	System.out.println(grid[0][4].getOccupation());
        	Thread.sleep(500); // every 0.5 seconds
     }
    } 
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  */




		
		
		//System.out.println(sp1.getMaxLifeSpan());
		//System.out.println(sp1.getLifeSpan());
	
		//System.out.println(sp1.addMaxLifeSpan);

		//System.out.println("second " +sp1.findLifeSpan());
		/*
		//Size of matrix
		int rRows = 4;
		int cCols = 4;
		int numThreads = rRows*cCols;

		//Create 2d matrix of world
		Thread [] [] world = new Thread [rRows][cCols];

		for (int i=0; i<rRows; i++) {
			for (int j=0; j<cCols; j++) {
				CreatureRunnable c1 = new CreatureRunnable(i,j);
				world[i][j]= new Thread(c1);
				//System.out.println(world[i][j] +" ");
				
				
			}
			//System.out.println();
		}
		

*/

	}
}