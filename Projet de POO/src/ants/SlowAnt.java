package ants;

import core.AntColony;
import core.Bee;
import core.Ant;

/**
 * @author CESARO Jordan
 */

public class SlowAnt extends Ant {

	protected int slowTime;

	public SlowAnt() {
		super(1);
		// TODO Auto-generated constructor stub
		foodCost = 4;
		this.slowTime = 3; //pose le temps de slow appliqué, étant donné que le slow est réduit le tour même, il s'agit d'un slow réel de 2 tours. 
	}
	
	public Bee getTarget () { //on cherche l'abeille la plus proche
		return place.getClosestBee(0, 7);
	}

	@Override
	public void action(AntColony colony) {
		// TODO Auto-generated method stub
		Bee target = getTarget();
		if (target != null) {
			target.setSlow(this.slowTime); //on lui applique un slow (voir méthode setSlow de Bee
		}
		
	}
}
