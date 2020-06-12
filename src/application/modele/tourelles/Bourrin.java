package application.modele.tourelles;

import java.util.ArrayList;
import java.util.Random;

import application.modele.Environnement;
import application.modele.ennemis.Blesses;
import application.modele.ennemis.Zombie;
import application.modele.ennemis.ZombieMilitaire;

public class Bourrin extends Tourelle {

	public Bourrin(int x, int y, Environnement env) {
		super(x, y, env, 100, 176, 30, 100);
	}

	@Override
	public Zombie detecter(Environnement env) {
		ArrayList<Zombie> zombies = env.getListeZombies();
		for (Zombie zombie : zombies) {
				int differenceXZombieTourelle = zombie.getXProperty().getValue() - this.getX();
				int differenceYZombieTourelle = zombie.getYProperty().getValue() - this.getY();
				int distance = (int) Math.sqrt((differenceXZombieTourelle * differenceXZombieTourelle) + (differenceYZombieTourelle * differenceYZombieTourelle));
				
				if((zombie.estEnVie() && distance <= this.getPortee())) {	
					return zombie;
			}
		}
		return null;
	}

	@Override
	public void agir() {
		Zombie target = this.detecter(this.getEnv());
		Random rand = new Random();
		if (target != null) {
			if(this.tpsRechargement == 0) {
				int luckHit = rand.nextInt(3);
				if(luckHit==0) {
					this.attaquer(target);
					this.tpsRechargement = this.getVitesseAttack();
				}
			}
			else {
				this.tpsRechargement -= 1;
			}
		}
	}

	@Override
	public void attaquer(Zombie target) {
		if(target instanceof ZombieMilitaire) {
			boolean tirAbsorbe = ((ZombieMilitaire) target).tirAbsorbe();
			if(!tirAbsorbe) {
				target.setPv(target.getPv() - this.getDegat());
			}
		}
		else {
			target.setPv(target.getPv() - this.getDegat());
		}
	}
	
	public String toString() {
		return "Type Tourelle : " + this.getClass().getName() + super.toString();
	}
}
