package application.modele;

public abstract class Tourelle {
	
	private int x;
	private int y;
	private int degat;
	private int vitesseAttack;
	private int precision;
	private int portee;
	private String id;
	private static int compteurId = 0;
	
	public Tourelle(int x, int y, int degat, int vitesseAttack, int precision, int portee) {
		this.x = x;
		this.y = y;
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
	
	public int setX(int x) {
		return this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int setY(int y) {
		return this.y = y;
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
	
	public abstract boolean detecter();
	
	public String toString() {
		return "[ x= " + this.x + ", y= " + this.y + ", degat= " + this.degat + ", vitesse d'attaque= " + this.vitesseAttack + ", précision=" + this.precision + ", portée= " + this.precision +" ]";
	}
}
