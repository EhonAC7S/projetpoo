package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * Create an NinjaAnt 
 */

public class NinjaAnt extends Ant  implements Damaging {
	private int damage;
	private boolean doubled = false;
	
	/**
	 * A Ninja Ant with 
	 * 
	 * Damage : 1, foodCost : 6, Don't Block the way
	 */
	
	public NinjaAnt() {
		super(1);
		blockTheWay = false;
		damage = 1;
		foodCost = 6;
	}
	/**
	 * Set the buff
	 * 
	 */
	
	public void doubleDamage() {
		damage = 2*damage;
	}
	/**
	 * A Setter of the buff
	 * 
	 */
	public void setDoubled() {
		this.doubled = true;
	}
	/**
	 * A getter of the buff
	 * 
	 */
	
	public boolean getIfDoubled() {
		return this.doubled;
	}
	
	/**
	 * Action made : do damage to all Bees here.
	 * 
	 */
	
	@Override
	public void action(AntColony colony) {
		for (Bee i : place.getBees()){ //On prend toutes les abeilles à cette place
			i.reduceArmor(damage); 
		}
	}
	
	

}
