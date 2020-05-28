package application.modele.ennemis;

import application.modele.Environnement;

public class Tank extends Zombie{

	public Tank(int x, int y, Environnement env) {
		super(x, y, env);
		this.setPv(30);
		this.setVitesse(2);
	}
	public String toString() {
		return this.getClass().getSimpleName() + super.toString(); 
	}
}
