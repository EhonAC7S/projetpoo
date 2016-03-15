package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant who throws leaves at bees
 *
 * @author Auriac
 */
public class HungryAnt extends Ant {

	protected int damage;

	/**
	 * Creates a new Hungry Ant. Armor: 1, Food: 4
	 */
	public HungryAnt() {
		super(1);
		foodCost = 4;
	}

	/**
	 * Returns a target for this ant
	 *
	 * @return A bee to target
	 */
	public Bee getTarget() {
		return place.getClosestBee(0, 0);
	}

	// initialisation d'un compteur pour gérer le temps d'attente
	int counter = 0;

	@Override
	public void action(AntColony colony) {
		if (counter == 0) {
			Bee target = getTarget();
			counter = 3;
			if (target != null) {
				target.reduceArmor(target.getArmor(),null);
			} else {
				counter = 0;
			}

		} else {
			counter -= 1;
		}
	}
}