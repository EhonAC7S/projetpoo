package core;

/**
 * A class representing a basic Ant
 *
 * @author CESARO 
 */
public abstract class Ant extends Insect {

	protected int foodCost; // the amount of food needed to make this ant
	protected boolean blockTheWay; //new
	protected static int noQueen=-1; //On part de -1 car le constructeur est appelé une fois pour la barre de selection de fourmie.
	
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
	
	public void noQueen(){
			this.reduceArmor(getArmor());
			noQueen-=1;
			System.out.println("Cette fourmie est une usurpatrice! Elle doit mourir!");	
	}
}
