package application.modele;

import java.util.ArrayList;

public class Environnement {
	
	private int width,height;
	
	private boolean mancheEnCours;
	
	private ArrayList<Zombie> listeZombie;
	//private ArrayList<Tourelle> listeTourelle;
	
	public Environnement(int width, int height) {
		this.width = width;
		this.height = height;
		this.mancheEnCours = false;
		listeZombie = new ArrayList<Zombie>();
	//	listeTourelle = new ArrayList<Tourelle>();
	}
	
	public void unTour() {
		this.mancheEnCours = true;
		for(Zombie currentZombie : this.listeZombie) {
			currentZombie.agit();
		}
		
//		for(Tourelle currentTourelle : this.listeTourelle) {
//			currentTourelle.agit();
//		}
		this.mancheEnCours = false;
	}
	
	public boolean getMancheEnCours() {
		return this.mancheEnCours;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public ArrayList<Zombie> getListeZombies(){
		return this.listeZombie;
	}
}
