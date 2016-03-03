 package ants;


import core.Ant;
import core.AntColony;
import java.util.Random;

/**
 * An Ant that harvests food
 *
 * @author Auriac Baptiste
 */
public class HarvesterAnt extends Ant {

	/**
	 * Creates a new Harvester Ant
	 */
	public HarvesterAnt () {
		super(1);
		foodCost=50;
	}

	//initialisation des variables pour gérer le temps d'attente aléatoire 
	int i=0;
	Random rand = new Random(); 
	int waitTurn = 1+rand.nextInt(2); //nextInt(2) donne une valeur entre 0 et 2
	@Override
	public void action (AntColony colony) {
		// TODO: Should produce one additional food for the colony
		
		//Pour un jeu plus équilibré, le temps de moisson sera entre 1 et 3 tours aléatoirement 
		if(i<waitTurn){  //le nombre de tours de moisson est de waitTurn+1
			i++;
		}
		else{
		colony.increaseFood(50);
		i=0;
		waitTurn = 1+rand.nextInt(2);
		}
	}
}
