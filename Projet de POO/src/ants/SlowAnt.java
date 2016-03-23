package ants;

import core.AntColony;
import core.Bee;
import core.Ant;

/** 
 * Create a Ant which can slow the enemy Bee
 * 
 */

public class SlowAnt extends Ant {

	private int slowTime;
	
	/**
	 * classic slow ant with 1 armor, 4 foodCost, and a slow time of 3 turns
	 */
	public SlowAnt() {
		super(1);
		// TODO Auto-generated constructor stub
		foodCost = 4;
		this.slowTime = 3; //pose le temps de slow appliqué, étant donné que le slow est réduit le tour même, il s'agit d'un slow réel de 2 tours. 
	}
	
	/**
	 * Method to get the closest target.
	 * @return the closest bee in a range of 7 
	 */
	
	public Bee getTarget () { //on cherche l'abeille la plus proche
		return place.getClosestBee(0, 7);
	}
	
	/**
	 * Shot a slow bullet to the nearest Bee.
	 * 
	 * 
	 */

	@Override
	public void action(AntColony colony) {
		// TODO Auto-generated method stub
		Bee target = getTarget();
		if (target != null) {
			target.setSlow(this.slowTime); //on lui applique un slow (voir méthode setSlow de Bee)
		}
		
	}
}
