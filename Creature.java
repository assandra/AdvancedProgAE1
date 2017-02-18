import java.util.*;
public class Creature {
	protected double lifeSpan;
	protected double maxLifeSpan;
	protected double fitnessLevel;
	protected double maxFitnessLevel;
	protected boolean isAlive;
	protected int x;
	protected int y;
	public Creature [][] grid;

	

	//Default constructor
	//CONSIDER LEAVING BLANK, SO JAVA INSERTS DEFAULT VALUES, GOOD DESIGN?
	public Creature(int x, int y) {
		this.x = x;
		this.y = y;
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
	
	public double getMaxFitnessLevel() {
		return maxFitnessLevel;
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

	protected void setMaxFitnessLevel(double maxFitnessLevel) {
		this.maxFitnessLevel = maxFitnessLevel;
	}



	public int identifier() {
		return 0;
	}




	
	
	
	}




