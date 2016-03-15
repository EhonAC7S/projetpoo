package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at bees
 *
 * @author CESARO
 */
public class ThrowerAnt extends Ant {

	protected int damage;

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
			target.reduceArmor(damage,null);
		}
	}
}
