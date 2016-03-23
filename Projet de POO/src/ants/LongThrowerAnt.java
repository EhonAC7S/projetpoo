package ants;

import core.AntColony;
import core.Bee;
import core.Ant;

/**
 * @author CESARO Jordan
 */

public class LongThrowerAnt extends Ant implements Damaging {
	private int damage;
	private boolean doubled = false;

	/**
	 * Creates a new LongThrower Ant.
	 * Armor: 1, Food: 3, Damage: 1
	 */
	public LongThrowerAnt () {
		super(1);
		damage = 1;
		super.foodCost = 3;
	}

	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 */
	public Bee getTarget () {
		return place.getClosestBee(4, 20);
	}
	/**
	 * Set the buff
	 * 
	 */
	
	public void doubleDamage() {
		damage = 2*damage;
	}
	/**
	 * A setter
	 * 
	 */
	
	public void setDoubled() {
		this.doubled = true;
	}
	/**
	 * A getter 
	 * 
	 * @return doubled
	 * 
	 */
	
	public boolean getIfDoubled() {
		return this.doubled;
	}
	
	/**
	 * Shot some bullets
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
