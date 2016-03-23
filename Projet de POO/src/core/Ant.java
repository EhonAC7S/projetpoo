package core;

/**
 * A class representing a basic Ant
 *
 * 
 */
public abstract class Ant extends Insect {

	protected int foodCost; // the amount of food needed to make this ant
	protected boolean blockTheWay; //new
	
	/**
	 * Creates a new Ant, with a food cost of 0.
	 *
	 * @param armor
	 *            The armor of the ant.
	 */
	public Ant (int armor) { 
		super(armor, null);
		foodCost = 0;
		blockTheWay = true; 
		}
 
	/**
	 * Returns the ant's food cost
	 *
	 * @return the ant's good cost
	 */
	public int getFoodCost () {
		return foodCost;
	}

	/**
	 * Removes the ant from its current place
	 */
	
	@Override
	public void leavePlace () { 
		place.removeInsect(this);
	}
	/**
	 * The function call which remove an impostor Queen Ant 
	 * 
	 */
	public void noQueen(){
			this.reduceArmor(getArmor()); //kill this Queen Ant we have already one.
			System.out.println("Cette fourmie est une usurpatrice! Elle doit mourir!");	
	}
}
