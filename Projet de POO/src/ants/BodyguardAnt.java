package ants;
import core.*;

/**
 * Class BodyGuard which provides Armor to a Bee
 * 
 */

public class BodyguardAnt extends Ant implements Containing {
	
	private Ant antContained = null; //Contained Ant
	
	/**
	 * Create an BodyGuard that provides 2 Armor
	 * 
	 */
	
	public BodyguardAnt() {
		super(2);
		foodCost = 5;
		// TODO Auto-generated constructor stub
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
	
	/**
	 * The BodyGuard doesn't make action
	 * 
	 */
	
	@Override
	public void action(AntColony colony) {
		// TODO Auto-generated method stub
		//La fourmie bodyguard ne fait rien à part 
	}
}
