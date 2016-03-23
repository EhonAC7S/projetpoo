package ants;

import core.AntColony;
import core.Bee;
import core.Ant;

public class ShortThrowerAnt extends Ant  implements Damaging {
	private int damage;
	private boolean doubled = false;

	/**
	 * Create a new Ant : ShortThrower
	 * 
	 * 1 Armor, 3 foodCost, 1 Damage.
	 */
	
	public ShortThrowerAnt () {
		super(1);
		damage = 1;
		super.foodCost = 3;
	}
	/**
	 * Set the buff of damage
	 * 
	 */
	
	public void doubleDamage() {
		damage = 2*damage;
	}
	
	/**
	 * Setter to tell its buffed
	 * 
	 * 
	 */
	
	public void setDoubled() {
		this.doubled = true;
	}
	/**
	 * A getter of if it is buffed
	 * 
	 */
	
	public boolean getIfDoubled() {
		return this.doubled;
	}
	

	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 */
	public Bee getTarget () {
		return place.getClosestBee(0, 2);
	}
	/**
	 * Shot some bullets to enemy
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
