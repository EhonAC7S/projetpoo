package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * An ant which 
 *
 * 
 */

public class HungryAnt extends Ant implements Damaging {
	int counter = 0;
	private int damage; //damage that it deals when it eats 
	private boolean doubled = false;

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

	/**
	 * Set the Buff of Double Damage
	 * 
	 */
	
	public void doubleDamage() {
		damage = 2*damage;
	}
	/**
	 * A setter of the Boolean to tell if there is a Buff
	 * 
	 */
	
	public void setDoubled() {
		this.doubled = true;
	}
	
	/**
	 * Getter if there is a buff
	 * 
	 */
	
	public boolean getIfDoubled() {
		return this.doubled;
	}
	
	/**
	 * Action of the AngryAnt : Eat a Bee every 3 turns.
	 * 
	 */
	@Override
	public void action(AntColony colony) {
		if (counter == 0) {
			Bee target = getTarget();
			counter = 3;
			if (target != null) {
				target.reduceArmor(target.getArmor());
				
			} else {
				counter = 0;
			}

		} else {
			counter -= 1;
		}
	}
}