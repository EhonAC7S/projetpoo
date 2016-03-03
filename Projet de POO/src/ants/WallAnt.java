package ants;

import core.Ant;
import core.AntColony;

/**
 * An ant who throws leaves at bees
 *
 * @author Auriac
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
	
	@Override
	public void action (AntColony colony) {
	}
}
