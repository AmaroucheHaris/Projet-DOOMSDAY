package application.modele.ennemis;

import java.util.Random;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import application.modele.Environnement;

public class ZombieMilitaire extends Zombie{

	private int probaAbsorbe;
	
	public ZombieMilitaire(Environnement env) {

		super(env, 30, 1);
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + super.toString() + "probaAbsorbe = " + this.probaAbsorbe; 
	}

	public boolean tirAbsorbe() {
		Random rand = new Random();
		int nbRandom = rand.nextInt(101);
		
		if(nbRandom <= this.probaAbsorbe) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public void agit() {
		this.seDeplacer();
	}
	
	

	
}
