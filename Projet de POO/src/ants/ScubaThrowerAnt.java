package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class ScubaThrowerAnt extends Ant {
	
	protected int damage=1;
	
	/**
	 * Creates a new Harvester Ant
	 */
	public ScubaThrowerAnt () {
		super(1);
		foodCost=5;
		waterSafe=true;
		
	}
	
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
