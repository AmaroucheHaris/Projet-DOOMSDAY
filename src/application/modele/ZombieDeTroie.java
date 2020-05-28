package application.modele;

public class ZombieDeTroie extends Zombie{

	public ZombieDeTroie(int x, int y, Environnement env) {
		super(x, y, env);
		this.setPv(30);
		this.setVitesse(2);
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + super.toString();
	}

}
