package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * @author Auriac Baptiste
 */

public class FireAnt extends Ant implements Damaging {
	private int damage=3;
	private boolean doubled = false;
	/**
	 * Creates a new Fire Ant
	 * 1 Armor and 4 foodCost
	 */
	public FireAnt() {
		super(1);
		foodCost = 4;
	}
	/**
	 * Make damage at the only moment as she die to allBee on that place
	 * So this reduceArmor overrides the classic one
	 * 
	 */
	
	@Override
	public void reduceArmor(int amount){
		this.armor -= amount;
		if (this.getArmor() <= 0) {
			for (Bee i : place.getBees()){
				i.reduceArmor(damage);
			}
		}
		System.out.println(this + " ran out of armor and expired");
		leavePlace();
	}
	
	/**
	 * Implements the buff
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
	 * This Ant wait to die so she does nothing
	 * 
	 */

	@Override
	public void action(AntColony colony) {
		// Rien car la fourmie reste passive avant sa mort
		
	}
	
}

