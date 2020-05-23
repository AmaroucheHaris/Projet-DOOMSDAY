package application.modele;

import java.util.ArrayList;

public class Sommets {
	private Coordonnes coordonnes;
	private boolean explore;
	private ArrayList<Sommets> listeSommetsAccessible;
	private Sommets sommetPere;
	private double distance = 1000;
	
	public Sommets(Coordonnes coord) {
		this.coordonnes = coord;
		this.explore = false;
		this.listeSommetsAccessible = new ArrayList<Sommets>();
		this.sommetPere = null;
	}
	
	public void ajouterListeSommetAccessible(Sommets sommet) {
		this.listeSommetsAccessible.add(sommet);
	}

	public Coordonnes getCoordonnes() {
		return coordonnes;
	}

	public void setCoordonnes(Coordonnes coordonnes) {
		this.coordonnes = coordonnes;
	}

	public boolean isExplore() {
		return explore;
	}

	public void setExplore(boolean explore) {
		this.explore = explore;
	}

	public ArrayList<Sommets> getListeSommetsAccessible() {
		return listeSommetsAccessible;
	}

	public void setListeSommetsAccessible(ArrayList<Sommets> listeSommetsAccessible) {
		this.listeSommetsAccessible = listeSommetsAccessible;
	}

	public Sommets getSommetPere() {
		return this.sommetPere;
	}

	public void setSommetPere(Sommets sommetPere) {
		this.sommetPere = sommetPere;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public void ajouterSommet(Sommets s) {
		if(contain(s)==false) {
			this.listeSommetsAccessible.add(s);
			}
	}
	
	public boolean contain(Sommets s) {
		if(s.getCoordonnes().getX() == this.coordonnes.getX() && s.getCoordonnes().getY() == this.coordonnes.getY()) {
			return true;
		}
		for(Sommets sommet : this.listeSommetsAccessible) {
			if(s.getCoordonnes().getX() == sommet.getCoordonnes().getX() && s.getCoordonnes().getY() == sommet.getCoordonnes().getY()) {
				return true;
			}
		}
		return false;
	}
	
	public void afficheFils() {
		for(Sommets s : listeSommetsAccessible) {
			System.out.println("fils : " + "x= " + s.getCoordonnes().getX() + "y= " + s.getCoordonnes().getY());
		}
	}
	
	
}
