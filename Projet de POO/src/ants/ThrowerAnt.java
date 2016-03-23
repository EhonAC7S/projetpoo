package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at bees
 *
 */

public class ThrowerAnt extends Ant implements Damaging {

	private int damage;
	private boolean doubled = false;

	/**
	 * Creates a new Thrower Ant.
	 * Armor: 1, Food: 0, Damage: 1
	 */
	public ThrowerAnt () {
		super(1);
		damage = 1;
		super.foodCost = 4;
	}
	/**
	 * Implement the buff
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
		return place.getClosestBee(0, 3);
	}
	/**
	 * Shot some bullets to make damage
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
