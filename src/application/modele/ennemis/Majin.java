package application.modele.ennemis;

import application.modele.Environnement;

public class Majin extends Zombie{

	private int cycle;
	private double pvMax;

	public Majin(Environnement env) {
		super(env, 10, 10);
		this.cycle = 0;
		this.pvMax = this.getPv();
		this.setVitesse(1);
	}

	
	public void seSoigner() {
		
		if(this.getPv() < this.pvMax) {
			if(this.cycle == 10) {
				this.setPv(this.getPv()+1);
				this.cycle = 0;
			}
			else {
				this.cycle++;
			}
		}
	}
	
	public void agit() {
		this.seSoigner();
		this.seDeplacer();
	}
	
	

}
