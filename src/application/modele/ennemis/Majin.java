package application.modele.ennemis;

import application.modele.Environnement;

public class Majin extends Zombie{

	private double seuil;
	
	public Majin(int x, int y, Environnement env) {
		super(x, y, env);
		this.seuil = 5; //A changer
		
	}

}
