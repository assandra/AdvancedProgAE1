import java.util.*;

public class Species1 extends Creature implements Runnable {

	/** Constructor */
	public Species1(int x, int y, Cell [][] grid, int worldType) {
		super(x,y, grid, worldType);
		setMaxLifeSpan(10);
		setFitnessLevel(0.8);
		findLifeSpan();
		setIsAlive(true);	
	}

	/** Identifier for Species1 */
	public int identifier() {
		return 1;
	}

	/** Run method  for Species1 */
	public void run() {
		try{
			long sleep = (long)this.getLifeSpan() * 1000;
			Thread.sleep(sleep);
			if (isAlive == true) {
				if (this.getWorldType()==1) {
					Cell [] neighbours1 = this.getNeighboursW1();
					this.reproduce(neighbours1);
				}
				else if (this.getWorldType() ==2) {
					Cell [] neighbours2 = this.getNeighboursW2();
					this.reproduce(neighbours2);
				}
				
				//Makes the current cell unoccupied		
				grid[x][y] = new Cell(x,y);
				//Terminates the thread
				Thread.currentThread().interrupt();
				
			}

			else if (isAlive == false) { 
				//Terminate the thread
				Thread.currentThread().interrupt();
			}
		}
			catch (InterruptedException e){
				
			}
	}
           
// 	public void reproduceOBsul() {
// 		try{	
// 			if (((x-1) >= 0) && ((y-1) >=0)){

// 				if (grid[x-1][y-1].getOccupation() == false) {
// //					if (Math.random() <= 0) {
// 					Species1 newspecies = new Species1(x-1, y-1, grid, worldType);

// 					//could redo, and just set the sepcies of the cell and the set occupation to be true
// 					grid[x-1][y-1] = new Cell (x-1,y-1,newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();
// //}
// 				}

// 				else if (grid[x-1][y-1].getOccupation() == true) {
					
// 					//System.out.println(this.getFitnessLevel() - grid[x-1][y-1].getSpecies().getFitnessLevel());
// 					if ( Math.random()	<=	this.getFitnessLevel() - grid[x-1][y-1].getSpecies().getFitnessLevel())
// 					{
// 					Species1 newspecies = new Species1(x-1, y-1, grid, worldType);
// 					grid[x-1][y-1].getSpecies().setIsAlive(false);
// 					grid[x-1][y-1] = new Cell(x-1,y-1, newspecies);
// 					//System.out.println("1 ---I was killed at location" + (x-1) + (y-1));
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}



// 			}
		

// 			if ((x-1) >=0) {

// 				if (grid[x-1][y].getOccupation() == false) { 
// 			//		if (Math.random() <= 0) {
// 					Species1 newspecies = new Species1(x-1, y, grid, worldType);
// 					//System.out.println("THis happened instead 1");

// 					Thread t = new Thread(newspecies);
// 					grid[x-1][y] = new Cell(x-1,y,newspecies);
// 					t.start();
// //}
// 				}
// 				else if (grid[x-1][y].getOccupation() == true) {
// 					//System.out.println(this.getFitnessLevel() - grid[x-1][y].getSpecies().getFitnessLevel());
// 				if ( Math.random()	<=	this.getFitnessLevel() - grid[x-1][y].getSpecies().getFitnessLevel())
// 					 {
// 					Species1 newspecies = new Species1(x-1, y,grid, worldType);
// 					grid[x-1][y].getSpecies().setIsAlive(false);
// 					grid[x-1][y] = new Cell(x-1,y,newspecies);
// 					//System.out.println(" 1--I was killed at location " + (x-1) + (y));
				
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}
// 				}
			
		

// 			if (((x-1) >= 0) && ((y+1) < grid[0].length)){
// 				if (grid[x-1][y+1].getOccupation() == false) {
// 			//		if (Math.random() <= 0) {
// 					Species1 newspecies = new Species1(x-1, y+1, grid, worldType);
// 					grid[x-1][y+1] = new Cell(x-1,y+1,newspecies);
// 					//System.out.println("THis happened instead 1");

// 					Thread t = new Thread(newspecies);
// 					t.start();
// }
// 			//	}
// 				else if (grid[x-1][y+1].getOccupation() == true) {
// 						if (Math.random()	<=	this.getFitnessLevel() - grid[x-1][y+1].getSpecies().getFitnessLevel()) {
// 					Species1 newspecies = new Species1(x-1, y+1,grid, worldType);
// 					grid[x-1][y+1].getSpecies().setIsAlive(false);
// 					//System.out.println("1 ---I was killed at location" + (x-1) + (y+1));
// 					grid[x-1][y+1] = new Cell(x-1,y+1,newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}
				
				
// 			}

