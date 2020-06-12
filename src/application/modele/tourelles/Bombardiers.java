package application.modele.tourelles;

import java.util.ArrayList;

import application.modele.Environnement;
import application.modele.ennemis.Zombie;

public abstract class Bombardiers extends Tourelle {

	
	private static int porteeLimite = 96;
	private static int porteeDegatZone = 64;
	public Bombardiers(int x, int y, Environnement env, int degat, int vitesseAttack, int portee, int valeurAchat) {
		super(x, y, env, degat, vitesseAttack, portee, valeurAchat);
	}

	@Override
	public Zombie detecter(Environnement env) {
		ArrayList<Zombie> zombies = env.getListeZombies();
		for (Zombie zombie : zombies) {
			int posXZombie =  zombie.getXProperty().getValue();
			int posYZombie =  zombie.getYProperty().getValue();
			if(zombie.estEnVie() && this.detecterAxeX(posXZombie) && this.detecterAxeY(posYZombie)) {	
				System.out.println("Zombie détécté");
				return zombie;
			}
		}
		return null;
	}

	public ArrayList<Zombie> degatsZone(Environnement env) {
		//version1
		ArrayList<Zombie> zombies = env.getListeZombies();
		ArrayList<Zombie> targets = new ArrayList<Zombie>();
		Zombie z = this.detecter(env);
		if (z != null) {
			targets.add(z);
			int posXFirstTarget = z.getXProperty().getValue();
			int posYFirstTarget = z.getYProperty().getValue();
			for (Zombie zombie : zombies) {
				if (zombie != z) {
					System.out.println("Zombie 1:" + z);
					System.out.println("Zombie 2:" + zombie);
					int posXSecondTarget = zombie.getXProperty().getValue();
					int posYSecondTarget = zombie.getYProperty().getValue();				
					if(zombie.estEnVie() && posXSecondTarget - posXFirstTarget >= -porteeDegatZone && posXSecondTarget - posXFirstTarget <= porteeDegatZone && posYSecondTarget - posYFirstTarget >= -porteeDegatZone && posYSecondTarget - posYFirstTarget <= porteeDegatZone) {	
						System.out.println("allah wakbar");
						targets.add(zombie);
						
					}
				}
			}
			return targets;
		}
		return null;
	}
	
	@Override
	public void agir() {
		ArrayList<Zombie> targets = this.degatsZone(getEnv());
		if (targets != null) {
			if(this.tpsRechargement == 0) {
				for (Zombie zombie : targets) {	
					this.attaquer(zombie);
					this.tpsRechargement = this.getVitesseAttack();
				}
			}
			else {
				this.tpsRechargement -= 1;
			}	
		}
	}
	
	public abstract void attaquer(Zombie target);

	public boolean detecterAxeX(int posXZombie) {
		System.out.println("résultat =  " + (posXZombie - this.getX()));
		System.out.println("cas gauche max: " + (posXZombie - this.getX() >= -this.getPortee()));
		System.out.println("cas gauche sécurité: " + (posXZombie - this.getX() <= -porteeLimite));
		System.out.println("cas droit max: " + (posXZombie - this.getX() <= this.getPortee()));
		System.out.println("cas droit sécurité: " + (posXZombie - this.getX() >= porteeLimite));
		return posXZombie - this.getX() >= -this.getPortee() && posXZombie - this.getX() <= -porteeLimite && posXZombie - this.getX() <= this.getPortee() && posXZombie - this.getX() >= porteeLimite;
	}
	
	public boolean detecterAxeY(int posYZombie) {
		System.out.println("résultat =  " + (posYZombie - this.getY()));
		System.out.println("cas haut max: " + (posYZombie - this.getY() >= -this.getPortee()));
		System.out.println("cas haut sécurité: " + (posYZombie - this.getY() <= -porteeLimite));
		System.out.println("cas bas max: " + (posYZombie - this.getY() <= this.getPortee()));
		System.out.println("cas bas sécurité: " + (posYZombie - this.getY() >= porteeLimite));
		return posYZombie - this.getY() >= -this.getPortee() && posYZombie - this.getY() <= -porteeLimite && posYZombie - this.getY() <= this.getPortee() && posYZombie - this.getY() >= porteeLimite;
	}
	
	
}
