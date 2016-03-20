package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

public class ScubaThrowerAnt extends Ant implements Damaging {
	
	protected int damage=1;
	private boolean doubled = false;
	
	/**
	 * Creates a new Harvester Ant
	 */
	
	public ScubaThrowerAnt () {
		super(1);
		foodCost=5;
		waterSafe=true;
		
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
