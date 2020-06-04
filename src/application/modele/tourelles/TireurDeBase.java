package application.modele.tourelles;

import java.util.ArrayList;
import application.modele.Environnement;
import application.modele.ennemis.Zombie;

public abstract class TireurDeBase extends Tourelle {

	public TireurDeBase(int x, int y, Environnement env, int degat, int vitesseAttack, int precision, int portee) {
		super(x, y, env, degat, vitesseAttack, precision, portee);
	}
	
	@Override
	public Zombie detecter(Environnement env) {
		ArrayList<Zombie> zombies = env.getListeZombies();
		for (Zombie zombie : zombies) {
			int posXZombie =  zombie.getXProperty().getValue();
			int posYZombie =  zombie.getYProperty().getValue();
			if(zombie.estEnVie() && posXZombie - this.getX() >= -this.getPortee() && posXZombie - this.getX() <= this.getPortee() && posYZombie - this.getY() >= -this.getPortee() && posYZombie - this.getY() <= this.getPortee()) {	
				return zombie;
			}
		}
		return null;
	}

	@Override
	public void agir() {
		Zombie target = this.detecter(this.getEnv());
		if (target != null) {
			if(this.tpsRechargement == 0) {
				this.attaquer(target);
				this.tpsRechargement = 5;
			}
			else {
				this.tpsRechargement -= 1;
			}
		}
	}

	@Override
	public void attaquer(Zombie target) {
		target.setPv(target.getPv() - this.getDegat());
	}
	
	public String toString() {
		return "Type Tourelle : " + this.getClass().getName() + super.toString();
	}
}
