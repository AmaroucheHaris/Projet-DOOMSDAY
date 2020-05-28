package application.modele.ennemis;

import application.modele.Environnement;

public class Blesses extends Zombie{
	
	boolean estDetecter;

	public Blesses(int x, int y, Environnement env) {
		super(x, y, env);
		this.setPv(5);
		this.setVitesse(3);
		this.estDetecter = false;
		
	}

}
