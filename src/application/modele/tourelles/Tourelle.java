package application.modele.tourelles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.modele.Environnement;
import application.modele.ennemis.Zombie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Tourelle {
	
	private int x, y;
	private int degat;
	private int vitesseAttack;
	private int precision;
	private int portee;
	private String id;
	private static int compteurId = 0;
	private Environnement env;
	private Image image;
	private ImageView sprite;
	
	public Tourelle(int x, int y, Environnement env, int degat, int vitesseAttack, int precision, int portee) {
		this.x = x;
		this.y = y;
		this.env = env;
		this.degat = degat;
		this.vitesseAttack = vitesseAttack;
		this.precision = precision;
		this.portee = portee;
		compteurId++;
		this.id = "T" + compteurId;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
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
	
	public ImageView initSpriteTourelle(int x, int y) {
		this.env.getListeTourelles().add(this);
		if(this instanceof TireurDeBase) {
			try {
				this.image = new Image(new FileInputStream("src/application/vue/ressources/tourelles/TourelleBase.png"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			this.sprite = new ImageView(this.image);
			this.sprite.setX(x);
			this.sprite.setY(y);
		}
		return this.sprite;
	}

	public abstract Zombie detecter(Environnement env);
	
	public abstract void agir();
	
	public String toString() {
		return "[ x= " + this.x + ", y= " + this.y + ", degat= " + this.degat + ", vitesse d'attaque= " + this.vitesseAttack + ", précision=" + this.precision + ", portée= " + this.portee +" ]";
	}
}
