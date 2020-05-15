package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Zombie {
	private double pv;
	private int vitesse;
	private IntegerProperty x,y;
	
	public Zombie (int x, int y) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		this.pv = 0;
		this.vitesse = 0;
	}

	public double getPv() {
		return pv;
	}

	public void setPv(double pv) {
		this.pv = pv;
	}

	public int getX() {
		return x.getValue();
	}
	
	public IntegerProperty getXProperty() {
		return this.x;
	}

	public void setX(int x) {
		this.x.setValue(x);
	}

	public double getY() {
		return y.getValue();
	}
	
	public IntegerProperty getYProperty() {
		return this.y;
	}

	public void setY(double y) {
		this.y.setValue(y);;
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