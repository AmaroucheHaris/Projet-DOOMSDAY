package application.modele.ennemis;

import application.modele.Environnement;

public class ZombieDeTroie extends Zombie{

	public ZombieDeTroie(Environnement env) {
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
