package application.modele;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Zombie {
	private double pv;
	private int vitesse;
	private IntegerProperty x,y;
	private Sommets SommetsDest;
	private Environnement env;
	
	
	public Zombie (int x, int y) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		this.pv = 0;
		this.vitesse = 0;
		this.SommetsDest = null;
		
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
		return this.SommetsDest.getCoordonnes();
	}
	
	public Sommets getSommet() {
		return this.SommetsDest;
	}
	
	public void setSommetsDest(Sommets s) {
		this.SommetsDest = s;
	}

	public String toString() {
		return "[pv=" + pv + ", vitesse=" + vitesse + ", x=" + x + ", y=" + y + "]";
	}
	
	public void seDeplacer() {
		Coordonnes c = this.SommetsDest.getCoordonnes();
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
		System.out.println("AFFICHAGE DEST x=   " + c.getX() + "y = " + c.getY());
		if(getX() == c.getX() && getY() == c.getY()) {
			this.SommetsDest = this.SommetsDest.getSommetPere();
			if(this.SommetsDest == null) {
				this.SommetsDest = new Sommets(new Coordonnes(448, 672));
			}
			System.out.println("Père : x = " + this.SommetsDest.getCoordonnes().getX() + "y = " + this.SommetsDest.getCoordonnes().getY());
		}
	}
	
	public void agit() {
		this.seDeplacer();
		this.toString();
	}
	
	
	public double distance(Coordonnes c1) {
		double x = (c1.getX() - this.getX())*(c1.getX() - this.getX());
		double y = (c1.getY() - this.getY())*(c1.getY() - this.getY());
		y += x; 
		//System.out.println(Math.sqrt(y));
		return Math.sqrt(y);
	}
	
	
	
	

	
}
