package application.modele.ennemis;

import application.modele.Environnement;

public class Kamikaze extends Zombie{

	public Kamikaze(Environnement env) {
		super(env, 20, 1);
	}

	
	public void agit() {
		this.seDeplacer();
	}

}
