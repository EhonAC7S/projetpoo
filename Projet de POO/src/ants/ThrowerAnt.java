package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at bees
 *
 * @author CESARO Jordan
 */

public class ThrowerAnt extends Ant {

	protected int damage;
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

	public void doubleDamage() {
		damage = 2*damage;
	}
	
	public void setDoubled() {
		this.doubled = true;
	}
	
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

	@Override
	public void action (AntColony colony) {
		Bee target = getTarget();
		if (target != null) {
			target.reduceArmor(damage);
		}
	}
}
