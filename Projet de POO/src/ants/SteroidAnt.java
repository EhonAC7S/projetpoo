package ants;

import core.Ant;
import core.AntColony;

/**
 * Not really ant Ant, Just a steroid
 *
 */

public class SteroidAnt extends Ant implements Containing {
	
	private Ant antContained = null; //Contained Ant
	/**
	 * Create a Steroid
	 * 
	 */
	public SteroidAnt() {
		super(1);
		foodCost = 1;
	}
	/**
	 * Add an ant to this Container BodyGuard only if there no inside.
	 * 
	 */
	
	
	@Override
	public void addAnt(Ant ant) {
		// TODO Auto-generated method stub
		if (this.antContained == null) {
			this.antContained = ant;
			System.out.println("Ajouté avec succès");
			}
			else {
				System.out.println("Une Fourmie est déjà dans cette Containing");
		}
	}
	/**
	 * Suppr the ContainedAnt
	 * 
	 * 
	 */

	@Override
	public void SupprAnt() {
		// TODO Auto-generated method stub
		this.antContained = null;
	}
	/**
	 * Get the ContainedAnt.
	 * 
	 */

	@Override
	public Ant getAnt() {
		// TODO Auto-generated method stub
		return this.antContained;
	}
	
	public void action(AntColony colony) {
		// TODO Auto-generated method stub
		//Cette fourmie ne fait rien mais donne un boost instantané
	}
	
	
}
