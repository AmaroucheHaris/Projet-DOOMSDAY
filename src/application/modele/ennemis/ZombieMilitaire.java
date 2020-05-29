package application.modele.ennemis;

import application.modele.Environnement;

public class ZombieMilitaire extends Zombie{

	private int probaAbsorbe;
	
	public ZombieMilitaire(Environnement env) {
		super(env);
		this.setVitesse(3);
		this.probaAbsorbe = 20;
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + super.toString() + "probaAbsorbe = " + this.probaAbsorbe; 
	}

	
}
