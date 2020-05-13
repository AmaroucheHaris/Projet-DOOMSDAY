package application.modele;

public class Sprinteur extends Zombie{

	public Sprinteur(int x, int y) {
		super(x, y);
		this.setPv(15);
		this.setVitesse(5);
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + super.toString(); 
	}

}
