package application.modele;

import java.util.ArrayList;
import java.util.LinkedList;

public class Environnement {
	
	private int width,height;
	private int nbTours;
	
	private boolean mancheEnCours;
	
	private ArrayList<Zombie> listeZombie;
	//private ArrayList<Tourelle> listeTourelle;
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
		this.nbTours = 0;
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
			
		}
		
		
//		for(Tourelle currentTourelle : this.listeTourelle) {
//			currentTourelle.agit();
//		}
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
	
//	public void creerGraphe (int[][] matrice, int nbLigne, int nbColonne, Coordonnes coordDeDepart) {
//		boolean continuer = true;
//		LinkedList<Sommets> listeSommet = new LinkedList<Sommets>();
//		
//		Coordonnes c1 = new Coordonnes(470, 680);
//		listeSommet.addLast(new Sommets(c1));
//		
//		int x,y;
//		x = coordDeDepart.getX();
//		y = coordDeDepart.getY();
//		while(continuer) {
//			// quatre possibilitées: 
//			// 1. partir à gauche(x-1 > 0 && matrice [x-1][y] == 2) 
//			// 2. partir à droite(x+1 < nbColonne && matrice [x+1][y] == 2
//			// 3. monter (y-1 > 0 && matrice [x][y-1]== 2
//			// 4. monter (y+1 < nbLigne && matrice [x][y+1]== 2
//
//		}
//	}
}
