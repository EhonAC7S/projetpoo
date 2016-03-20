package ants;

import core.Ant;
import core.AntColony;
import core.Bee;



public class QueenAnt extends Ant{

	private int damage = 1;
	
	public QueenAnt() {
		super(1);
		foodCost=6;
		waterSafe=true;
		noQueen+=1;
		System.out.println(noQueen);
	}
	
	public Bee getTarget () {
		return place.getClosestBee(0, 6);
	}

	@Override
	public void action(AntColony colony) {
		AntColony.placeDeLaReine.positionActuelle = this.getPlace();
		if (this.getPlace().getExit().getAnt() instanceof Damaging && this.getPlace().getExit().getAnt() != null) {  //on regarde si la fourmi derrière est du type Damaging (fait des dégats)
			if (!(((Damaging) this.getPlace().getExit().getAnt()).getIfDoubled())) { //Alors on regarde si ses dégats ont déjà été doublés avant
				((Damaging) this.getPlace().getExit().getAnt()).setDoubled(); //si ce n'est pas le cas, on double ses domages et on indique qu'elle a les dommages doublés
				((Damaging) this.getPlace().getExit().getAnt()).doubleDamage();
			}
		}
		if (this.getPlace().getEntrance().getAnt() instanceof Damaging && this.getPlace().getEntrance().getAnt() != null) { //Même fonctionnement mais pour celle de devant.
			if (!(((Damaging) this.getPlace().getEntrance().getAnt()).getIfDoubled())) {
				((Damaging) this.getPlace().getEntrance().getAnt()).setDoubled();
				((Damaging) this.getPlace().getEntrance().getAnt()).doubleDamage();
			}
		}
		Bee target = getTarget();
		if (target != null) {
			target.reduceArmor(damage);
		}
		
	}
	
	

}
