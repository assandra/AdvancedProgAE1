public class Species2 extends Creature implements Runnable {
	
	
	public Species2(int x, int y, Cell [][] grid) {
		super(x,y, grid);
		setMaxLifeSpan(5);
		setFitnessLevel(0.4);
		findLifeSpan();
		
		setIsAlive(true);
		
		
	}
	
	
	
	public double findLifeSpan() {

		double lifeSpan = Math.random() * this.getMaxLifeSpan();
		this.setLifeSpan(lifeSpan);
		return lifeSpan;
	}



	public int identifier() {
		return 2;
	}

public void run() {
		
			try{
				//while (Thread.currentThread().isInterrupted() == false) {

				//Thread.sleep((long)this.getLifeSpan());
					Thread.sleep(500);
				

					if (isAlive == true) {
						this.reproduce();
						grid[x][y] = new Cell (x,y);
						System.out.println(grid[x][y].getOccupation());
						Thread.currentThread().interrupt();
						//System.out.println(grid[1][0].getOccupation()+ "Can i see you 2 (1,0)");
					//System.out.println(grid[1][1].getOccupation()+"can i see you 1 (1,1)");
        			//System.out.println(grid[1][2].getOccupation()+ "can I see you 1 (1,2)");
        			//System.out.println(grid[1][3].getOccupation()+ "can I see you 1 (1,3)");
					//System.out.println("I reproduced 2");
					}
					else if (isAlive == false) { 
					//	System.out.println("IM DEAD  222");

					Thread.currentThread().interrupt();
					//System.out.println("Ive been murdered 2");
				}
		//}	
			//Thread.currentThread().interrupt();
		}
			catch (InterruptedException e){
				
				 }
				}
           
	public void reproduce() {
		

		if (((x-1) >= 0) && ((y-1) >=0)){

				if (grid[x-1][y-1].getOccupation() == false) {
					//if (Math.random() <= 0) {
					Species2 newspecies = new Species2(x-1, y-1, grid);
					//System.out.println("THis happened instead 2");
					grid[x-1][y-1] = new Cell (x-1,y-1, newspecies);
					Thread t = new Thread(newspecies);
					t.start();
//}
				}

				else if (grid[x-1][y-1].getOccupation() == true) {
					

					if ( Math.random()	<=	this.getFitnessLevel() - grid[x-1][y-1].getSpecies().getFitnessLevel())
					{
					Species2 newspecies = new Species2(x-1, y-1, grid);
					grid[x-1][y-1].getSpecies().setIsAlive(false);
					//System.out.println("Ive been killed at location" +(x-1) + (y-1));
					grid[x-1][y-1] = new Cell (x-1,y-1, newspecies);
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}



			}
		

			if ((x-1) >=0) {

				if (grid[x-1][y].getOccupation() == false) {
				//	if (Math.random() <= 0) {
					Species2 newspecies = new Species2(x-1, y, grid);
					//System.out.println("THis happened instead 2");
					grid[x-1][y] = new Cell (x-1,y, newspecies);
					Thread t = new Thread(newspecies);
					t.start();
//}
				}
				else if (grid[x-1][y].getOccupation() == true) {

				if ( Math.random()	<=	this.getFitnessLevel() - grid[x-1][y].getSpecies().getFitnessLevel())
					 {
					Species2 newspecies = new Species2(x-1, y, grid);
					grid[x-1][y].getSpecies().setIsAlive(false);
					//System.out.println("Ive been killed at location" +(x-1) + y);
					grid[x-1][y] = new Cell (x-1,y,newspecies);

					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
		}
			
		

			if (((x-1) >= 0) && ((y+1) < grid[0].length)){
				if (grid[x-1][y+1].getOccupation() == false) {
					Species2 newspecies = new Species2(x-1, y+1,grid);
					//System.out.println("THis happened instead 2");
					grid[x-1][y+1] = new Cell(x-1,y+1,newspecies);
					Thread t = new Thread(newspecies);
					t.start();

				}
				else if (grid[x-1][y+1].getOccupation() ==true) {
						if (Math.random()	<=	this.getFitnessLevel() - grid[x-1][y+1].getSpecies().getFitnessLevel()) {
				Species2 newspecies = new Species2(x-1, y+1,grid);
					grid[x-1][y+1].getSpecies().setIsAlive(false);
					//System.out.println("2----Ive been killed at location" +(x-1) + (y+1));
					grid[x-1][y+1] = new Cell(x-1,y+1,newspecies);
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
				
				
			}

			if ((y-1) >=0) {
				if (grid[x][y-1].getOccupation() == false) {
				//	if (Math.random() <= 0) {
					Species2 newspecies = new Species2(x, y-1,grid);
					grid[x][y-1] = new Cell(x,y-1,newspecies);
					//System.out.println("THis happened instead 2");
					Thread t = new Thread(newspecies);
					t.start();

				}

			else if (grid[x][y-1].getOccupation() == true) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x][y-1].getSpecies().getFitnessLevel()) {
					Species2 newspecies = new Species2(x, y-1, grid);
					grid[x][y-1].getSpecies().setIsAlive(false);
					//System.out.println("2----Ive been killed at location" +(x) + (y+1));
					grid[x][y-1] = new Cell(x, y-1,newspecies);
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}

				
			}
			

			if ((y+1)< grid[0].length){
				if (grid[x][y+1].getOccupation() == false) {
				//	if (Math.random() <= 0) {
					Species2 newspecies = new Species2(x, y+1, grid);
					grid[x][y+1]= new Cell(x,y+1,newspecies);
					//System.out.println("THis happened instead 2");

					Thread t = new Thread(newspecies);
					t.start();

			//	}
}
				else if (grid[x][y+1].getOccupation() == true) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x][y+1].getSpecies().getFitnessLevel()) {
					Species2 newspecies = new Species2(x, y+1, grid);

					grid[x][y+1].getSpecies().setIsAlive(false);
					//System.out.println("2--Ive been killed at location" +(x) + (y+1));
					grid[x][y+1] = new Cell(x,y+1,newspecies);
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
							
			}

			if (((x+1) <grid[0].length) && ((y-1)>= 0)) {

				if (grid[x+1][y-1].getOccupation() == false) {
				//	if (Math.random() <= 0) {
					Species2 newspecies = new Species2(x+1, y-1, grid);
					grid[x+1][y-1] = new Cell(x+1,y-1,newspecies);
					//System.out.println("THis happened instead 2");

					Thread t = new Thread(newspecies);
					t.start();

				
}
				else if (grid[x+1][y-1].getOccupation() == true) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y-1].getSpecies().getFitnessLevel()) {
					Species2 newspecies = new Species2(x+1, y-1,grid);
				grid[x+1][y-1].getSpecies().setIsAlive(false);
				//System.out.println("2--Ive been killed at location" +(x+1) + (y-1));
					grid[x+1][y-1] = new Cell (x+1,y-1,newspecies);
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}

			

			}

			if ((x+1) < grid[0].length) {
				if (grid[x+1][y].getOccupation() == false) {
					//if (Math.random() <= 0) {
					Species2 newspecies = new Species2(x+1, y,grid);
					grid[x+1][y] = new Cell (x+1,y,newspecies);
					//System.out.println("2---THis happened instead 2");

					Thread t = new Thread(newspecies);
					t.start();

				
}
				else if (grid[x+1][y].getOccupation() == true) {
			if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y].getSpecies().getFitnessLevel()) {
					Species2 newspecies = new Species2(x+1, y,grid);
				grid[x+1][y].getSpecies().setIsAlive(false);
				//System.out.println("2---Ive been killed at location" +(x+1) + y);
					grid[x+1][y] = new Cell(x+1,y, newspecies);
					Thread t = new Thread(newspecies);
					t.start();	
				}
				//}
				}
			
}
			if (((x+1) < grid[0].length) && ((y+1) < grid[0].length)) {

					if (grid[x+1][y+1].getOccupation() == false) {
						//if (Math.random() <= 0) {

					Species2 newspecies = new Species2(x+1, y+1, grid);
					grid[x+1][y+1] = new Cell (x+1,y+1,newspecies);
					//System.out.println("THis happened instead 2");

					Thread t = new Thread(newspecies);
					t.start();
}
				
			else if (grid[x+1][y+1].getOccupation() == true) {
			if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y+1].getSpecies().getFitnessLevel()) {
					Species2 newspecies = new Species2(x+1, y+1, grid);
				grid[x+1][y+1].getSpecies().setIsAlive(false);
				//System.out.println("2--Ive been killed at location" +(x+1) + (y+1));
					grid[x+1][y+1] = new Cell (x+1,y+1,newspecies);
					Thread t = new Thread(newspecies);
					t.start();	
			}
				}
				}

		
		

	

	
}
}