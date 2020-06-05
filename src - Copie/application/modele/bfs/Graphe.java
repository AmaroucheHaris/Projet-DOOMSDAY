package application.modele.bfs;

import java.util.ArrayList;
import java.util.LinkedList;

import application.modele.ennemis.Zombie;

public class Graphe {
	// private LinkedList<Sommet> listeSommets;
	private ArrayList<Sommet> listeSommets;
	private Sommet sommetDeDepart;
	private int[][] matrice;
	private Bfs bfs;

	public Graphe(int[][] matrice) {
		// this.listeSommets = new LinkedList<Sommet>();
		this.listeSommets = new ArrayList<Sommet>();
		this.sommetDeDepart = new Sommet(new Coordonnes(448, 672));
		this.matrice = matrice;
		initSommets();
		this.bfs = new Bfs(this);
	}

	public void initSommets() {


		for (int ligne = 0; ligne < matrice.length; ligne++) {

			for (int colonne = 0; colonne < matrice[ligne].length; colonne++) {


				if (matrice[ligne][colonne] == 2) {

					Sommet s = new Sommet(new Coordonnes(32 * colonne, 32 * ligne));

					this.listeSommets.add(s);
				}
			}
		}
		for (Sommet s : this.listeSommets) {
			for (Sommet sommetTest : this.listeSommets) {
				if (s.estAdjacent(sommetTest)) {
					s.ajouterSommet(sommetTest);
				}

			}
		}
	}

	public Sommet plusProcheCoord(Zombie zombie) {
		boolean test = false;
		Sommet tmpSommet = null;
//		if(zombie.getSommet() != null) {
//			//System.out.println("je suis un com");
//			return zombie.getCoordonnesDest();
//		}
		double distance = 1000;
		Coordonnes coordMinimal = new Coordonnes(0, 0);

		for (Sommet sommet : this.listeSommets) {
			if (zombie.distance(sommet.getCoordonnes()) == 0) {
//				if(distance > zombie.distance(sommet.getCoordonnes())) {
//					tmpSommet = sommet;
//					distance = zombie.distance(sommet.getCoordonnes());
//					coordMinimal.setX(sommet.getCoordonnes().getX());
//					coordMinimal.setY(sommet.getCoordonnes().getY());
//	
				// }
				return sommet;
			}
		}
		return null;
		// System.out.println("tmpSommet x= " + tmpSommet.getCoordonnes().getX() + "y= "
		// + tmpSommet.getCoordonnes().getY());
	}

