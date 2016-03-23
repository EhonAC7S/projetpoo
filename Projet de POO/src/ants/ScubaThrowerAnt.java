package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class ScubaThrowerAnt extends Ant implements Damaging {
	
	protected int damage=1;
	private boolean doubled = false;
	
	/**
	 * Creates a new Scuba Ant with 5 foodCost and is watersafe
	 */
	
	public ScubaThrowerAnt () {
		super(1);
		foodCost=5;
		waterSafe=true;
		
	}
	
	/**
	 * Double the amount of damage
	 * 
	 * 
	 */
	
	public void doubleDamage() {
		damage = 2*damage;
	}
	
	/**
	 * Set the boolean 'doubled' of the scuba to true
	 * 
	 * 
	 */
	
	public void setDoubled() {
		this.doubled = true;
	}
	
	/**
	 * a simple getter of the doubled parameter
	 * 
	 * @return doubled
	 */
	
	public boolean getIfDoubled() {
		return this.doubled;
	}
	
	/**
	 * Get the nearest bee
	 * 
	 * @return the nearest bee in a range of 3
	 */
	
	public Bee getTarget () {
		return place.getClosestBee(0, 3);
	}

	/**
	 * Shot a bullet to make damage in front of her.
	 * 
	 * 
	 */
	
	@Override
	public void action (AntColony colony) {
		Bee target = getTarget();
		if (target != null) {
			target.reduceArmor(damage);
		}
	}
}
