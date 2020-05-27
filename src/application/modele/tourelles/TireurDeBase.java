package application.modele.tourelles;

import java.util.ArrayList;
import application.modele.Environnement;
import application.modele.ennemis.Zombie;

public class TireurDeBase extends Tourelle {

	public TireurDeBase(int x, int y, Environnement env, int degat, int vitesseAttack, int precision, int portee) {
		super(x, y, env, degat, vitesseAttack, precision, portee);
	}
	
	public String toString() {
		return "Type Tourelle : " + this.getClass().getName() + super.toString();
	}

	@Override
	public Zombie detecter(Environnement env) {
		ArrayList<Zombie> zombies = env.getListeZombies();
		for (Zombie zombie : zombies) {
			System.out.println("résultat x = " + (zombie.getXProperty().getValue() - this.getX()));
			System.out.println("résultat y =" + (zombie.getYProperty().getValue() - this.getY()));
			if(zombie.getXProperty().getValue() - this.getX() >= -this.getPortee() && zombie.getXProperty().getValue() - this.getX() <= this.getPortee() && zombie.getYProperty().getValue() - this.getY() >= -this.getPortee() && zombie.getYProperty().getValue() - this.getY() <= this.getPortee()) {	
				return zombie;
			}
		}
		return null;
	}

	@Override
	public void agir() {
		if (detecter(this.getEnv()) != null) {
			
		}
	}

}
