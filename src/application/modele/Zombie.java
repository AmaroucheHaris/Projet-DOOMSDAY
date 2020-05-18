package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Zombie {
	private double pv;
	private int vitesse;
	private IntegerProperty x,y;
	private Coordonnes coordonneesDest;
	
	
	public Zombie (int x, int y) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		this.pv = 0;
		this.vitesse = 0;
		this.coordonneesDest = null;
		
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
	
	public Coordonnes getCoordonnesDest() {
		return this.coordonneesDest;
	}
	
	public void setCoordonneesDest(Coordonnes c) {
		this.coordonneesDest = c;
	}

//	public String toString() {
//		return "[pv=" + pv + ", vitesse=" + vitesse + ", x=" + x + ", y=" + y + "]";
//	}
	
	public void seDeplacer(Coordonnes c) {
		if(this.getX() < c.getX()) {
			this.setX(getX() + this.getVitesse());
		}
		else if(this.getX() > c.getX()) {
			this.setX(getX() - this.getVitesse());
		}
		if(this.getY() < c.getY()) {
			this.setY(getY() + this.getVitesse());
		}
		else if(this.getY() > c.getY()) {
			this.setY(getY() - this.getVitesse());
		}
		//this.setY(this.getY() + this.getVitesse());
		System.out.println(this.toString());
		if(getX() == c.getX() && getY() == c.getY()) {
			this.coordonneesDest = null;
		}
	}
	
	public void agit(Coordonnes c) {
		this.seDeplacer(c);
//		this.toString();
	}
	
	
	public double distance(Coordonnes c1) {
		double x = (c1.getX() - this.getX())*(c1.getX() - this.getX());
		double y = (c1.getY() - this.getY())*(c1.getY() - this.getY());
		y += x; 
		//System.out.println(Math.sqrt(y));
		return Math.sqrt(y);
	}
	
	

	
}
