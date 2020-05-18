package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tourelle {
	
	private IntegerProperty x, y;
	private int degat;
	private int vitesseAttack;
	private int precision;
	private int portee;
	private String id;
	private static int compteurId = 0;
	private Environnement env;
	
	public Tourelle(int x, int y, Environnement env, int degat, int vitesseAttack, int precision, int portee) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
		this.env = env;
		this.degat = degat;
		this.vitesseAttack = vitesseAttack;
		this.precision = precision;
		this.portee = portee;
		compteurId++;
		this.id = "T" + compteurId;
	}
	
	public int getX() {
		return this.x.getValue();
	}
	
	public void setX(int x) {
		this.x.setValue(x);
	}
	
	public IntegerProperty getXProperty() {
		return this.x;
	}
	
	public int getY() {
		return this.y.getValue();
	}
	
	public void setY(int y) {
		this.y.setValue(y);
	}

	public IntegerProperty getYProperty() {
		return this.y;
	}
	
	public Environnement getEnv() {
		return this.env;
	}
	
	public int getDegat() {
		return this.degat;
	}
	
	public int getVitesseAttack() {
		return this.vitesseAttack;
	}
	
	public int getPrecision() {
		return this.precision;
	}
	
	public int getPortee() {
		return this.portee;
	}
	
	public abstract Zombie detecter(Environnement env);
	
	public abstract void agir();
	
	public String toString() {
		return "[ x= " + this.x + ", y= " + this.y + ", degat= " + this.degat + ", vitesse d'attaque= " + this.vitesseAttack + ", précision=" + this.precision + ", portée= " + this.precision +" ]";
	}
}
