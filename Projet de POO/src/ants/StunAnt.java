package ants;
import core.Ant;
import core.Bee;
import core.AntColony;

/**
 * An Ant which can stun one turn a Bee
 * 
 */

public class StunAnt extends Ant {
	
	/**
	 * Create an ant which can stun a Bee
	 * 
	 * 1 Armor, and 6 foodCost.
	 */
	
	public StunAnt() {
		super(1);
		// TODO Auto-generated constructor stub
		super.foodCost = 6;
	}
	/**
	 * Return the closest bee in a range of 7
	 * 
	 * @return
	 * 			the closest bee in a range of 7
	 */
	
	
	public Bee getTarget () { //on cherche l'abeille la plus proche
		return place.getClosestBee(0, 7);
	}
	
	/**
	 * That stun ant can stun a bee each turn.
	 * 
	 */
	
	@Override
	public void action(AntColony colony) {
		// TODO Auto-generated method stub
		Bee target = getTarget();
		if (target != null) {
			target.setStun(); //on lui applique un slow (voir méthode setSlow de Bee
		}
		
	}

}
