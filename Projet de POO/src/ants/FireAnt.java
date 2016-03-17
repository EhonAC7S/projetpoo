package ants;

import core.Ant;
import core.AntColony;
import core.Bee;


/**
 * @author Auriac Baptiste
 */
public class FireAnt extends Ant {
	private int damage=3;
	/**
	 * Creates a new Fire Ant
	 */
	public FireAnt() {
		super(1);
		foodCost = 4;
	}
	
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
		

	@Override
	public void action(AntColony colony) {
		// Rien car la fourmie reste passive avant sa mort
		
	}
	
}

