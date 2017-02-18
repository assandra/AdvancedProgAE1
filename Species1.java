import java.util.*;

public class Species1 extends Creature implements Runnable {

	public Species1(int x, int y) {
		super(x,y);
		setMaxLifeSpan(10);
		setMaxFitnessLevel(0.8);
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
		return 1;
	}


	public void run() {
		
			try{
				

				//Thread.sleep((long)this.getLifeSpan());
					Thread.sleep(500);
				

					if (isAlive == true) {
						this.reproduce();
						Thread.currentThread().interrupt();
						//System.out.println("I reproduce 1");
					}
					else if (isAlive == false) { 

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

				if (grid[x-1][y-1] == null) {
//					if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x-1, y-1);
					grid[x-1][y-1] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();
//}
				}

				else if (grid[x-1][y-1]!= null) {
					

					if ( Math.random()	<=	this.getFitnessLevel() - grid[x-1][y-1].getFitnessLevel())
					 {
					Species1 newspecies = new Species1(x-1, y-1);
					grid[x-1][y-1].setIsAlive(false);
					System.out.println("1 ---I was killed at location" + (x-1) + (y-1));
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}



			}
		

			if ((x-1) >=0) {

				if (grid[x-1][y] == null) { 
			//		if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x-1, y);
					System.out.println("THis happened instead 1");

					Thread t = new Thread(newspecies);
					grid[x-1][y] = newspecies;
					t.start();
//}
				}
				else if (grid[x-1][y] != null) {

				if ( Math.random()	<=	this.getFitnessLevel() - grid[x-1][y].getFitnessLevel())
					 {
					Species1 newspecies = new Species1(x-1, y);
					grid[x-1][y].setIsAlive(false);
					System.out.println(" 1--I was killed at location " + (x-1) + (y));
					grid[x-1][y] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
				}
			
		

			if (((x-1) >= 0) && ((y+1) < grid[0].length)){
				if (grid[x-1][y+1] == null) {
			//		if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x-1, y+1);
					grid[x-1][y+1] = newspecies;
					System.out.println("THis happened instead 1");

					Thread t = new Thread(newspecies);
					t.start();
}
			//	}
				else if (grid[x-1][y+1] != null) {
						if (Math.random()	<=	this.getFitnessLevel() - grid[x-1][y+1].getFitnessLevel()) {
					Species1 newspecies = new Species1(x-1, y+1);
					grid[x-1][y+1].setIsAlive(false);
					System.out.println("1 ---I was killed at location" + (x-1) + (y+1));
					grid[x-1][y+1] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
				
				
			}

			if ((y-1) >=0) {
				if (grid[x][y-1] == null) {
			//		if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x, y-1);
					grid[x][y-1] = newspecies;
						System.out.println("THis happened instead 1");
					Thread t = new Thread(newspecies);

					t.start();
}
			//	}

			else if (grid[x][y-1] != null) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x][y-1].getFitnessLevel()) {
					Species1 newspecies = new Species1(x, y-1);
					grid[x][y-1].setIsAlive(false);
					System.out.println("1 ---I was killed at location" + (x) + (y-1));
					grid[x][y-1] =newspecies;
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}

				
			}
			

			if ((y+1)< grid[0].length){
				if (grid[x][y+1] == null) {
			//		if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x, y+1);
					grid[x][y+1] = newspecies;
						System.out.println("THis happened instead 1");
					Thread t = new Thread(newspecies);
					t.start();

			//	}
}
				else if (grid[x][y+1] != null) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x][y+1].getFitnessLevel()) {
					Species1 newspecies = new Species1(x, y+1);
					grid[x][y+1].setIsAlive(false);
					System.out.println("1 ---I was killed at location" + (x) + (y+1));
					grid[x][y+1]= newspecies;

					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
							
			}

			if (((x+1) < grid[0].length) && ((y-1)>= 0)) {

				if (grid[x+1][y-1] == null) {
			//		if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x+1, y-1);
					grid[x+1][y-1] = newspecies;
						System.out.println("THis happened instead 1");
					Thread t = new Thread(newspecies);
					t.start();

			//	}
}
				else if (grid[x+1][y-1] != null) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y-1].getFitnessLevel()) {
					Species1 newspecies = new Species1(x+1, y-1);
					grid[x+1][y-1].setIsAlive(false);
					System.out.println("1 ---I was killed at location" + (x+1) + (y-1));
					grid[x+1][y-1] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}

			

			}

			if ((x+1) < grid[0].length) {
				if (grid[x+1][y] == null) {
			//		if (Math.random() <= 0) {
					Species1 newspecies = new Species1(x+1, y);
					grid[x+1][y] =newspecies;
						System.out.println("THis happened instead 1");
					Thread t = new Thread(newspecies);
					t.start();
}
			//	}

				else if (grid[x+1][y] != null) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y].getFitnessLevel()) {
					Species1 newspecies = new Species1(x+1, y);
					grid[x+1][y].setIsAlive(false);
					System.out.println("1 ---I was killed at location" + (x+1) + (y));
					grid[x+1][y] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
				}
			

			if (((x+1) < grid[0].length) && ((y+1) < grid[0].length)) {

					if (grid[x+1][y+1] == null) {
				//		if (Math.random() <= 0) {

					Species1 newspecies = new Species1(x+1, y+1);
					grid[x+1][y+1] = newspecies;
						System.out.println("THis happened instead 1");
					Thread t = new Thread(newspecies);
					t.start();

				}
			//}
			else if (grid[x+1][y+1] != null) {
				if (Math.random()	<=	this.getFitnessLevel() - grid[x+1][y+1].getFitnessLevel()) {
					Species1 newspecies = new Species1(x+1, y+1);

					grid[x+1][y+1].setIsAlive(false);
					System.out.println("1 ---I was killed at location" + (x+1) + (y+1));
					grid[x+1][y+1] = newspecies;
					Thread t = new Thread(newspecies);
					t.start();	
				}
				}
				}


		}

	

	
}