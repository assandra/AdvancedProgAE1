import java.util.*;

public class Species1 extends Creature implements Runnable {

	public Species1(int x, int y, Cell [][] grid) {
		super(x,y, grid);
		setMaxLifeSpan(10);
		setFitnessLevel(0.8);
		findLifeSpan();
		
		setIsAlive(true);
		
		
			}

	
	
	public double findLifeSpan() {
	
		double lifeSpan = Math.random() * this.getMaxLifeSpan();
		this.setLifeSpan(lifeSpan);
		return lifeSpan;
	}



	public int identifier() {
		return 1;
	}


	public void run() {
		
			try{
				

				//Thread.sleep((long)this.getLifeSpan());
					Thread.sleep(500);
				

					if (isAlive == true) {
						this.reproduce();
						grid[x][y] = new Cell(x,y);
						System.out.println(grid[x][y].getOccupation());
						Thread.currentThread().interrupt();
						//System.out.println(grid[0][0].getOccupation()+"can i see you 1 (0,0)");
						//System.out.println(grid[0][1].getOccupation()+"can i see you 1 (0,1)");
        				//System.out.println(grid[0][2].getOccupation()+ "can I see you 1 (0,2)");
        				//System.out.println(grid[0][3].getOccupation()+ "can I see you 1 (0,3)");
				//System.out.println("I reproduce 1");
					}
					else if (isAlive == false) { 
						//System.out.println("IM DEAD");

					Thread.currentThread().interrupt();
					//System.out.println("I was murdered 1");
				}
			
			//Thread.currentThread().interrupt();
		}
			catch (InterruptedException e){
				
				 }
				}
           
