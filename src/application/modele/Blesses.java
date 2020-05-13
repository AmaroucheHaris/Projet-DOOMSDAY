package application.modele;

public class Blesses extends Zombie{
	
	boolean estDetecter;

	public Blesses(int x, int y) {
		super(x, y);
		this.setPv(5);
		this.setVitesse(3);
		this.estDetecter = false;
		
	}

}
