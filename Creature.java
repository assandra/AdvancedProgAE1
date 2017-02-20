import java.util.*;
public class Creature {
	protected double lifeSpan;
	protected double maxLifeSpan;
	protected double fitnessLevel;
	
	protected boolean isAlive;
	protected int x;
	protected int y;
	protected Grid world;
	public Cell [][] grid;

	

	//Default constructor
	//CONSIDER LEAVING BLANK, SO JAVA INSERTS DEFAULT VALUES, GOOD DESIGN?
	public Creature(int x, int y, Cell [][] grid) {
		this.x = x;
		this.y = y;
		this.world = world;
		this.grid = grid;		

	}


		//Accessor Methods
	public double getLifeSpan() {
		return lifeSpan;
	}

	public double getMaxLifeSpan() {
		return maxLifeSpan;
	}

	public double getFitnessLevel() {
		return fitnessLevel;
	}
	
	



	//Mutator methods
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}


	protected void setLifeSpan(double lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	protected void setMaxLifeSpan(double maxLifeSpan) {
		this.maxLifeSpan = maxLifeSpan;
	}

	protected void setFitnessLevel(double fitnessLevel) {
		this.fitnessLevel= fitnessLevel;
	}





	public int identifier() {
		return 0;
	}




	
	
	
	}




