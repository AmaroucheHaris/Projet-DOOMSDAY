package application.modele.ennemis;

import application.modele.Environnement;

public class Sprinteur extends Zombie{

	public Sprinteur(Environnement env) {
		super(env);
		this.setPv(15);
		this.setVitesse(1);
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + super.toString(); 
	}

}
