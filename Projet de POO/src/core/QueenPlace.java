package core;
import core.Place;
import java.util.ArrayList;

/**
 * A specific place for the Queen Ant
 */

public class QueenPlace extends Place {
	private Place positionActuelle;
	
	/** 
	 * Make a QueenPlace
	 * @param name 
	 *             the queen place have only a name : Queen_Place
	 *
	 */
	
	public QueenPlace(String name) {
		super(name);
	}
	/**
	 * a getter of the position of the queen on the field
	 * 
	 * @return the queen actual position
	 */
	
	public Place getQueenActualPos() {
		return positionActuelle;
	}
	/**
	 * Set the position of the queen Ant on the field
	 * 
	 * @param p 
	 * 			the queen place on the field
	 */
	
	public void setActualPos(Place p) {
		positionActuelle = p;
	}
	
	/**
	 * Get all the Bees on the places of the queen, it merge the ones on the place of the queen on the field and the bees in the queen house.
	 * 
	 *  @return An arraylist of bees
	 */
	
	@Override
	public Bee[] getBees() {
		if  (positionActuelle != null) { //pour gérer les bugs dû aux nullpointerexceptions car un null n'a pas d'argument bees, contrairement à une place.
			ArrayList<Bee> allBeesOnQueen = this.bees;
			allBeesOnQueen.addAll(positionActuelle.bees); //on fusionne les bees sur les deux places.
			return allBeesOnQueen.toArray(new Bee[0]);
		}
		else {
			return this.bees.toArray(new Bee[0]);
		}
	}

}
