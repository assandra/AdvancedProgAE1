public class Species2 extends Creature implements Runnable {
	
	
	public Species2(int x, int y) {
		super(x,y);
		setMaxLifeSpan(5);
		setMaxFitnessLevel(0.4);
		findLifeSpan();
		findFitnessLevel();
		setIsAlive(true);
		this.grid = grid;
		
	}
	
	
	
	public double findLifeSpan() {

		double lifeSpan = Math.random() * this.getMaxLifeSpan();
		this.setLifeSpan(lifeSpan);
		return lifeSpan;
	}

	public double findFitnessLevel() {

		double fitnessLevel = Math.random() * this.getMaxFitnessLevel();
		this.setMaxFitnessLevel(fitnessLevel);
		return fitnessLevel;

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
						Thread.currentThread().interrupt();
						//System.out.println("I reproduced 2");
					}
					else if (isAlive == false) { 

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

				if (grid[x-1][y-1] == null) {
					//if (Math.random() <= 0) {
					Species2 newspecies = new Species2(x-1, y-1);
					System.out.println("THis happened instead 2");
					grid[x-1][y-1] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();
//}
				}

				else if (grid[x-1][y-1] != null) {
					

					if ( Math.random()	<=	this.getFitnessLevel() - grid[x-1][y-1].getFitnessLevel())
					 {
					Species2 newspecies = new Species2(x-1, y-1);
					grid[x-1][y-1].setIsAlive(false);
					System.out.println("Ive been killed at location" +(x-1) + (y-1));
					grid[x-1][y-1] =newspecies;
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}



			}
		

			if ((x-1) >=0) {

				if (grid[x-1][y] == null) {
				//	if (Math.random() <= 0) {
					Species2 newspecies = new Species2(x-1, y);
					System.out.println("THis happened instead 2");
					grid[x-1][y] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();
//}
				}
				else if (grid[x-1][y] != null) {

				if ( Math.random()	<=	this.getFitnessLevel() - grid[x-1][y].getFitnessLevel())
					 {
					Species2 newspecies = new Species2(x-1, y);
					grid[x-1][y].setIsAlive(false);
					System.out.println("Ive been killed at location" +(x-1) + y);
					grid[x-1][y] = newspecies;

					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
				}
			
		

			if (((x-1) >= 0) && ((y+1) < grid[0].length)){
				if (grid[x-1][y+1] == null) {
					Species2 newspecies = new Species2(x-1, y+1);
					System.out.println("THis happened instead 2");
					grid[x-1][y+1] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();

				}
				else if (grid[x-1][y+1] != null) {
						if (Math.random()	<=	this.getFitnessLevel() - grid[x-1][y+1].getFitnessLevel()) {
				Species2 newspecies = new Species2(x-1, y+1);
					grid[x-1][y+1].setIsAlive(false);
					System.out.println("2----Ive been killed at location" +(x-1) + (y+1));
					grid[x-1][y+1] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
				
				
			}

			if ((y-1) >=0) {
				if (grid[x][y-1] == null) {
				//	if (Math.random() <= 0) {
					Species2 newspecies = new Species2(x, y-1);
					grid[x][y-1] = newspecies;
					System.out.println("THis happened instead 2");
					Thread t = new Thread(newspecies);
					t.start();

				}

			else if (grid[x][y-1] != null) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x][y-1].getFitnessLevel()) {
					Species2 newspecies = new Species2(x, y-1);
					grid[x][y-1].setIsAlive(false);
					System.out.println("2----Ive been killed at location" +(x) + (y+1));
					grid[x][y-1] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}

				
			}
			

			if ((y+1)< grid[0].length){
				if (grid[x][y+1] == null) {
				//	if (Math.random() <= 0) {
					Species2 newspecies = new Species2(x, y+1);
					grid[x][y+1]= newspecies;
					System.out.println("THis happened instead 2");

					Thread t = new Thread(newspecies);
					t.start();

			//	}
}
				else if (grid[x][y+1] != null) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x][y+1].getFitnessLevel()) {
					Species2 newspecies = new Species2(x, y+1);

					grid[x][y+1].setIsAlive(false);
					System.out.println("2--Ive been killed at location" +(x) + (y+1));
					grid[x][y+1] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
							
			}

			if (((x+1) <grid[0].length) && ((y-1)>= 0)) {

				if (grid[x+1][y-1] == null) {
				//	if (Math.random() <= 0) {
					Species2 newspecies = new Species2(x+1, y-1);
					grid[x+1][y-1] = newspecies;
					System.out.println("THis happened instead 2");

					Thread t = new Thread(newspecies);
					t.start();

				
}
				else if (grid[x+1][y-1] != null) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y-1].getFitnessLevel()) {
					Species2 newspecies = new Species2(x+1, y-1);
				grid[x+1][y-1].setIsAlive(false);
				System.out.println("2--Ive been killed at location" +(x+1) + (y-1));
					grid[x+1][y-1] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}

			

			}

			if ((x+1) < grid[0].length) {
				if (grid[x+1][y] == null) {
					//if (Math.random() <= 0) {
					Species2 newspecies = new Species2(x+1, y);
					grid[x+1][y] = newspecies;
					System.out.println("2---THis happened instead 2");

					Thread t = new Thread(newspecies);
					t.start();

				
}
				else if (grid[x+1][y] != null) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y].getFitnessLevel()) {
					Species2 newspecies = new Species2(x+1, y);
				grid[x+1][y].setIsAlive(false);
				System.out.println("2---Ive been killed at location" +(x+1) + y);
					grid[x+1][y] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();	
			//	}
				}
				}
			
}
			if (((x+1) < grid[0].length) && ((y+1) < grid[0].length)) {

					if (grid[x+1][y+1] == null) {
						//if (Math.random() <= 0) {

					Species2 newspecies = new Species2(x+1, y+1);
					grid[x+1][y+1] = newspecies;
					System.out.println("THis happened instead 2");

					Thread t = new Thread(newspecies);
					t.start();
}
				
			else if (grid[x+1][y+1] != null) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y+1].getFitnessLevel()) {
					Species2 newspecies = new Species2(x+1, y+1);
				grid[x+1][y+1].setIsAlive(false);
				System.out.println("2--Ive been killed at location" +(x+1) + (y+1));
					grid[x+1][y+1] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
				}

		
		

	

	
}
}