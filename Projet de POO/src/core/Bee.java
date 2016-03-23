package core;

/**
 * Represents a Bee
 *
 * 
 */
public class Bee extends Insect {

	private static final int DAMAGE = 1;
	private boolean slowed = false; //Boolean qui indique si la Bee est slow
	private int turnOfSlow = 0; //nombre de tours de blocage que la Bee subie avant d'avancer.
	private boolean stun = false;//Boolean qui indique si la Bee est stun
	/**
	 * Creates a new bee with the given armor
	 *
	 * @param armor
	 *            The bee's armor
	 */
	public Bee(int armor) {
		super(armor);
		waterSafe = true;
	}

	/**
	 * Deals damage to the given ant
	 *
	 * @param ant
	 *            The ant to sting
	 */
	public void sting(Ant ant) {
		ant.reduceArmor(DAMAGE);
	}

	/**
	 * Moves to the given place
	 *
	 * @param place
	 *            The place to move to
	 */
	public void moveTo(Place place) {
		this.place.removeInsect(this);
		place.addInsect(this);
	}

	@Override
	public void leavePlace() {
		place.removeInsect(this);
	}

	/**
	 * Returns true if the bee cannot advance (because an ant is in the way)
	 *
	 * @return if the bee can advance
	 */
	public boolean isBlocked() {
		if (place.getAnt() != null) { // new //S'il y a une fourmi sur la même
										// case que l'abeille
			return place.getAnt().blockTheWay; // alors on regarde si cette
												// fourmi bloque le passage ou
												// si elle est 'invisible'
		} else {
			return false; // sinon le passage est libre : l'abeille se déplace
							// librement.
		}
	}
	/**
	 * Mettre un slow sur l'abeille
	 * 
	 * @param slowTurn
	 * 					Nombre de tour de slow prévu
	 */				
	public void setSlow(int slowTurn) { //si l'abeille subit un ralentissement ce tour, on lui donner l'effet slow et le nombre de tour avant de perdre le ralentissement, elle ne peut être slow si elle l'est déjà. (équilibrage)
		if (!slowed) {
			slowed = true;
			turnOfSlow = slowTurn;
		}
	}
	/**method to know if the bee is slow
	 * 
	 * @return if the bee is slow
	 */
	
	public boolean getSlow() { //renvoie si l'abeille est slow
		return slowed;
	}
	
	/**
	 * Control on the Bee
	 * Unslow the bee if she don't have to be slow.
	 *  
	 */
	
	public void unSlow() { //on enleve le ralentissement si le temps de slow est nul
		if (turnOfSlow == 0) {
			slowed = false;
		}
	}
	
	/**
	 * Control on the Bee
	 * Reduce the slow of one turn.
	 */
	
	public void reduceSlow() { //méthode simple de réduction du temps de slow (implementation possible de perdre un tour de slow pas seulement par la methode action amsi aussi par un bonus d'abeille ou une fourmie de feu ou même imagions une abeille boss enlevant du côntrole à son arrivée.
		if (turnOfSlow >= 1) {
			turnOfSlow = turnOfSlow - 1;
		}
	}
	/**
	 * Control on the Bee
	 * Set active the stun of the bee
	 */
	
	public void setStun() {
		this.stun = true;
	}
	/**
	 * Control on the Bee
	 * Unstun the bee
	 */
	
	public void unStun() {
		this.stun = false;
	}

	/**
	 * A bee's action is to sting the Ant that blocks its exit if it is blocked,
	 * otherwise it moves to the exit of its current place. It takes in count the control that
	 * are on this Bee (slow + stun).
	 */
	@Override
	public void action(AntColony colony) {
		if (this.getSlow()) { //si l'abeille est slow, elle perd un tour de slow
			this.reduceSlow(); 
			this.unSlow();		//on vérifie si le nombre de tour de slow est à 0, ainsi l'abeille peut poursuivre son avancement
		}
		if (this.armor > 0 && !this.stun) { // Rajout pour eviter le bug trouvé avec la
								// fireAnt et d'une condition sur son état stun pour pouvoir effctuer des action ce tour
			if (isBlocked()) {  //On considère que le ralentissement n'influe pas sur la capacité à attaquer mais seulement à se déplacer. Autrement le slow de 2 tour serait plus fort que le stun de 1 tour.
				sting(place.getAnt());
			} else if (armor > 0 && !(this.getSlow())) { //pour qu'elle puisse avancer, elle ne doit plus être ralentie
				moveTo(place.getExit());
			}
		}
		if (this.stun) { //si l'abeille était stun ce tour, elle perd son état stun à la fin de son tour.
			this.unStun();
		}
	}
}
