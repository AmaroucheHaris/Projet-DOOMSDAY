package application.modele.ennemis;

import java.util.ArrayList;
import java.util.Random;

import application.modele.Environnement;
import application.modele.bfs.Coordonnes;
import application.modele.bfs.Sommet;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Zombie {
	private double pv;
	private int vitesse;
	private IntegerProperty x,y;
	private Sommet SommetsDest;
	private Environnement env;
	
	
	public Zombie (Environnement env) {
		Coordonnes coord = this.Lieuxspawn();
		this.x = new SimpleIntegerProperty(coord.getX());
		this.y = new SimpleIntegerProperty(coord.getY());
		this.pv = 0;
		this.vitesse = 0;
		this.SommetsDest = null;
		this.env = env;
		
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
	
	public Sommet getSommet() {
		return this.SommetsDest;
	}
	
	public void setSommetsDest(Sommet s) {
		this.SommetsDest = s;
	}

//	public String toString() {
//		return "[pv=" + pv + ", vitesse=" + vitesse + ", x=" + x + ", y=" + y + "]";
//	}
	
//	public void seDeplacer() {
//		Coordonnes c = this.SommetsDest.getCoordonnes();
//		if(this.getX() < c.getX()) {
//			this.setX(getX() + this.getVitesse());
//		}
//		else if(this.getX() > c.getX()) {
//			this.setX(getX() - this.getVitesse());
//		}
//		if(this.getY() < c.getY()) {
//			this.setY(getY() + this.getVitesse());
//		}
//		else if(this.getY() > c.getY()) {
//			this.setY(getY() - this.getVitesse());
//		}
//		//this.setY(this.getY() + this.getVitesse());
//		System.out.println("AFFICHAGE DEST x=   " + c.getX() + "y = " + c.getY());
//		if(getX() == c.getX() && getY() == c.getY()) {
//			this.SommetsDest = this.SommetsDest.getSommetPere();
//			if(this.SommetsDest == null) {
//				this.SommetsDest = new Sommet(new Coordonnes(448, 672));
//			}
//			System.out.println("P�re : x = " + this.SommetsDest.getCoordonnes().getX() + "y = " + this.SommetsDest.getCoordonnes().getY());
//		}
//	}
	
	public void seDeplacer() {
		Coordonnes coordZombie = new Coordonnes((this.x.getValue()/32)*32, (this.y.getValue()/32)*32);
		//System.out.println(this.env.getGraphe());
		//Coordonnes coordZombie = new Coordonnes(Math.floorDiv(this.x.getValue(), 32), Math.floorDiv(this.y.getValue(), 32));

		Sommet sommetCourant = this.env.getGraphe().chercheSommet(coordZombie);
		
		//mettre � sommetDest la valeur associ�e � sommetCourant dans la HashMap
		
		this.SommetsDest = this.env.getGraphe().getBfs().getAssociationPereFils().get(sommetCourant);
		System.out.println(SommetsDest);
		if(this.SommetsDest != null) {
			if(this.getX() < this.SommetsDest.getCoordonnes().getX()) {
				this.setX(getX() + this.getVitesse());
			}
			else if(this.getX() > this.SommetsDest.getCoordonnes().getX()) {
				this.setX(getX() - this.getVitesse());
			}
			if(this.getY() < this.SommetsDest.getCoordonnes().getY()) {
				this.setY(getY() + this.getVitesse());
			}
			else if(this.getY() > this.SommetsDest.getCoordonnes().getY()) {
				this.setY(getY() - this.getVitesse());
			}
		}
		
	}
	
	public void agit() {
		this.seDeplacer();
		//this.toString();
	}
	
	
	public double distance(Coordonnes c1) {
		double x = (c1.getX() - this.getX())*(c1.getX() - this.getX());
		double y = (c1.getY() - this.getY())*(c1.getY() - this.getY());
		y += x; 
		//System.out.println(Math.sqrt(y));
		return Math.sqrt(y);
	}
	
	public Environnement getEnvironnement() {
		return this.env;
	}
	
	public Coordonnes Lieuxspawn() {
		ArrayList<Coordonnes> listeSpawn = new ArrayList<Coordonnes>();
		listeSpawn.add(new Coordonnes(0, 96));
		listeSpawn.add(new Coordonnes(896, 96));
		listeSpawn.add(new Coordonnes(448, 32));
		
		Random rand = new Random();
		int i = rand.nextInt(3);
		
		return listeSpawn.get(i);
	}
	
	
	
	

	
}
