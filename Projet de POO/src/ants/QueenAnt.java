package ants;

import core.Ant;
import core.AntColony;
import core.Bee;

/**
 * Create a queenAnt which double damage of the nearby ant
 * 
 *
 */


public class QueenAnt extends Ant{

	private int damage = 1;
	 /**
	  * THE Queen Ant that have 6 foodCost, is Watersafe, and have 1 Armor.
	  */
	public QueenAnt() {
		super(1);
		foodCost=6;
		waterSafe=true;
	}
	
	/**
	 * get closest Bee in a range of 6
	 * 
	 * @return a Bee
	 */
	
	public Bee getTarget () {
		return place.getClosestBee(0, 6);
	}
	
	/**
	 * Set the actual queen position each turn to be sure she is on that place;
	 * Double the damage of the behind ant;
	 * Double the damage of the front ant;
	 * She shots the nearest Bee too
	 */

	@Override
	public void action(AntColony colony) {//une case derrière doit exister sinon on ne fait pas l'action suivante
		AntColony.placeDeLaReine.setActualPos(this.getPlace());
		if (this.getPlace().getExit()!=null) {
			if (this.getPlace().getExit().getAnt() instanceof Damaging && this.getPlace().getExit().getAnt() != null) {  //on regarde si la fourmi derrière est du type Damaging (fait des dégats)
				if (!(((Damaging) this.getPlace().getExit().getAnt()).getIfDoubled())) { //Alors on regarde si ses dégats ont déjà été doublés avant
					((Damaging) this.getPlace().getExit().getAnt()).setDoubled(); //si ce n'est pas le cas, on double ses domages et on indique qu'elle a les dommages doublés
					((Damaging) this.getPlace().getExit().getAnt()).doubleDamage();
				}
			}
		}
		if (this.getPlace().getEntrance()!=null) {//une case devant doit exister sinon on ne fait pas l'action suivante
			if (this.getPlace().getEntrance().getAnt() instanceof Damaging && this.getPlace().getEntrance().getAnt() != null) { //Même fonctionnement mais pour celle de devant.
				if (!(((Damaging) this.getPlace().getEntrance().getAnt()).getIfDoubled())) {
					((Damaging) this.getPlace().getEntrance().getAnt()).setDoubled();
					((Damaging) this.getPlace().getEntrance().getAnt()).doubleDamage();
				}
			}
		}
		Bee target = getTarget();
		if (target != null) {
			target.reduceArmor(damage);
		}
		
	}
	
	

}
