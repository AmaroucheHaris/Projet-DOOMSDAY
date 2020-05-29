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
//	public void initSommets() {
//		
//		Sommets sommet1 = new Sommets(new Coordonnes(105, 300));
//		Sommets sommet2 = new Sommets(new Coordonnes(285, 300));
//		Sommets sommet3 = new Sommets(new Coordonnes(470, 300));
//		Sommets sommet4 = new Sommets(new Coordonnes(580, 300));
//		Sommets sommet5 = new Sommets(new Coordonnes(760, 300));
//		Sommets sommet6 = new Sommets(new Coordonnes(105, 520));
//		Sommets sommet7 = new Sommets(new Coordonnes(470, 520));
//		Sommets sommet8 = new Sommets(new Coordonnes(760, 520));
//		Sommets sommet9 = new Sommets(new Coordonnes(580, 100));
//		Sommets sommet10 = new Sommets(new Coordonnes(470, 100));
//		Sommets sommet11 = new Sommets(new Coordonnes(285, 100));
//		
//
//		// matrice d'adjacense 
//		
//		sommet1.ajouterListeSommetAccessible(sommet2);
//		sommet1.ajouterListeSommetAccessible(sommet6);
//		
//		sommet2.ajouterListeSommetAccessible(sommet1);
//		sommet2.ajouterListeSommetAccessible(sommet3);
//		sommet2.ajouterListeSommetAccessible(sommet11);
//
//		sommet3.ajouterListeSommetAccessible(sommet2);
//		sommet3.ajouterListeSommetAccessible(sommet4);
//		sommet3.ajouterListeSommetAccessible(sommet7);
//		
//		sommet4.ajouterListeSommetAccessible(sommet3);
//		sommet4.ajouterListeSommetAccessible(sommet5);
//		sommet4.ajouterListeSommetAccessible(sommet9);
//		
//		sommet5.ajouterListeSommetAccessible(sommet4);
//		sommet5.ajouterListeSommetAccessible(sommet8);
//		
//		sommet6.ajouterListeSommetAccessible(sommet7);
//		sommet6.ajouterListeSommetAccessible(sommet1);
//		
//		sommet7.ajouterListeSommetAccessible(sommet6);
//		sommet7.ajouterListeSommetAccessible(sommet8);
//		sommet7.ajouterListeSommetAccessible(sommet3);
//		
//		sommet8.ajouterListeSommetAccessible(sommet7);
//		sommet8.ajouterListeSommetAccessible(sommet5);
//		
//		sommet9.ajouterListeSommetAccessible(sommet4);
//		sommet9.ajouterListeSommetAccessible(sommet10);
//		
//		sommet10.ajouterListeSommetAccessible(sommet9);
//		sommet10.ajouterListeSommetAccessible(sommet11);
//		
//		sommet11.ajouterListeSommetAccessible(sommet10);
//		sommet11.ajouterListeSommetAccessible(sommet2);
//		
//		this.listeSommets.add(sommet1);
//		this.listeSommets.add(sommet2);
//		this.listeSommets.add(sommet3);
//		this.listeSommets.add(sommet4);
//		this.listeSommets.add(sommet5);
//		this.listeSommets.add(sommet6);
//		this.listeSommets.add(sommet7);
//		this.listeSommets.add(sommet8);
//		this.listeSommets.add(sommet9);
//		this.listeSommets.add(sommet10);
//		this.listeSommets.add(sommet11);
//	}

	public void initSommets() {
//		boolean continuer = true;
//		System.out.println("Sommet de départ V1 :  x= " + sommetDeDepart.getCoordonnes().getX() + " y = " + sommetDeDepart.getCoordonnes().getX());
//		this.sommetDeDepart.setCoordonnes(new Coordonnes(448, 640));
//		this.listeSommets.addLast(this.sommetDeDepart);

		for (int ligne = 0; ligne < matrice.length; ligne++) {

			for (int colonne = 0; colonne < matrice[ligne].length; colonne++) {

				// Sommet verifSommet = new Sommet(new Coordonnes(32*colonne, 32*ligne));

				if (matrice[ligne][colonne] == 2) {

					// Sommet s1 = verifSommet;
					Sommet s = new Sommet(new Coordonnes(32 * colonne, 32 * ligne));

					// s1 = this.listeSommets.get(getIndice(s1));
					this.listeSommets.add(s);
				}
			}
		}
		System.out.println(this.listeSommets);
		System.out.println(this.listeSommets.size());
		for (Sommet s : this.listeSommets) {
			for (Sommet sommetTest : this.listeSommets) {
				if (s.estAdjacent(sommetTest)) {
					// System.out.println(sommetTest);
					s.ajouterSommet(sommetTest);
				}

			}
			// System.out.println(s);
		}

//					//this.listeSommets.addLast(s1);
//					
//					//regarde à gauche
//					Coordonnes nouvelleCoordVerif = new Coordonnes(32*(colonne -1), 32*ligne);
//					s.setCoordonnes(nouvelleCoordVerif);
//					
//					if(colonne - 1 >= 0 && matrice[ligne][colonne - 1] == 2) {
//						if(contain(s1)) {
//							s1 = this.listeSommets.get(getIndice(s1));
//						}
//						Sommet s2 = new Sommet(new Coordonnes(32*(colonne -1), 32*ligne));
//						if(contain(s2)) {
//							s2 = this.listeSommets.get(getIndice(s2));
//						}
//						s1.ajouterSommet(s2);
//						s2.ajouterSommet(s1);
//						if(contain(s1)==false) {
//							this.listeSommets.addLast(s1);
//						}
//						else {
//							listeSommets.remove(getIndice(s1));
//							listeSommets.addLast(s1);
//						}
//						if(contain(s2)==false) {
//							this.listeSommets.addLast(s2);
//						}
//						else {
//							listeSommets.remove(getIndice(s2));
//							listeSommets.addLast(s2);
//						}
//						
//
//					}
//					
//					//regarde à droite
//					
//					nouvelleCoordVerif = new Coordonnes(32*(colonne +1), 32*ligne);
//					s.setCoordonnes(nouvelleCoordVerif);
//					
//					if(colonne+1 < matrice[ligne].length && matrice[ligne][colonne+1] == 2) {
//						if(contain(s1)) {
//							s1 = this.listeSommets.get(getIndice(s1));
//						}
//						Sommet s3 = new Sommet(new Coordonnes(32*(colonne +1), 32*ligne));
//						if(contain(s3)) {
//							s3 = this.listeSommets.get(getIndice(s3));
//						}
//						s1.ajouterSommet(s3);
//						s3.ajouterSommet(s1);
//						if(contain(s1)==false) {
//							this.listeSommets.addLast(s1);
//						}
//						else {
//							listeSommets.remove(getIndice(s1));
//							listeSommets.addLast(s1);
//						}
//						if(contain(s3)==false) {
//							this.listeSommets.addLast(s3);
//						}
//						else {
//							listeSommets.remove(getIndice(s3));
//							listeSommets.addLast(s3);
//						}
//
//					}
//					
//					//regarde en haut
//					
//					nouvelleCoordVerif = new Coordonnes(32*colonne, 32*(ligne-1));
//					s.setCoordonnes(nouvelleCoordVerif);
//					
//					if(ligne-1 >= 0 && matrice[ligne-1][colonne] == 2) {
//						if(contain(s1)) {
//							s1 = this.listeSommets.get(getIndice(s1));
//						}
//						Sommet s4 = new Sommet(new Coordonnes(32*colonne, 32*(ligne-1)));
//						if(contain(s4)) {
//							s4 = this.listeSommets.get(getIndice(s4));
//						}
//						s1.ajouterSommet(s4);
//						s4.ajouterSommet(s1);
//						if(contain(s1)==false) {
//							this.listeSommets.addLast(s1);
//						}
//						else {
//							listeSommets.remove(getIndice(s1));
//							listeSommets.addLast(s1);
//						}
//						if(contain(s4)==false) {
//							this.listeSommets.addLast(s4);
//						}
//						else {
//							listeSommets.remove(getIndice(s4));
//							listeSommets.addLast(s4);
//						}
//
//					}
//					
//					//regarde en bas
//					
//					nouvelleCoordVerif = new Coordonnes(32*colonne, 32*(ligne+1));
//					s.setCoordonnes(nouvelleCoordVerif);
//					
//					if(ligne+1 < matrice.length && matrice[ligne+1][colonne] == 2 ) {
//						if(contain(s1)) {
//							s1 = this.listeSommets.get(getIndice(s1));
//						}
//						Sommet s5 = new Sommet(new Coordonnes(32*colonne, 32*(ligne+1)));
//						if(contain(s5)) {
//							s5 = this.listeSommets.get(getIndice(s5));
//						}
//						s1.ajouterSommet(s5);
//						s5.ajouterSommet(s1);
//						if(contain(s1)==false) {
//							this.listeSommets.addLast(s1);
//						}
//						else {
//							listeSommets.remove(getIndice(s1));
//							listeSommets.addLast(s1);
//						}
//						if(contain(s5)==false) {
//							this.listeSommets.addLast(s5);
//						}
//						else {
//							listeSommets.remove(getIndice(s5));
//							listeSommets.addLast(s5);
//						}
//
//
//					}
//				}
//				
//				
//			}
//		}

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
//		System.out.println("Sommet de départ :  x= " + sommetDeDepart.getCoordonnes().getX() + " y = " + sommetDeDepart.getCoordonnes().getY());
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
//			System.out.println(sommet.getDistance() + "père = " + sommetCourant.getDistance());
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
//				System.out.println(" x = " + sommet.getCoordonnes().getX() + " Y = " + sommet.getCoordonnes().getY() + " distance = " + sommet.getDistance() + "père " + sommet.getSommetPere().getCoordonnes().getX() + " Y= " + sommet.getSommetPere().getCoordonnes().getY()+ " taille : " + sommet.getListeSommetsAccessible().size());
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
