package ants;
import core.*;

public class BodyguardAnt extends Ant implements Containing {
	
	private Ant antContained = null;
	public BodyguardAnt() {
		super(2);
		foodCost = 5;
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public void SupprAnt() {
		// TODO Auto-generated method stub
		this.antContained = null;
	}

	@Override
	public Ant getAnt() {
		// TODO Auto-generated method stub
		return this.antContained;
	}

	@Override
	public void action(AntColony colony) {
		// TODO Auto-generated method stub
		//La fourmie bodyguard ne fait rien à part 
	}
	
	
	
	
	
}
