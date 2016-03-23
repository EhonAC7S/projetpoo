package ants;


/**
 * Interface Damaging for the Ant which have damage to allow a Double Damage Buff
 * 
 * @author CESARO Jordan
 */

public interface Damaging {

	public void doubleDamage();
	public boolean getIfDoubled();
	public void setDoubled();
}
