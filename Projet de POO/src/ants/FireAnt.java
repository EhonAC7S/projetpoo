package ants;

import core.Ant;
import core.AntColony;

/**
 * An Ant that burn everything!!!
 *
 * @author Auriac Baptiste
 */
public class FireAnt extends Ant {

	/**
	 * Creates a new Fire Ant
	 */
	public FireAnt() {
		super(1);
		foodCost = 4;
	}

	@Override
	public void reduceArmor(int amount, AntColony colony){
		this.armor -= amount;
		
		if (this.getArmor() <= 0) {
			System.out.println("1");
			for (int i = 0; i < colony.getAllBees().size(); i++) {
				if (this.place == colony.getAllBees().get(i).getPlace()) {
					System.out.println(i);
					colony.getAllBees().get(i).reduceArmor(3);
				}
			}
			System.out.println(this + " ran out of armor and expired");
			leavePlace();
		}
		
	}

	@Override
	public void action(AntColony colony) {
		// Rien car la fourmie reste passive avant sa mort
		
	}
	
}

