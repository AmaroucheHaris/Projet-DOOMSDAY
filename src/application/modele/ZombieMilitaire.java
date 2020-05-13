package application.modele;

public class ZombieMilitaire extends Zombie{

	private int probaAbsorbe;
	
	public ZombieMilitaire(int x, int y) {
		super(x, y);
		this.setVitesse(3);
		this.probaAbsorbe = 20;
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + super.toString() + "probaAbsorbe = " + this.probaAbsorbe; 
	}

	
}
