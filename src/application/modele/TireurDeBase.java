package application.modele;

public class TireurDeBase extends Tourelle {

	public TireurDeBase(int x, int y, int degat, int vitesseAttack, int precision, int portee) {
		super(x, y, degat, vitesseAttack, precision, portee);
	}
	
	public String toString() {
		return "Type Tourelle : " + this.getClass().getName() + super.toString();
	}

}
