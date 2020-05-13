package application.modele;

public abstract class Zombie {
	private double pv;
	private int vitesse;
	private int x;
	private int y;
	
	public Zombie (int x, int y) {
		this.pv = 0;
		this.vitesse = 0;
		this.x = x;
		this.y = y;

	}

	public double getPv() {
		return pv;
	}

	public void setPv(double pv) {
		this.pv = pv;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVitesse() {
		return vitesse;
	}
	
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public String toString() {
		return "[pv=" + pv + ", vitesse=" + vitesse + ", x=" + x + ", y=" + y + "]";
	}
	
	public void seDeplacer() {
		this.setX(getX() + this.getVitesse());
		this.setY(this.getY() + this.getVitesse());
	}
	
	public void agit() {
		this.seDeplacer();
		this.toString();
	}
	

	
}
