package application.modele.ennemis;

import application.modele.Environnement;

public class Kamikaze extends Zombie{

	public Kamikaze(Environnement env) {
		super(env);
		this.setPv(2);
		this.setVitesse(2);
	}

	
	public void agit() {
		this.seDeplacer();
	}

}
