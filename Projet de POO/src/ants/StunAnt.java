package ants;
import core.Ant;
import core.Bee;
import core.AntColony;

public class StunAnt extends Ant {
	public StunAnt(int armor) {
		super(armor);
		// TODO Auto-generated constructor stub
		foodCost = 6;
	}
		
	public Bee getTarget () { //on cherche l'abeille la plus proche
		return place.getClosestBee(0, 7);
	}
	@Override
	public void action(AntColony colony) {
		// TODO Auto-generated method stub
		Bee target = getTarget();
		if (target != null) {
			target.setStun(); //on lui applique un slow (voir méthode setSlow de Bee
		}
	}

}
