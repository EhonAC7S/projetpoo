package ants;

import core.Ant;
import core.AntColony;
import core.Bee;



public class NinjaAnt extends Ant {
	private int damage;
	public NinjaAnt() {
		super(1);
		blockTheWay = false;
		damage = 1;
		foodCost = 0;
	}
	
	@Override
	public void action(AntColony colony) {
		for (Bee i : place.getBees()){
			i.reduceArmor(damage);
		}
	}
	
	

}