// 			if ((y-1) >=0) {
// 				if (grid[x][y-1].getOccupation() == false) {
// 			//		if (Math.random() <= 0) {
// 					Species1 newspecies = new Species1(x, y-1,grid, worldType);
// 					grid[x][y-1] = new Cell(x, y-1 ,newspecies);
// 					//	System.out.println("THis happened instead 1");
// 					Thread t = new Thread(newspecies);

// 					t.start();
// }
// 			//	}

// 			else if (grid[x][y-1].getOccupation() == true) {
// 				//System.out.println(this.getFitnessLevel() - grid[x][y-1].getSpecies().getFitnessLevel());
// 				if (Math.random()	<=	this.getFitnessLevel() - grid[x][y-1].getSpecies().getFitnessLevel()) {
// 					Species1 newspecies = new Species1(x, y-1,grid, worldType);
// 					grid[x][y-1].getSpecies().setIsAlive(false);
// 					//System.out.println("1 ---I was killed at location" + (x) + (y-1));
// 					grid[x][y-1] = new Cell (x, y-1,newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}

				
// 			}
			

// 			if ((y+1)< grid[0].length){
// 				if (grid[x][y+1].getOccupation() == false) {
// 			//		if (Math.random() <= 0) {
// 					Species1 newspecies = new Species1(x, y+1, grid, worldType);
// 					grid[x][y+1] = new Cell (x,y+1,newspecies);
// 					//System.out.println("THis happened instead 1");
// 					Thread t = new Thread(newspecies);
// 					t.start();

// 			//	}
// }
// 				else if (grid[x][y+1].getOccupation() == true) {
// 				//	System.out.println(this.getFitnessLevel() - grid[x][y+1].getSpecies().getFitnessLevel());
// 				if (Math.random()	<=	(this.getFitnessLevel() - grid[x][y+1].getSpecies().getFitnessLevel())) {
// 					Species1 newspecies = new Species1(x, y+1, grid, worldType);
// 					grid[x][y+1].getSpecies().setIsAlive(false);
// 					//System.out.println("1 ---I was killed at location" + (x) + (y+1));
// 					grid[x][y+1]= new Cell (x,y+1,newspecies);

// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}
							
// 			}

// 			if (((x+1) < grid[0].length) && ((y-1)>= 0)) {

// 				if (grid[x+1][y-1].getOccupation()== false) {
// 			//		if (Math.random() <= 0) {
// 					Species1 newspecies = new Species1(x+1, y-1,grid, worldType);
// 					grid[x+1][y-1] = new Cell(x+1,y-1, newspecies);
// 					//System.out.println("THis happened instead 1");
// 					Thread t = new Thread(newspecies);
// 					t.start();

// 			//	}
// }
// 				else if (grid[x+1][y-1].getOccupation() == true) {
// 				//	System.out.println(this.getFitnessLevel() - grid[x+1][y-1].getSpecies().getFitnessLevel());
// 				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y-1].getSpecies().getFitnessLevel()) {
// 					Species1 newspecies = new Species1(x+1, y-1,grid, worldType);
// 					grid[x+1][y-1].getSpecies().setIsAlive(false);
// 					//System.out.println("1 ---I was killed at location" + (x+1) + (y-1));
// 					grid[x+1][y-1] = new Cell (x+1,y-1,newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}

			

// 			}

// 			if ((x+1) < grid[0].length) {
// 				if (grid[x+1][y].getOccupation() == false) {
// 			//		if (Math.random() <= 0) {
// 					Species1 newspecies = new Species1(x+1, y,grid, worldType);
// 					grid[x+1][y] = new Cell (x+1,y,newspecies);
// 					//	System.out.println("THis happened instead 1");
// 					Thread t = new Thread(newspecies);
// 					t.start();
// }
// 			//	}

// 				else if (grid[x+1][y].getOccupation() == true) {
// 				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y].getSpecies().getFitnessLevel()) {
// 					Species1 newspecies = new Species1(x+1, y,grid, worldType);
// 					grid[x+1][y].getSpecies().setIsAlive(false);
// 					//System.out.println("1 ---I was killed at location" + (x+1) + (y));
// 					grid[x+1][y] = new Cell (x+1,y,newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}
// 				}
			

