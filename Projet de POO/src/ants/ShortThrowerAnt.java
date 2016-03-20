package ants;

import core.AntColony;
import core.Bee;
import core.Ant;

public class ShortThrowerAnt extends Ant  implements Damaging {
	protected int damage;
	private boolean doubled = false;

	/**
	 * @author CESARO Jordan
	 */
	
	public ShortThrowerAnt () {
		super(1);
		damage = 1;
		super.foodCost = 3;
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
