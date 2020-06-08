package application.modele.ennemis;

import application.modele.Environnement;

public class ZombieDeTroie extends Zombie{

	public ZombieDeTroie(Environnement env) {
		super(env, 30, 2);
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + super.toString();
	}

	public void agit() {
		this.seDeplacer();		
	}

}