	public void reproduce() {

		


	
			if (((x-1) >= 0) && ((y-1) >=0)){

				if (grid[x-1][y-1].getOccupation() == false) {
//					if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x-1, y-1, grid);

					//could redo, and just set the sepcies of the cell and the set occupation to be true
					grid[x-1][y-1] = new Cell (x-1,y-1,newspecies);
					Thread t = new Thread(newspecies);
					t.start();
//}
				}

				else if (grid[x-1][y-1].getOccupation() == true) {
					
					//System.out.println(this.getFitnessLevel() - grid[x-1][y-1].getSpecies().getFitnessLevel());
					if ( Math.random()	<=	this.getFitnessLevel() - grid[x-1][y-1].getSpecies().getFitnessLevel())
					{
					Species1 newspecies = new Species1(x-1, y-1, grid);
					grid[x-1][y-1].getSpecies().setIsAlive(false);
					grid[x-1][y-1] = new Cell(x-1,y-1, newspecies);
					//System.out.println("1 ---I was killed at location" + (x-1) + (y-1));
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}



			}
		

			if ((x-1) >=0) {

				if (grid[x-1][y].getOccupation() == false) { 
			//		if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x-1, y, grid);
					//System.out.println("THis happened instead 1");

					Thread t = new Thread(newspecies);
					grid[x-1][y] = new Cell(x-1,y,newspecies);
					t.start();
//}
				}
				else if (grid[x-1][y].getOccupation() == true) {
					//System.out.println(this.getFitnessLevel() - grid[x-1][y].getSpecies().getFitnessLevel());
				if ( Math.random()	<=	this.getFitnessLevel() - grid[x-1][y].getSpecies().getFitnessLevel())
					 {
					Species1 newspecies = new Species1(x-1, y,grid);
					grid[x-1][y].getSpecies().setIsAlive(false);
					grid[x-1][y] = new Cell(x-1,y,newspecies);
					//System.out.println(" 1--I was killed at location " + (x-1) + (y));
				
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
				}
			
		

			if (((x-1) >= 0) && ((y+1) < grid[0].length)){
				if (grid[x-1][y+1].getOccupation() == false) {
			//		if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x-1, y+1, grid);
					grid[x-1][y+1] = new Cell(x-1,y+1,newspecies);
					//System.out.println("THis happened instead 1");

					Thread t = new Thread(newspecies);
					t.start();
}
			//	}
				else if (grid[x-1][y+1].getOccupation() == true) {
						if (Math.random()	<=	this.getFitnessLevel() - grid[x-1][y+1].getSpecies().getFitnessLevel()) {
					Species1 newspecies = new Species1(x-1, y+1,grid);
					grid[x-1][y+1].getSpecies().setIsAlive(false);
					//System.out.println("1 ---I was killed at location" + (x-1) + (y+1));
					grid[x-1][y+1] = new Cell(x-1,y+1,newspecies);
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
				
				
			}

			if ((y-1) >=0) {
				if (grid[x][y-1].getOccupation() == false) {
			//		if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x, y-1,grid);
					grid[x][y-1] = new Cell(x, y-1 ,newspecies);
					//	System.out.println("THis happened instead 1");
					Thread t = new Thread(newspecies);

					t.start();
}
			//	}

			else if (grid[x][y-1].getOccupation() == true) {
				//System.out.println(this.getFitnessLevel() - grid[x][y-1].getSpecies().getFitnessLevel());
				if (Math.random()	<=	this.getFitnessLevel() - grid[x][y-1].getSpecies().getFitnessLevel()) {
					Species1 newspecies = new Species1(x, y-1,grid);
					grid[x][y-1].getSpecies().setIsAlive(false);
					//System.out.println("1 ---I was killed at location" + (x) + (y-1));
					grid[x][y-1] = new Cell (x, y-1,newspecies);
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}

				
			}
			

			if ((y+1)< grid[0].length){
				if (grid[x][y+1].getOccupation() == false) {
			//		if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x, y+1, grid);
					grid[x][y+1] = new Cell (x,y+1,newspecies);
					//System.out.println("THis happened instead 1");
					Thread t = new Thread(newspecies);
					t.start();

			//	}
}
				else if (grid[x][y+1].getOccupation() == true) {
				//	System.out.println(this.getFitnessLevel() - grid[x][y+1].getSpecies().getFitnessLevel());
				if (Math.random()	<=	this.getFitnessLevel() - grid[x][y+1].getSpecies().getFitnessLevel()) {
					Species1 newspecies = new Species1(x, y+1, grid);
					grid[x][y+1].getSpecies().setIsAlive(false);
					//System.out.println("1 ---I was killed at location" + (x) + (y+1));
					grid[x][y+1]= new Cell (x,y+1,newspecies);

					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
							
			}

			if (((x+1) < grid[0].length) && ((y-1)>= 0)) {

				if (grid[x+1][y-1].getOccupation()== false) {
			//		if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x+1, y-1,grid);
					grid[x+1][y-1] = new Cell(x+1,y-1, newspecies);
					//System.out.println("THis happened instead 1");
					Thread t = new Thread(newspecies);
					t.start();

			//	}
}
				else if (grid[x+1][y-1].getOccupation() == true) {
				//	System.out.println(this.getFitnessLevel() - grid[x+1][y-1].getSpecies().getFitnessLevel());
				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y-1].getSpecies().getFitnessLevel()) {
					Species1 newspecies = new Species1(x+1, y-1,grid);
					grid[x+1][y-1].getSpecies().setIsAlive(false);
					//System.out.println("1 ---I was killed at location" + (x+1) + (y-1));
					grid[x+1][y-1] = new Cell (x+1,y-1,newspecies);
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}

			

			}

			if ((x+1) < grid[0].length) {
				if (grid[x+1][y].getOccupation() == false) {
			//		if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x+1, y,grid);
					grid[x+1][y] = new Cell (x+1,y,newspecies);
					//	System.out.println("THis happened instead 1");
					Thread t = new Thread(newspecies);
					t.start();
}
			//	}

				else if (grid[x+1][y].getOccupation() == true) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y].getSpecies().getFitnessLevel()) {
					Species1 newspecies = new Species1(x+1, y,grid);
					grid[x+1][y].getSpecies().setIsAlive(false);
					//System.out.println("1 ---I was killed at location" + (x+1) + (y));
					grid[x+1][y] = new Cell (x+1,y,newspecies);
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
				}
			

			if (((x+1) < grid[0].length) && ((y+1) < grid[0].length)) {

					if (grid[x+1][y+1].getOccupation() == false) {
				//		if (Math.random() <= 0) {

					Species1 newspecies = new Species1(x+1, y+1,grid);
					grid[x+1][y+1] = new Cell (x+1,y+1,newspecies);
					//System.out.println("THis happened instead 1");
					Thread t = new Thread(newspecies);
					t.start();

				}
			//}
			else if (grid[x+1][y+1].getOccupation() == true) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y+1].getSpecies().getFitnessLevel()) {
					Species1 newspecies = new Species1(x+1, y+1, grid);

					grid[x+1][y+1].getSpecies().setIsAlive(false);
					//System.out.println("1 ---I was killed at location" + (x+1) + (y+1));
					grid[x+1][y+1] = new Cell (x+1,y+1,newspecies);
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
				}


		}

	

	
}