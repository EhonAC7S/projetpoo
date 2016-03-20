package ants;

import core.Ant;
import core.AntColony;

public class QueenAnt extends Ant{

	public QueenAnt() {
		super(1);
		foodCost=6;
		waterSafe=true;
		noQueen+=1;
		System.out.println(noQueen);
	}

	@Override
	public void action(AntColony colony) {

		
	}
	
	

}
