package application.modele.ennemis;

import application.modele.Environnement;

public class Majin extends Zombie{

	private double seuil;
	
	public Majin(Environnement env) {
		super(env);
		this.seuil = 5; //A changer
		
	}

}
