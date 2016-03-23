package ants;

import core.Ant;
import core.AntColony;

/**
 * An ant which tanks
 *
 */
public class WallAnt extends Ant {
	/**
	 * Creates a new Wall Ant.
	 * Armor: 4, Food: 4
	 */
	public WallAnt () {
		super(4);
		foodCost=4;
	}
	/**
	 * No action.
	 * 
	 */
	
	@Override
	public void action (AntColony colony) {
	}
}