	public Sommet getSommetDeDepart(Coordonnes coord) {
		Sommet depart = chercheSommet(coord);
		return depart;
	}

	

//	public void dijskra() {
//		this.sommetDeDepart = this.listeSommets.get(0);
//		this.sommetDeDepart.setDistance(0);
//		boolean continuer = true;
//		Sommets sommetCourant = sommetDeDepart;
//		
//		while(continuer) {
//			calculeMinDistance(sommetCourant);
//			sommetCourant.setExplore(true);
//			sommetCourant = sommetMin();
//			
//			
//			if(sommetCourant == null) continuer = false;
//		}
//	}

//	public void bfs() {
//		LinkedList<Sommet> liste = new LinkedList<Sommet>();
//		this.sommetDeDepart = this.listeSommets.get(getIndice(new Sommet(new Coordonnes(448, 672))));
//		this.sommetDeDepart.setDistance(0);
//		System.out.println("Sommet de d�part :  x= " + sommetDeDepart.getCoordonnes().getX() + " y = " + sommetDeDepart.getCoordonnes().getY());
//		boolean continuer = true;
//		Sommet sommetCourant = sommetDeDepart;
//		liste.addLast(sommetCourant);
//		
//		while(continuer) {
//			sommetCourant = liste.getLast();
//			sommetCourant.setExplore(true);
//			explorerFils(sommetCourant, liste);
//			liste.remove(getIndiceV2(sommetCourant, liste));
//			if(liste.size() == 0) continuer = false;
//		}
//	}

//	public Sommet sommetMin() {
//		Sommet s1 = null;
//		double distance = 1000;
//		
//		for(Sommet sommet : this.listeSommets) {
//			if(sommet.isExplore() == false && sommet.getDistance()<distance) {
//				distance = sommet.getDistance();
//				s1 = sommet;
//			}
//		}
//		return s1;
//	}
//	public double distanceEntreDeuxCoord(Coordonnes c1, Coordonnes c2 ) {
//		double x = (c1.getX() - c2.getX())*(c1.getX() - c2.getX());
//		double y = (c1.getY() - c2.getY())*(c1.getY() - c2.getY());
//		y += x; 
//		//System.out.println(Math.sqrt(y));
//		return Math.sqrt(y);
//	}
//	
//	public void calculeMinDistance(Sommet sommetCourant) {
//		double distance;
//		System.out.println(sommetCourant.getListeSommetsAccessible().size());
//		for(Sommet sommet : sommetCourant.getListeSommetsAccessible()) {
//			distance = sommetCourant.getDistance() + distanceEntreDeuxCoord(sommetCourant.getCoordonnes(), sommet.getCoordonnes());
//			System.out.println(sommet.getDistance() + "p�re = " + sommetCourant.getDistance());
//			if(sommet.getDistance() >  distance) {
//				sommet.setDistance(distance);
//				sommet.setSommetPere(sommetCourant);
//			}
//		}
//	}
//	
//	public void afficher() {
//		for(Sommet sommet : this.listeSommets) {
//			if(sommet.getSommetPere() != null) {
//				System.out.println(" x = " + sommet.getCoordonnes().getX() + " Y = " + sommet.getCoordonnes().getY() + " distance = " + sommet.getDistance() + "p�re " + sommet.getSommetPere().getCoordonnes().getX() + " Y= " + sommet.getSommetPere().getCoordonnes().getY()+ " taille : " + sommet.getListeSommetsAccessible().size());
//				sommet.afficheFils();
//			}
//			else {
//				System.out.println(" x = " + sommet.getCoordonnes().getX() + " Y = " + sommet.getCoordonnes().getY() + " distance = " + sommet.getDistance() + " taille : " + sommet.getListeSommetsAccessible().size());
//				sommet.afficheFils();
//			}
//		}
//	}
//	
//	public void explorerFils(Sommet sommetCourant, LinkedList<Sommet> listeSommets) {
//		LinkedList<Sommet> liste = new LinkedList<Sommet>();
//		liste.addAll(listeSommets);
//		for(Sommet s : liste) {
//			for(Sommet sommet : s.getListeSommetsAccessible()) {
//				if(sommet.isExplore() == false) {
//					sommet.setExplore(true);
//					sommet.setDistance(s.getDistance()+1);
//					sommet.setSommetPere(s);
//					listeSommets.addLast(sommet);
//				}
//			}
//		}
//	}
//	public void afficherListeSommets() {
//		for(Sommet sommet : this.listeSommets) {
//			System.out.println("x = " + sommet.getCoordonnes().getX() + " y = " + sommet.getCoordonnes().getY());
//		}
//	}
//	
//	public boolean contain(Sommet s) {
//		for(Sommet sommet : this.listeSommets) {
//			if(s.getCoordonnes().getX() == sommet.getCoordonnes().getX() && s.getCoordonnes().getY() == sommet.getCoordonnes().getY()) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public int getIndice(Sommet s) {
//		int cpt = 0;
//		for(Sommet sommet : this.listeSommets) {
//			if(s.getCoordonnes().getX() == sommet.getCoordonnes().getX() && s.getCoordonnes().getY() == sommet.getCoordonnes().getY()) {
//				return cpt;
//			}
//		cpt++;
//		}
//		return -1;
//	}
//	public int getIndiceV2(Sommet s, LinkedList<Sommet> liste) {
//		int cpt = 0;
//		for(Sommet sommet : liste) {
//			if(s.getCoordonnes().getX() == sommet.getCoordonnes().getX() && s.getCoordonnes().getY() == sommet.getCoordonnes().getY()) {
//				return cpt;
//			}
//		cpt++;
//		}
//		return -1;
//	}
//	
//	public void test(int y) {
//		for(Sommet sommet : listeSommets) {
//			if(sommet.getCoordonnes().getX() == y) {
//				System.out.println(" x = " + sommet.getCoordonnes().getX() + " Y = " + sommet.getCoordonnes().getY() + " distance = " + sommet.getDistance() +  " taille : " + sommet.getListeSommetsAccessible().size());
//				sommet.afficheFils();
//			}
//		}
//	}

	public Bfs getBfs() {
		return this.bfs;
	}

	public Sommet chercheSommet(Coordonnes coord) {
		for (Sommet s : this.listeSommets) {
			//System.out.println(s);
			if (s.getCoordonnes().equals(coord)) {
				return s;
			}
		}
		// System.out.println("test");
		return null;
	}
}
