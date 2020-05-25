package application.modele;

import java.util.ArrayList;
import java.util.LinkedList;

public class Environnement {
	
	private int width,height;
	//private int nbTours;
	
	private boolean mancheEnCours;
	
	private ArrayList<Zombie> listeZombie;
	private ArrayList<Tourelle> listeTourelle;
	private ArrayList<Coordonnes> listeCoordonnes;
	private Graphe graphe;
	private TabMap1 tab;
	
	
	public Environnement(int width, int height, TabMap1 map) {
		this.width = width;
		this.height = height;
		this.mancheEnCours = false;
		listeZombie = new ArrayList<Zombie>();
		this.tab = map;
	//	listeTourelle = new ArrayList<Tourelle>();
		listeTourelle = new ArrayList<Tourelle>();
		//this.nbTours = 0;
		this.listeCoordonnes = new ArrayList<Coordonnes>();
		this.graphe = new Graphe();
		graphe.initSommets(this.tab.getTab());
		graphe.bfs();
		graphe.afficher();
				
	}
	
	public void unTour() {
		this.mancheEnCours = true;
		for(Zombie currentZombie : this.listeZombie) {
			//Coordonnes test = this.graphe.plusProcheCoord(currentZombie);
			//System.out.println("x= " + test.getX() + "    " +"y = " + test.getY());
			currentZombie.agit();
			
//			Coordonnes test = plusProcheCoord(currentZombie);
//			System.out.println("x= " + test.getX() + "    " +"y = " + test.getY());
//			currentZombie.agit(test);
		}
		
		
//		for(Tourelle currentTourelle : this.listeTourelle) {
//			currentTourelle.agit();
//		}
		for(Tourelle currentTourelle : this.listeTourelle) {
			currentTourelle.agir();
		}
		this.mancheEnCours = false;
	}
	
	public void initZombie() {
		for(Zombie z : this.listeZombie) {
			z.setSommetsDest(this.graphe.plusProcheCoord(z));
		}
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
		//zombie.setCoordonneesDest(coordMinimal);
		return coordMinimal;
	}
	
	
	
}
