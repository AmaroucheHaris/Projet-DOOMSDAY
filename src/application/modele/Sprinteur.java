package application.modele;

public class Sprinteur extends Zombie{

	public Sprinteur(int x, int y, Environnement env) {
		super(x, y, env);
		this.setPv(15);
		this.setVitesse(1);
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + super.toString(); 
	}

}
