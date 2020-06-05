package application.modele.ennemis;

import application.modele.Environnement;

public class Tank extends Zombie{

	public Tank(Environnement env) {
		super(env);
		this.setPv(30);
		this.setVitesse(2);
	}
	public String toString() {
		return this.getClass().getSimpleName() + super.toString(); 
	}
	
	public void agit() {
		this.seDeplacer();
	}
}
