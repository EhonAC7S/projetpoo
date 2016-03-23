package core;

/**
 * A special Place of Water
 * 
 */

public class Water extends Place {
	
	Water(String name, Place exit){
		super(name,exit);
	}
	
	Water(String name) {
		super(name, null);
	}
	
	
}