// 			if (((x+1) < grid[0].length) && ((y+1) < grid[0].length)) {

// 					if (grid[x+1][y+1].getOccupation() == false) {
// 				//		if (Math.random() <= 0) {

// 					Species1 newspecies = new Species1(x+1, y+1,grid, worldType);
// 					grid[x+1][y+1] = new Cell (x+1,y+1,newspecies);
// 					//System.out.println("THis happened instead 1");
// 					Thread t = new Thread(newspecies);
// 					t.start();

// 				}
// 			//}
// 			else if (grid[x+1][y+1].getOccupation() == true) {
// 				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y+1].getSpecies().getFitnessLevel()) {
// 					Species1 newspecies = new Species1(x+1, y+1, grid, worldType);

// 					grid[x+1][y+1].getSpecies().setIsAlive(false);
// 					//System.out.println("1 ---I was killed at location" + (x+1) + (y+1));
// 					grid[x+1][y+1] = new Cell (x+1,y+1,newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}
// 				}
// 			}
// 			catch (NullPointerException e) {

// 			}

// 		}

	/** 
	*	The species1 reproduces depending on the state of 
	*   its neighbours
	*   @param neighbours - neighbours array which is different depending on what world is active
	*/
	public synchronized void reproduce(Cell [] neighbours) {
		try {
			Cell [] myNeighbours= neighbours;
			for (int i=0; i<myNeighbours.length; i++) {

				//If the neighbouring cell isn't occupied
				if (myNeighbours[i].getOccupation() == false) {
					if (Math.random() <= this.getFitnessLevel()){
						Species1 newspecies = new Species1(myNeighbours[i].getX(),myNeighbours[i].getY(), grid, worldType);
						grid[myNeighbours[i].getX()][myNeighbours[i].getY()] = new Cell (myNeighbours[i].getX(),myNeighbours[i].getY(), newspecies);
						Thread t = new Thread(newspecies);
						t.start();
					}
				}

				//If the neighbouring cell is occupied, then attempt to murder the occupier
				else if (myNeighbours[i].getOccupation() == true) {
					if (Math.random()	<=	this.getFitnessLevel() - myNeighbours[i].getSpecies().getFitnessLevel()) {
						Species1 newspecies = new Species1(myNeighbours[i].getX(),myNeighbours[i].getY(),grid, worldType);
						myNeighbours[i].getSpecies().setIsAlive(false);
						grid[myNeighbours[i].getX()][myNeighbours[i].getY()] = new Cell (myNeighbours[i].getX(),myNeighbours[i].getY(), newspecies);
						Thread t = new Thread(newspecies);
						t.start();	
						}
					}
				}
			}
			catch (NullPointerException e) {
			}
		}


		// public void reproduce2() {
		// try {
		// Cell [] myNeighbours = this.getNeighbours();
		// 	for (int i=0; i<myNeighbours.length; i++) {
		// 		if (myNeighbours[i].getOccupation() == false) {
		// 			Species1 newspecies = new Species1(myNeighbours[i].getX(),myNeighbours[i].getY(), grid, worldType);
		// 			grid[myNeighbours[i].getX()][myNeighbours[i].getY()] = new Cell (myNeighbours[i].getX(),myNeighbours[i].getY(), newspecies);

		// 			//System.out.println("THis happened instead 1");
		// 			Thread t = new Thread(newspecies);
		// 			t.start();
		// 		}
		// 		else if (myNeighbours[i].getOccupation() == true) {
		// 			if (Math.random()	<=	this.getFitnessLevel() - myNeighbours[i].getSpecies().getFitnessLevel()) {
		// 			Species1 newspecies = new Species1(myNeighbours[i].getX(),myNeighbours[i].getY(),grid, worldType);

		// 			myNeighbours[i].getSpecies().setIsAlive(false);
		// 			//System.out.println("1 ---I was killed at location" + (x+1) + (y+1));
		// 			grid[myNeighbours[i].getX()][myNeighbours[i].getY()] = new Cell (myNeighbours[i].getX(),myNeighbours[i].getY(), newspecies);
		// 			Thread t = new Thread(newspecies);
		// 			t.start();	
		// 		}
		// 		}
		// 		}
		// 	}
		// 	catch (NullPointerException e) {

		// 	}
		// 	}
		}

	



	
