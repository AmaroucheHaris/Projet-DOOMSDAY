package application.modele;

public class Kamikaze extends Zombie{

	public Kamikaze(int x, int y, Environnement env) {
		super(x, y, env);
		this.setPv(2);
		this.setVitesse(2);
	}

}
