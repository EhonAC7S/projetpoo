package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * @author CESARO Jordan
 */

public class NinjaAnt extends Ant  implements Damaging {
	private int damage;
	private boolean doubled = false;
	public NinjaAnt() {
		super(1);
		blockTheWay = false;
		damage = 1;
		foodCost = 6;
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
	public void action(AntColony colony) {
		for (Bee i : place.getBees()){
			i.reduceArmor(damage);
		}
	}
	
	

}
