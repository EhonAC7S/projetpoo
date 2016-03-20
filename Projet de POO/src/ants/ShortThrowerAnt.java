package ants;

import core.AntColony;
import core.Bee;
import core.Ant;

public class ShortThrowerAnt extends Ant {
	protected int damage;

	/**
	 * Creates a new Thrower Ant.
	 * Armor: 1, Food: 0, Damage: 1
	 */
	public ShortThrowerAnt () {
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
		return place.getClosestBee(0, 2);
	}

	@Override
	public void action (AntColony colony) {
		Bee target = getTarget();
		if (target != null) {
			target.reduceArmor(damage);
		}
	}
}
