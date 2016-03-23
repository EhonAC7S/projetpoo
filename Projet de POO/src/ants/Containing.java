package ants;
import core.Ant;

/**
 * The Interface Containing with the specific function of the Ant which can contain Ant
 */

public interface Containing {
	
	public void addAnt(Ant ant);
	public void SupprAnt();
	public Ant getAnt();
	
}
