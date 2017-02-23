public class Species2 extends Creature implements Runnable {
	
	/** Constructor */
	public Species2(int x, int y, Cell [][] grid, int worldType) {
		super(x,y, grid, worldType);
		setMaxLifeSpan(5);
		setFitnessLevel(0.4);
		findLifeSpan();
		setIsAlive(true);
	}
	
	/** Identifier for Species 2*/
	public int identifier() {
		return 2;
	}

	/** Run method for Species 2 */
	public void run() {
		try{
			long sleep =(long) this.getLifeSpan() * 1000;
			Thread.sleep(sleep);
			if (isAlive == true) {
				if (this.getWorldType()==1) {
					Cell [] neighbours1 = this.getNeighboursW1();
					this.reproduce(neighbours1);
				}
				else if (this.getWorldType()==2) {
					Cell [] neighbours2 = this.getNeighboursW2();
					this.reproduce(neighbours2);
				}
						
				grid[x][y] = new Cell (x,y);
			
				Thread.currentThread().interrupt();
			}
			else if (isAlive == false) { 
				Thread.currentThread().interrupt();
			}
		}
		catch (InterruptedException e){
		}
	}
           
// 	public void reproducegfhj() {
// 		try {
		

// 		if (((x-1) >= 0) && ((y-1) >=0)){

// 				if (grid[x-1][y-1].getOccupation() == false) {
// 					//if (Math.random() <= 0) {
// 					Species2 newspecies = new Species2(x-1, y-1, grid, worldType);
// 					//System.out.println("THis happened instead 2");
// 					grid[x-1][y-1] = new Cell (x-1,y-1, newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();
// //}
// 				}

// 				else if (grid[x-1][y-1].getOccupation() == true) {
					

// 					if ( Math.random()	<=	this.getFitnessLevel() - grid[x-1][y-1].getSpecies().getFitnessLevel())
// 					{
// 					Species2 newspecies = new Species2(x-1, y-1, grid, worldType);
// 					grid[x-1][y-1].getSpecies().setIsAlive(false);
// 					//System.out.println("Ive been killed at location" +(x-1) + (y-1));
// 					grid[x-1][y-1] = new Cell (x-1,y-1, newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}



// 			}
		

// 			if ((x-1) >=0) {

// 				if (grid[x-1][y].getOccupation() == false) {
// 				//	if (Math.random() <= 0) {
// 					Species2 newspecies = new Species2(x-1, y, grid, worldType);
// 					//System.out.println("THis happened instead 2");
// 					grid[x-1][y] = new Cell (x-1,y, newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();
// //}
// 				}
// 				else if (grid[x-1][y].getOccupation() == true) {

// 				if ( Math.random()	<=	this.getFitnessLevel() - grid[x-1][y].getSpecies().getFitnessLevel())
// 					 {
// 					Species2 newspecies = new Species2(x-1, y, grid, worldType);
// 					grid[x-1][y].getSpecies().setIsAlive(false);
// 					//System.out.println("Ive been killed at location" +(x-1) + y);
// 					grid[x-1][y] = new Cell (x-1,y,newspecies);

// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}
// 		}
			
		

// 			if (((x-1) >= 0) && ((y+1) < grid[0].length)){
// 				if (grid[x-1][y+1].getOccupation() == false) {
// 					Species2 newspecies = new Species2(x-1, y+1,grid, worldType);
// 					//System.out.println("THis happened instead 2");
// 					grid[x-1][y+1] = new Cell(x-1,y+1,newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();

// 				}
// 				else if (grid[x-1][y+1].getOccupation() ==true) {
// 						if (Math.random()	<=	this.getFitnessLevel() - grid[x-1][y+1].getSpecies().getFitnessLevel()) {
// 				Species2 newspecies = new Species2(x-1, y+1,grid, worldType);
// 					grid[x-1][y+1].getSpecies().setIsAlive(false);
// 					//System.out.println("2----Ive been killed at location" +(x-1) + (y+1));
// 					grid[x-1][y+1] = new Cell(x-1,y+1,newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}
				
				
// 			}

// 			if ((y-1) >=0) {
// 				if (grid[x][y-1].getOccupation() == false) {
// 				//	if (Math.random() <= 0) {
// 					Species2 newspecies = new Species2(x, y-1,grid, worldType);
// 					grid[x][y-1] = new Cell(x,y-1,newspecies);
// 					//System.out.println("THis happened instead 2");
// 					Thread t = new Thread(newspecies);
// 					t.start();

// 				}

// 			else if (grid[x][y-1].getOccupation() == true) {
// 				if (Math.random()	<=	this.getFitnessLevel() - grid[x][y-1].getSpecies().getFitnessLevel()) {
// 					Species2 newspecies = new Species2(x, y-1, grid, worldType);
// 					grid[x][y-1].getSpecies().setIsAlive(false);
// 					//System.out.println("2----Ive been killed at location" +(x) + (y+1));
// 					grid[x][y-1] = new Cell(x, y-1,newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}

				
// 			}
			

// 			if ((y+1)< grid[0].length){
// 				if (grid[x][y+1].getOccupation() == false) {
// 				//	if (Math.random() <= 0) {
// 					Species2 newspecies = new Species2(x, y+1, grid, worldType);
// 					grid[x][y+1]= new Cell(x,y+1,newspecies);
// 					//System.out.println("THis happened instead 2");

// 					Thread t = new Thread(newspecies);
// 					t.start();

// 			//	}
// }
// 				else if (grid[x][y+1].getOccupation() == true) {
// 				if (Math.random()	<=	this.getFitnessLevel() - grid[x][y+1].getSpecies().getFitnessLevel()) {
// 					Species2 newspecies = new Species2(x, y+1, grid, worldType);

// 					grid[x][y+1].getSpecies().setIsAlive(false);
// 					//System.out.println("2--Ive been killed at location" +(x) + (y+1));
// 					grid[x][y+1] = new Cell(x,y+1,newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}
							
// 			}

// 			if (((x+1) <grid[0].length) && ((y-1)>= 0)) {

// 				if (grid[x+1][y-1].getOccupation() == false) {
// 				//	if (Math.random() <= 0) {
// 					Species2 newspecies = new Species2(x+1, y-1, grid, worldType);
// 					grid[x+1][y-1] = new Cell(x+1,y-1,newspecies);
// 					//System.out.println("THis happened instead 2");

// 					Thread t = new Thread(newspecies);
// 					t.start();

				
// }
// 				else if (grid[x+1][y-1].getOccupation() == true) {
// 				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y-1].getSpecies().getFitnessLevel()) {
// 					Species2 newspecies = new Species2(x+1, y-1,grid, worldType);
// 				grid[x+1][y-1].getSpecies().setIsAlive(false);
// 				//System.out.println("2--Ive been killed at location" +(x+1) + (y-1));
// 					grid[x+1][y-1] = new Cell (x+1,y-1,newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}

			

// 			}

// 			if ((x+1) < grid[0].length) {
// 				if (grid[x+1][y].getOccupation() == false) {
// 					//if (Math.random() <= 0) {
// 					Species2 newspecies = new Species2(x+1, y,grid, worldType);
// 					grid[x+1][y] = new Cell (x+1,y,newspecies);
// 					//System.out.println("2---THis happened instead 2");

// 					Thread t = new Thread(newspecies);
// 					t.start();

				
// }
// 				else if (grid[x+1][y].getOccupation() == true) {
// 			if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y].getSpecies().getFitnessLevel()) {
// 					Species2 newspecies = new Species2(x+1, y,grid, worldType);
// 				grid[x+1][y].getSpecies().setIsAlive(false);
// 				//System.out.println("2---Ive been killed at location" +(x+1) + y);
// 					grid[x+1][y] = new Cell(x+1,y, newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				//}
// 				}
			
// }
// 			if (((x+1) < grid[0].length) && ((y+1) < grid[0].length)) {

// 					if (grid[x+1][y+1].getOccupation() == false) {
// 						//if (Math.random() <= 0) {

// 					Species2 newspecies = new Species2(x+1, y+1, grid, worldType);
// 					grid[x+1][y+1] = new Cell (x+1,y+1,newspecies);
// 					//System.out.println("THis happened instead 2");

// 					Thread t = new Thread(newspecies);
// 					t.start();
// }
				
// 			else if (grid[x+1][y+1].getOccupation() == true) {
// 			if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y+1].getSpecies().getFitnessLevel()) {
// 					Species2 newspecies = new Species2(x+1, y+1, grid, worldType);
// 				grid[x+1][y+1].getSpecies().setIsAlive(false);
// 				//System.out.println("2--Ive been killed at location" +(x+1) + (y+1));
// 					grid[x+1][y+1] = new Cell (x+1,y+1,newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 			}
// 				}
// 				}
// }
// catch(NullPointerException e) {

// }		
// 		}
	

	/** 
	*	The species2 reproduces depending on the state of 
	*   its neighbours
	*   @param neighbours - neighbours array which is different depending on what world is active
	*/
	public synchronized void reproduce(Cell [] neighbours) {
		Cell [] myNeighbours = neighbours;
		try {
			for (int i=0; i<myNeighbours.length; i++) {
				if (myNeighbours[i].getOccupation() == false) {
					if (Math.random() <= this.getFitnessLevel()) {
						Species2 newspecies = new Species2(myNeighbours[i].getX(),myNeighbours[i].getY(), grid, worldType);
						grid[myNeighbours[i].getX()][myNeighbours[i].getY()] = new Cell (myNeighbours[i].getX(),myNeighbours[i].getY(), newspecies);
						Thread t = new Thread(newspecies);
						t.start();
					}
				}
			 	else if (myNeighbours[i].getOccupation() == true) {
					if (Math.random()	<=	this.getFitnessLevel() - myNeighbours[i].getSpecies().getFitnessLevel()) {
						Species2 newspecies = new Species2(myNeighbours[i].getX(),myNeighbours[i].getY(),grid, worldType);
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

	
// 		public void reproduce2() {
// 			//Cell [] myNeighbours = n;
// 			Cell [] myNeighbours = getNeighbours();
	
// 			for (int i=0; i<myNeighbours.length; i++) {
// 				try {
// 				if (myNeighbours[i].getOccupation() == false) {
// 					Species2 newspecies = new Species2(myNeighbours[i].getX(),myNeighbours[i].getY(), grid, worldType);
// 					grid[myNeighbours[i].getX()][myNeighbours[i].getY()] = new Cell (myNeighbours[i].getX(),myNeighbours[i].getY(), newspecies);

// 			//System.out.println("THis happened instead 1");
// 					Thread t = new Thread(newspecies);
// 					t.start();
// 			}
			
// 			 else if (myNeighbours[i].getOccupation() == true) {
// 					if (Math.random()	<=	this.getFitnessLevel() - myNeighbours[i].getSpecies().getFitnessLevel()) {
// 					Species2 newspecies = new Species2(myNeighbours[i].getX(),myNeighbours[i].getY(),grid, worldType);

// 					myNeighbours[i].getSpecies().setIsAlive(false);
// 					//System.out.println("1 ---I was killed at location" + (x+1) + (y+1));
// 					grid[myNeighbours[i].getX()][myNeighbours[i].getY()] = new Cell (myNeighbours[i].getX(),myNeighbours[i].getY(), newspecies);
// 					Thread t = new Thread(newspecies);
// 					t.start();	
// 				}
// 				}
// 				}
			
// 			catch (NullPointerException e) {

// 			}
			
// 		}
	
// }

}