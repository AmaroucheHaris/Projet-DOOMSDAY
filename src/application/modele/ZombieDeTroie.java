package application.modele;

public class ZombieDeTroie extends Zombie{

	public ZombieDeTroie(int x, int y) {
		super(x, y);
		this.setPv(30);
		this.setVitesse(2);
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + super.toString();
	}

}
