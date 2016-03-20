package ants;

import core.AntColony;
import core.Bee;
import core.Ant;

/**
 * @author CESARO Jordan
 */

public class LongThrowerAnt extends Ant implements Damaging {
	protected int damage;
	private boolean doubled = false;

	/**
	 * Creates a new Thrower Ant.
	 * Armor: 1, Food: 0, Damage: 1
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
	
	public void doubleDamage() {
		damage = 2*damage;
	}
	
	public void setDoubled() {
		this.doubled = true;
	}
	
	public boolean getIfDoubled() {
		return this.doubled;
	}
	

	@Override
	public void action (AntColony colony) {
		Bee target = getTarget();
		if (target != null) {
			target.reduceArmor(damage);
		}
	}
}
