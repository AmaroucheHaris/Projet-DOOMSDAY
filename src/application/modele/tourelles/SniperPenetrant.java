package application.modele.tourelles;

import java.util.ArrayList;

import application.modele.Environnement;
import application.modele.ennemis.Zombie;

public class SniperPenetrant extends Tourelle {

	public SniperPenetrant(int x, int y, Environnement env) {
		super(x, y, env, 10, 10, 10, 20);
	}

	@Override
	public ArrayList<Zombie> detecter(Environnement env) {
		ArrayList<Zombie> zombies = env.getListeZombies();
		ArrayList<Zombie> targets = new ArrayList<Zombie>();
		for (Zombie zombie : zombies) {
			int posXZombie =  zombie.getXProperty().getValue();
			int posYZombie =  zombie.getYProperty().getValue();
			if(zombie.estEnVie() && posXZombie - this.getX() >= -this.getPortee() && posXZombie - this.getX() <= this.getPortee() && posYZombie - this.getY() >= -this.getPortee() && posYZombie - this.getY() <= this.getPortee()) {	
				targets.add(zombie);
				
				return targets;
			}
		}
		return null;
	}

	@Override
	public void agir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void attaquer(Zombie target) {
		// TODO Auto-generated method stub

	}

}
