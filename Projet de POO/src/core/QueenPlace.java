package core;
import core.Place;
import java.util.ArrayList;

/**
 * @author CESARO Jordan
 */

public class QueenPlace extends Place {
	public Place positionActuelle;
	public QueenPlace(String name, Place exit){
		super(name,exit);
	}
	
	public QueenPlace(String name) {
		super(name);
	}
	
	public Bee[] getBees() {
		if  (positionActuelle != null) {
			ArrayList<Bee> allBeesOnQueen = this.bees;
			allBeesOnQueen.addAll(positionActuelle.bees);
			return allBeesOnQueen.toArray(new Bee[0]);
		}
		else {
			return this.bees.toArray(new Bee[0]);
		}
	}

}
