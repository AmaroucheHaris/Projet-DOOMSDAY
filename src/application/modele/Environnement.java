package application.modele;

import java.util.ArrayList;

public class Environnement {
	
	private int width,height;
	//private int nbTours;
	
	private boolean mancheEnCours;
	
	private ArrayList<Zombie> listeZombie;
	private ArrayList<Tourelle> listeTourelle;
	private ArrayList<Coordonnes> listeCoordonnes;
	
	public Environnement(int width, int height) {
		this.width = width;
		this.height = height;
		this.mancheEnCours = false;
		listeZombie = new ArrayList<Zombie>();
		listeTourelle = new ArrayList<Tourelle>();
		//this.nbTours = 0;
		this.listeCoordonnes = new ArrayList<Coordonnes>();
	}
	
	public void unTour() {
		this.mancheEnCours = true;
		for(Zombie currentZombie : this.listeZombie) {
			Coordonnes test = plusProcheCoord(currentZombie);
//			System.out.println("x= " + test.getX() + "    " +"y = " + test.getY());
			currentZombie.agit(test);
		}
		
		for(Tourelle currentTourelle : this.listeTourelle) {
			currentTourelle.agir();
		}
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
	
	public ArrayList<Tourelle> getListeTourelles(){
		return this.listeTourelle;
	}
	
	public void initSommets() {
		this.listeCoordonnes.add(new Coordonnes(105, 300));
		this.listeCoordonnes.add(new Coordonnes(285, 300));
		this.listeCoordonnes.add(new Coordonnes(435, 300));
		this.listeCoordonnes.add(new Coordonnes(580, 300));
		this.listeCoordonnes.add(new Coordonnes(760, 300));
		this.listeCoordonnes.add(new Coordonnes(105, 520));
		this.listeCoordonnes.add(new Coordonnes(435, 520));
		this.listeCoordonnes.add(new Coordonnes(580, 520));
		this.listeCoordonnes.add(new Coordonnes(580, 100));
		this.listeCoordonnes.add(new Coordonnes(435, 100));
		this.listeCoordonnes.add(new Coordonnes(285, 100));
	}
	
	public Coordonnes plusProcheCoord(Zombie zombie) {
		boolean test = false;
		if(zombie.getCoordonnesDest() != null) {
			return zombie.getCoordonnesDest();
		}
		double distance = 1000;
		Coordonnes coordMinimal = new Coordonnes(0, 0);
		//System.out.println(listeCoordonnes.size());
		for(Coordonnes coord : this.listeCoordonnes) {
			if(zombie.distance(coord) != 0) {
				if(distance > zombie.distance(coord)) {
				distance = zombie.distance(coord);
				coordMinimal.setX(coord.getX());
				coordMinimal.setY(coord.getY());

				}
			}
		}
		zombie.setCoordonneesDest(coordMinimal);
		return coordMinimal;
	}
	
	
	
}
