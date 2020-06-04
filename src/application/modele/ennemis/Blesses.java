package application.modele.ennemis;

import application.modele.Environnement;

public class Blesses extends Zombie{
	
	boolean estDetecter;

	public Blesses(Environnement env) {
		super(env);
		this.setPv(5);
		this.setVitesse(3);
		this.estDetecter = false;
		
	}

	
	public void agit() {
		this.seDeplacer();
	}


	public boolean isEstDetecter() {
		return estDetecter;
	}


	public void setEstDetecter(boolean estDetecter) {
		this.estDetecter = estDetecter;
	}

}
